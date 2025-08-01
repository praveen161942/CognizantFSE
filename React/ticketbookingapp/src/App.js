import React, { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div>
      <header style={{ background: '#f2f2f2', padding: '10px' }}>
        <h1>✈️ Flight Ticket Booking App</h1>
        {isLoggedIn ? 
          <button onClick={handleLogout}>Logout</button> : 
          <button onClick={handleLogin}>Login</button>
        }
      </header>

      <hr />

      <main>
        {isLoggedIn ? <UserPage /> : <GuestPage />}
      </main>
    </div>
  );
}

export default App;
