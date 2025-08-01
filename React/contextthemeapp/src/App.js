import './App.css';
import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(prev => (prev === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Management System</h1>
        <button onClick={toggleTheme}>
          Toggle Theme ({theme})
        </button>
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;