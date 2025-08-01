import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: '',
      NumberHolder: Math.floor(Math.random() * 100) + 1
    };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    const msg = `Thanks ${this.state.ename}\nYour Complaint was Submitted.\nTransaction ID is: ${this.state.NumberHolder}`;
    alert(msg);
    event.preventDefault();
  };

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Register your complaints here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <label>Name:</label><br />
          <input
            type="text"
            name="ename"
            value={this.state.ename}
            onChange={this.handleChange}
            required
          /><br /><br />

          <label>Complaint:</label><br />
          <textarea
            name="complaint"
            value={this.state.complaint}
            onChange={this.handleChange}
            required
          ></textarea><br /><br />

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;