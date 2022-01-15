

## About this project
This is an Ecommerce project still `development in progress`, where users can adds books to the cart and buy those books.

Application is being developed using Java, Spring and React.


<hr>

## Frontend Checkout Flow
![CheckOutFlow](https://user-images.githubusercontent.com/14878408/103235826-06d5ca00-4969-11eb-87c8-ce618034b4f3.gif)

## Architecture


<hr>

## Run this project in Local Machine

>Frontend App 

Navigate to `bookstore-frontend-react-app` folder
Run below commnads to start Frontend React Application

```
yarn install
yarn start
```

>Backend Services
>
To Start Backend Services follow below steps.
>Using Intellij/Eclipse or Command Line

>Import this project into IDE and run Spring boot project


## login
There are 2 users in the system currently. 
ADMIN, NORMAL USER

```
Admin 
userName: 'admin.admin'
password: 'admin.devd123'
```

```
Normal User 
userName: 'devd.cores'
password: 'cores.devd123'
```

*To get the accessToken (Admin User)* 

```curl 93ed453e-b7ac-4192-a6d4-c45fae0d99ac:client.devd123@localhost:4001/oauth/token -d grant_type=password -d username=admin.admin -d password=admin.devd123```

<hr>
