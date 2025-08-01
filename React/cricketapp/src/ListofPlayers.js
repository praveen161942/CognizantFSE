import React from 'react';

function ListofPlayers() {
  const players = [
    { name: "Virat", score: 85 },
    { name: "Rohit", score: 92 },
    { name: "Rahul", score: 45 },
    { name: "Shreyas", score: 66 },
    { name: "Hardik", score: 78 },
    { name: "Jadeja", score: 50 },
    { name: "Ashwin", score: 72 },
    { name: "Shami", score: 35 },
    { name: "Bumrah", score: 59 },
    { name: "Siraj", score: 83 },
    { name: "Pant", score: 91 }
  ];

  const filtered = players.filter(player => player.score >= 70);

  return (
    <div>
      <h2>Players with score ≥ 70</h2>
      <ul>
        {filtered.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
