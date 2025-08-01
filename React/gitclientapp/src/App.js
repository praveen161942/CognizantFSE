import React, { useEffect, useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const result = await GitClient.getRepositories('techiesyed');
      setRepos(result);
    }
    fetchData();
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>GitHub Repositories</h1>
      <ul>
        {repos.map((repo, index) => (
          <li key={index}>{repo}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;