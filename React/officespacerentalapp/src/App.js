import React from 'react';
import './App.css';

function App() {
  // Heading
  const heading = <h1>Office Space Rental Listings</h1>;

  // Image URL
  const imageUrl = "https://via.placeholder.com/600x200?text=Office+Space";

  // Office Object
  const mainOffice = {
    name: "Premium Towers",
    rent: 75000,
    address: "Anna Salai, Chennai"
  };

  // List of Offices
  const officeList = [
    { name: "Green Valley", rent: 55000, address: "Guindy, Chennai" },
    { name: "Tech Park", rent: 67000, address: "Tidel Park, Chennai" },
    { name: "Ocean View", rent: 49000, address: "Besant Nagar, Chennai" },
    { name: "Urban Heights", rent: 80000, address: "Adyar, Chennai" }
  ];

  // Function to style rent
  const getRentStyle = (rent) => {
    return {
      color: rent >= 60000 ? 'green' : 'red',
      fontWeight: 'bold'
    };
  };

  return (
    <div className="App">
      {heading}
      <img src={imageUrl} alt="Office Space" style={{ width: '600px', height: '200px', marginBottom: '20px' }} />
      
      <h2>Featured Office</h2>
      <p><strong>Name:</strong> {mainOffice.name}</p>
      <p><strong>Rent:</strong> <span style={getRentStyle(mainOffice.rent)}>₹{mainOffice.rent}</span></p>
      <p><strong>Address:</strong> {mainOffice.address}</p>

      <h2>Available Listings</h2>
      <ul>
        {officeList.map((office, index) => (
          <li key={index} style={{ marginBottom: '15px', textAlign: 'left' }}>
            <p><strong>Name:</strong> {office.name}</p>
            <p><strong>Rent:</strong> <span style={getRentStyle(office.rent)}>₹{office.rent}</span></p>
            <p><strong>Address:</strong> {office.address}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
