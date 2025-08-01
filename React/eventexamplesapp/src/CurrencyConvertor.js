import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: 0
    };
  }

  handleChange = (e) => {
    this.setState({ rupees: e.target.value });
  };

  handleSubmit = () => {
    const inr = parseFloat(this.state.rupees);
    if (!isNaN(inr)) {
      const euroValue = inr / 89.5; // Example conversion rate
      this.setState({ euro: euroValue.toFixed(2) });
    } else {
      alert("Please enter a valid number");
    }
  };

  render() {
    return (
      <div style={{ padding: '20px', border: '1px solid green' }}>
        <h2>Currency Convertor</h2>
        <label>Enter Amount in INR: </label>
        <input type="text" value={this.state.rupees} onChange={this.handleChange} />
        <button onClick={this.handleSubmit}>Convert</button>
        <p>Equivalent in Euro: €{this.state.euro}</p>
      </div>
    );
  }
}

export default CurrencyConvertor;