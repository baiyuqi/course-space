// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

/**
 * @title Storage
 * @dev Store & retrieve value in a variable
 */
contract Sample {
    address owner;
    uint256 public  state;
    event StateChanged(uint oldstate, uint newstate);
    modifier isOwner(){
        require(msg.sender == owner, "only owner can change state!");
        _;
    }
    constructor() {
        owner = msg.sender;
    }

    /**
     * @dev Store value in variable
     * @param num value to store
     */
    function setState(uint256 num) public isOwner {
        uint old = state;
        state = num;
        emit StateChanged(old, state);
    }

}