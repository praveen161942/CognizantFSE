import React from 'react';
import './App.css';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div className="App">
      <CohortDetails
        name="Java Full Stack"
        status="ongoing"
        startDate="2024-05-01"
        endDate="2024-08-01"
      />
      <CohortDetails
        name="ReactJS Bootcamp"
        status="completed"
        startDate="2024-01-10"
        endDate="2024-04-10"
      />
    </div>
  );
}

export default App;