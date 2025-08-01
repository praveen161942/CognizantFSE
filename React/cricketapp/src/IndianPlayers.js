import React from 'react';

function IndianPlayers() {
  const oddTeam = ["Virat", "Shreyas", "Jadeja", "Bumrah", "Pant"];
  const evenTeam = ["Rohit", "Rahul", "Hardik", "Ashwin", "Shami", "Siraj"];

  // Destructuring Example
  const [player1, player2, ...rest] = oddTeam;

  // Merge two arrays
  const T20 = ["Rohit", "Kohli", "Pant"];
  const Ranji = ["Sarfaraz", "Pujara", "Iyer"];
  const mergedPlayers = [...T20, ...Ranji];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        {oddTeam.map((player, i) => <li key={i}>{player}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenTeam.map((player, i) => <li key={i}>{player}</li>)}
      </ul>

      <h2>Merged T20 and Ranji Trophy Players</h2>
      <ul>
        {mergedPlayers.map((player, i) => <li key={i}>{player}</li>)}
      </ul>
    </div>
  );
}

export default IndianPlayers;