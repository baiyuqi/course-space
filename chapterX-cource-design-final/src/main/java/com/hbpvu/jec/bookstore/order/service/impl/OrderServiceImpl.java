package com.hbpvu.jec.bookstore.order.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.billing.service.AddressService;
import com.hbpvu.jec.bookstore.billing.web.GetAddressResponse;
import com.hbpvu.jec.bookstore.commons.exception.RunTimeExceptionPlaceHolder;
import com.hbpvu.jec.bookstore.order.repository.OrderBillingAddressRepository;
import com.hbpvu.jec.bookstore.order.repository.OrderItemRepository;
import com.hbpvu.jec.bookstore.order.repository.OrderRepository;
import com.hbpvu.jec.bookstore.order.repository.OrderShippingAddressRepository;
import com.hbpvu.jec.bookstore.order.repository.dao.Cart;
import com.hbpvu.jec.bookstore.order.repository.dao.CartItem;
import com.hbpvu.jec.bookstore.order.repository.dao.Order;
import com.hbpvu.jec.bookstore.order.repository.dao.OrderBillingAddress;
import com.hbpvu.jec.bookstore.order.repository.dao.OrderItem;
import com.hbpvu.jec.bookstore.order.repository.dao.OrderShippingAddress;
import com.hbpvu.jec.bookstore.order.service.CartItemService;
import com.hbpvu.jec.bookstore.order.service.CartService;
import com.hbpvu.jec.bookstore.order.service.OrderService;
import com.hbpvu.jec.bookstore.order.web.Card;
import com.hbpvu.jec.bookstore.order.web.CreateOrderRequest;
import com.hbpvu.jec.bookstore.order.web.CreateOrderResponse;
import com.hbpvu.jec.bookstore.order.web.PreviewOrderRequest;
import com.hbpvu.jec.bookstore.order.web.PreviewOrderResponse;
import com.hbpvu.jec.bookstore.payment.service.PaymentMethodService;
import com.hbpvu.jec.bookstore.payment.service.PaymentsService;
import com.hbpvu.jec.bookstore.payment.web.CreatePaymentRequest;
import com.hbpvu.jec.bookstore.payment.web.CreatePaymentResponse;
import com.hbpvu.jec.bookstore.payment.web.GetPaymentMethodResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-09-20
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderBillingAddressRepository orderBillingAddressRepository;

    @Autowired
    OrderShippingAddressRepository orderShippingAddressRepository;

    @Autowired
    CartService cartService;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    AddressService billingFeignClient;

    @Autowired
    PaymentsService paymentFeignClient;

    @Autowired
    PaymentMethodService paymentMethodService;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = authentication.getName();

        //TODO make transactional
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();

        //Get Billing Address
        GetAddressResponse billingAddress = null;
        if (createOrderRequest.getBillingAddressId() != null && !createOrderRequest.getBillingAddressId().isEmpty()) {
            billingAddress = billingFeignClient.getAddressById(createOrderRequest.getBillingAddressId());
            OrderBillingAddress orderBillingAddress = new OrderBillingAddress();
            BeanUtils.copyProperties(billingAddress, orderBillingAddress);
            createOrderResponse.setBillingAddress(orderBillingAddress);
        }

        //Get Shipping Address
        GetAddressResponse shippingAddress = null;
        if (createOrderRequest.getShippingAddressId() != null && !createOrderRequest.getShippingAddressId().isEmpty()) {
            shippingAddress = billingFeignClient.getAddressById(createOrderRequest.getShippingAddressId());
            billingAddress = shippingAddress;

            if (createOrderRequest.getBillingAddressId() == null) {
                OrderBillingAddress orderBillingAddress = new OrderBillingAddress();
                BeanUtils.copyProperties(billingAddress, orderBillingAddress);
                createOrderResponse.setBillingAddress(orderBillingAddress);
            }
            OrderShippingAddress orderShippingAddress = new OrderShippingAddress();
            BeanUtils.copyProperties(shippingAddress, orderShippingAddress);
            createOrderResponse.setShippingAddress(orderShippingAddress);
        }

        //Get Cart
        Cart cart = cartService.getCart();

        if(cart.getCartItems().size()==0){
            throw new RuntimeException("Cart is Empty");
        }

        Order order = new Order();
        order.setUserName(cart.getUserName());
        order.setUserId(userIdFromToken);

     

        //HarCode to 10%
        double itemsPrice = createOrderResponse.getOrderItems().stream().mapToDouble(OrderItem::getOrderExtendedPrice).sum();
        createOrderResponse.setItemsTotalPrice(itemsPrice);
        order.setTotalItemsPrice(itemsPrice);

        Double taxPrice = (itemsPrice * 10) / 100;
        createOrderResponse.setTaxPrice(taxPrice);
        order.setTaxPrice(taxPrice);

        //Hardcode to 10
        Double shippingPrice = 10D;
        createOrderResponse.setShippingPrice(shippingPrice);
        order.setShippingPrice(shippingPrice);

        double totalPrice = itemsPrice + taxPrice + shippingPrice;
        createOrderResponse.setTotalPrice(totalPrice);
        order.setTotalOrderPrice(totalPrice);

        //Do Payment
        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
        createPaymentRequest.setAmount((int)totalPrice*100);
        createPaymentRequest.setCurrency("USD");
        createPaymentRequest.setPaymentMethodId(createOrderRequest.getPaymentMethodId());

        CreatePaymentResponse createPaymentResponse = paymentFeignClient.createPaymentRequest(createPaymentRequest);

        order.setPaid(createPaymentResponse.isCaptured());
        order.setPaymentDate(createPaymentResponse.getPaymentDate());
        order.setPaymentId(createPaymentResponse.getPaymentId());
        order.setPaymentReceiptUrl(createPaymentResponse.getReceipt_url());
        order.setPaymentMethodId(createOrderRequest.getPaymentMethodId());
        Order save = orderRepository.save(order);
        
        cart.getCartItems()
        .forEach(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setOrderItemPrice(cartItem.getItemPrice());
            orderItem.setOrderExtendedPrice(cartItem.getExtendedPrice());
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setOrderItemPrice(cartItem.getItemPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            order.getOrderItems().add(orderItem);
        
            createOrderResponse.getOrderItems().add(orderItem);
        });
        this.orderItemRepository.saveAll(createOrderResponse.getOrderItems());
        if (billingAddress != null) {
            OrderBillingAddress orderBillingAddress = OrderBillingAddress.builder()
                    .addressLine1(billingAddress.getAddressLine1())
                    .addressLine2(billingAddress.getAddressLine2())
                    .orderId(save.getOrderId())
                    .city(billingAddress.getCity())
                    .country(billingAddress.getCountry())
                    .phone(billingAddress.getPhone())
                    .postalCode(billingAddress.getPostalCode())
                    .state(billingAddress.getState())
                    .build();
            orderBillingAddressRepository.save(orderBillingAddress);
        }

        if (shippingAddress != null) {
            OrderShippingAddress orderShippingAddress = OrderShippingAddress.builder()
                    .addressLine1(shippingAddress.getAddressLine1())
                    .addressLine2(shippingAddress.getAddressLine2())
                    .orderId(save.getOrderId())
                    .city(shippingAddress.getCity())
                    .country(shippingAddress.getCountry())
                    .phone(shippingAddress.getPhone())
                    .postalCode(shippingAddress.getPostalCode())
                    .state(shippingAddress.getState())
                    .build();
            orderShippingAddressRepository.save(orderShippingAddress);
        }

        createOrderResponse.setOrderId(save.getOrderId());
        createOrderResponse.setCreated_at(save.getCreatedAt());

        //set Payment info
        createOrderResponse.setPaid(createPaymentResponse.isCaptured());
        createOrderResponse.setPaymentDate(createPaymentResponse.getPaymentDate());
        createOrderResponse.setPaymentReceiptUrl(createPaymentResponse.getReceipt_url());

        //Clear cart
        cartItemService.removeAllCartItems(cart.getCartId());
        return createOrderResponse;
    }
	private void fillItems(Order cartByUserName) {
		List<OrderItem> items = orderItemRepository.findByOrderId(cartByUserName.getOrderId());
        cartByUserName.setOrderItems(items);
	}
    @Override
    public PreviewOrderResponse previewOrder(PreviewOrderRequest previewOrderRequest) {

        PreviewOrderResponse previewOrderResponse = new PreviewOrderResponse();

        if(previewOrderRequest.getBillingAddressId() != null && !previewOrderRequest.getBillingAddressId().isEmpty()){
            GetAddressResponse billingAddress = billingFeignClient.getAddressById(previewOrderRequest.getBillingAddressId());
            previewOrderResponse.setBillingAddress(billingAddress);
        }

        if(previewOrderRequest.getShippingAddressId() != null && !previewOrderRequest.getShippingAddressId().isEmpty()){
            GetAddressResponse shippingAddress = billingFeignClient.getAddressById(previewOrderRequest.getShippingAddressId());
            if (previewOrderRequest.getBillingAddressId() == null) {
                previewOrderResponse.setBillingAddress(shippingAddress);
            }
            previewOrderResponse.setShippingAddress(shippingAddress);
        }

        try{
            GetPaymentMethodResponse myPaymentMethodById = paymentMethodService.getMyPaymentMethodById(previewOrderRequest.getPaymentMethodId());
            Card card = new Card();
            card.setLast4Digits(myPaymentMethodById.getCardLast4Digits());
            card.setCardBrand(myPaymentMethodById.getCardType());
            card.setPaymentMethodId(myPaymentMethodById.getPaymentMethodId());
            previewOrderResponse.setCard(card);
        }catch (Exception e){
            e.printStackTrace();
            throw new RunTimeExceptionPlaceHolder("Not a valid Payment Method");
        }

        Cart cart = cartService.getCart();

        cart.getCartItems()
                .forEach(cartItem -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrderItemPrice(cartItem.getItemPrice());
                    orderItem.setOrderExtendedPrice(cartItem.getExtendedPrice());
                    orderItem.setProductId(cartItem.getProductId());
                    orderItem.setOrderItemPrice(cartItem.getItemPrice());
                    orderItem.setQuantity(cartItem.getQuantity());
                    previewOrderResponse.getOrderItems().add(orderItem);
                });

        //HardCode to 10%
        double itemsPrice = previewOrderResponse.getOrderItems().stream().mapToDouble(OrderItem::getOrderExtendedPrice).sum();
        previewOrderResponse.setItemsTotalPrice(itemsPrice);

        Double taxPrice = (itemsPrice * 10 ) / 100;
        previewOrderResponse.setTaxPrice(taxPrice);

        //Hardcode to 10
        Double shippingPrice = 10D;
        previewOrderResponse.setShippingPrice(shippingPrice);

        previewOrderResponse.setTotalPrice(itemsPrice + taxPrice + shippingPrice);

        return previewOrderResponse;
    }

    @Override
    public CreateOrderResponse getOrderById(String orderId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = authentication.getName();

        Order order = orderRepository.findByOrderId(orderId);
        fillItems(order);
        if (order == null) {
            throw new RuntimeException("Order No Found");
        }

        if(!userIdFromToken.equals(order.getUserId())){
            throw new RuntimeException("Order doesn't belong to this User! UnAuthorized!");
        }
        Card card = new Card();
        try{
            GetPaymentMethodResponse myPaymentMethodById = paymentMethodService.getMyPaymentMethodById(order.getPaymentMethodId());
            card.setLast4Digits(myPaymentMethodById.getCardLast4Digits());
            card.setCardBrand(myPaymentMethodById.getCardType());
            card.setPaymentMethodId(myPaymentMethodById.getPaymentMethodId());
        }catch (Exception e){
            e.printStackTrace();
            throw new RunTimeExceptionPlaceHolder("Not a valid Payment Method");
        }


        OrderBillingAddress billingAddress = orderBillingAddressRepository.findByOrderId(orderId);
        OrderShippingAddress shippingAddress = orderShippingAddressRepository.findByOrderId(orderId);

        CreateOrderResponse createOrderResponse = CreateOrderResponse.builder()
                .orderId(orderId)
                .orderItems(order.getOrderItems())
                .billingAddress(billingAddress)
                .shippingAddress(shippingAddress)
                .shippingPrice(order.getShippingPrice())
                .card(card)
                .isDelivered(order.isDelivered())
                .isPaid(order.isPaid())
                .itemsTotalPrice(order.getTotalItemsPrice())
                .paymentDate(order.getPaymentDate())
                .paymentReceiptUrl(order.getPaymentReceiptUrl())
                .taxPrice(order.getTaxPrice())
                .totalPrice(order.getTotalOrderPrice())
                .build();

        return createOrderResponse;
    }

    @Override
    public List<CreateOrderResponse> getMyOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = authentication.getName();
        List<Order> order = orderRepository.findByUserId(userIdFromToken);
        for(Order o : order) {
        	  fillItems(o);
        }

        return getCreateOrderResponses(order);
    }

    @Override
    public List<CreateOrderResponse> getAllOrders() {
        Iterable<Order> order = orderRepository.findAll();
        for(Order o : order) {
      	  fillItems(o);
      }

        return getCreateOrderResponses(order);
    }

    private List<CreateOrderResponse> getCreateOrderResponses(Iterable<Order> order) {
        List<CreateOrderResponse> createOrderResponseList = new ArrayList<>();
        order.forEach(o->{
            String orderId = o.getOrderId();
            OrderBillingAddress billingAddress = orderBillingAddressRepository.findByOrderId(orderId);
            OrderShippingAddress shippingAddress = orderShippingAddressRepository.findByOrderId(orderId);

            Card card = new Card();
            try{
                GetPaymentMethodResponse myPaymentMethodById = paymentMethodService.getMyPaymentMethodById(o.getPaymentMethodId());
                card.setLast4Digits(myPaymentMethodById.getCardLast4Digits());
                card.setCardBrand(myPaymentMethodById.getCardType());
                card.setPaymentMethodId(myPaymentMethodById.getPaymentMethodId());
            }catch (Exception e){
                e.printStackTrace();
                throw new RunTimeExceptionPlaceHolder("Not a valid Payment Method");
            }

            CreateOrderResponse createOrderResponse = CreateOrderResponse.builder()
                    .orderId(orderId)
                    .orderItems(o.getOrderItems())
                    .billingAddress(billingAddress)
                    .shippingAddress(shippingAddress)
                    .shippingPrice(o.getShippingPrice())
                    .card(card)
                    .isDelivered(o.isDelivered())
                    .isPaid(o.isPaid())
                    .itemsTotalPrice(o.getTotalItemsPrice())
                    .paymentDate(o.getPaymentDate())
                    .paymentReceiptUrl(o.getPaymentReceiptUrl())
                    .taxPrice(o.getTaxPrice())
                    .totalPrice(o.getTotalOrderPrice())
                    .created_at(o.getCreatedAt())
                    .build();
            createOrderResponseList.add(createOrderResponse);
        });

        return createOrderResponseList;
    }
}
