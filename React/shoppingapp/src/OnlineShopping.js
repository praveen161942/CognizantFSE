import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  render() {
    const items = [
      { itemname: "T-Shirt", price: 499 },
      { itemname: "Jeans", price: 899 },
      { itemname: "Shoes", price: 1299 },
      { itemname: "Watch", price: 1999 },
      { itemname: "Bag", price: 699 }
    ];

    return (
      <div>
        <h1>My Online Shopping Cart</h1>
        {items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;