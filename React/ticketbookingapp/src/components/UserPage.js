import React from 'react';

function UserPage() {
  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>You can now book your flights:</p>
      <form>
        <label>From: <input type="text" /></label><br />
        <label>To: <input type="text" /></label><br />
        <label>Date: <input type="date" /></label><br />
        <button type="submit">Book Ticket</button>
      </form>
    </div>
  );
}

export default UserPage;