import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div style={{ border: '1px solid #ccc', margin: '10px', padding: '10px' }}>
      <h3>{employee.name}</h3>
      <p>{employee.position}</p>
      <button className={theme === 'light' ? 'light-btn' : 'dark-btn'}>
        View Details
      </button>
    </div>
  );
}

export default EmployeeCard;