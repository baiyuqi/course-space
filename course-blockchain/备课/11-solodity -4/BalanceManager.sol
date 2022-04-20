// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

/**
 * @title Storage
 * @dev Store & retrieve value in a variable
 */
contract BanlanceManager {

    mapping(address=>uint256)  balances;
    event Transfer(address from, address to, uint amount);
  
    constructor() {
       balances[msg.sender] = 10000;
    }

    function transfer(address to, uint256 amount) public  {
        address  from  = msg.sender;
        uint fb = balances[from];
        uint tb = balances[to];
        require(fb >= amount, "not enough balance to transfer!");
        balances[from] = fb - amount;
        balances[to] = tb + amount;
        emit Transfer(from, to, amount);
    }
    function balanceOf() public view returns(uint){
        return balances[msg.sender];
    }

}