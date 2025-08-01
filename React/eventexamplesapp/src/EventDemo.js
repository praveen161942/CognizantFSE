import React, { Component } from 'react';

class EventDemo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }

  increment = () => {
    this.setState(prev => ({ count: prev.count + 1 }));
  };

  decrement = () => {
    this.setState(prev => ({ count: prev.count - 1 }));
  };

  sayHello = () => {
    console.log("Hello! Welcome to React Events Lab.");
  };

  handleIncrementAll = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (msg) => {
    alert(`Message: ${msg}`);
  };

  handleClick = (e) => {
    alert("I was clicked"); // Synthetic event demo
    console.log("Event Type:", e.type); // Synthetic Event Object
  };

  render() {
    return (
      <div style={{ padding: '20px', border: '1px solid black', marginBottom: '20px' }}>
        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.handleIncrementAll}>Increment</button>{' '}
        <button onClick={this.decrement}>Decrement</button>{' '}
        <button onClick={() => this.sayWelcome("Welcome to React!")}>Say Welcome</button>{' '}
        <button onClick={this.handleClick}>OnPress</button>
      </div>
    );
  }
}

export default EventDemo;