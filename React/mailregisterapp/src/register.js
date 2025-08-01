import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5 ? 'Full name must be 5 characters long!' : '';
        break;
      case 'email':
        const validEmailRegex = RegExp(
          /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
        errors.email = validEmailRegex.test(value) ? '' : 'Email is not valid!';
        break;
      case 'password':
        errors.password = value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;
      default:
        break;
    }

    this.setState({ errors, [name]: value });
  };

  validateForm = (errors) => {
    return Object.values(errors).every(val => val.length === 0);
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const { errors } = this.state;

    if (this.validateForm(errors)) {
      alert('Valid Form');
    } else {
      if (errors.fullName) alert(errors.fullName);
      if (errors.email) alert(errors.email);
      if (errors.password) alert(errors.password);
    }
  };

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Register Here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <label>Name:</label><br />
          <input
            type="text"
            name="fullName"
            onChange={this.handleChange}
            value={this.state.fullName}
            required
          /><br /><br />

          <label>Email:</label><br />
          <input
            type="email"
            name="email"
            onChange={this.handleChange}
            value={this.state.email}
            required
          /><br /><br />

          <label>Password:</label><br />
          <input
            type="password"
            name="password"
            onChange={this.handleChange}
            value={this.state.password}
            required
          /><br /><br />

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Register;