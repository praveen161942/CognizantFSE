import React, { Component } from 'react';

class Cart extends Component {
  render() {
    return (
      <div style={{ border: "1px solid black", padding: "10px", marginBottom: "10px", width: "300px" }}>
        <h3>{this.props.itemname}</h3>
        <p>Price: ₹{this.props.price}</p>
      </div>
    );
  }
}

// Optional: Define default props
Cart.defaultProps = {
  itemname: "Unknown Item",
  price: 0
};

export default Cart;