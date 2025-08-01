import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
  const name = "Praveen";
  const school = "CVT School";
  const total = 450;
  const goal = 500;

  const average = (total / goal) * 100;

  return (
    <div className="score-box">
      <h1>Student Score Calculator</h1>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total Marks:</strong> {total}</p>
      <p><strong>Goal Marks:</strong> {goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}%</p>
    </div>
  );
}

export default CalculateScore;