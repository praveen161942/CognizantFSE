import React from 'react';

function Post(props) {
  return (
    <div style={{ border: '1px solid gray', padding: '10px', marginBottom: '10px' }}>
      <h2>{props.title}</h2>
      <p>{props.body}</p>
    </div>
  );
}

export default Post;