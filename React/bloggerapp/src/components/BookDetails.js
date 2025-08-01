import React from 'react';

function BookDetails({ books }) {
  return (
    <div className="st2">
      <h1>📚 Book Details</h1>
      <ul>
        {books.map((book) => (
          <div key={book.id}>
            <h3>{book.bname}</h3>
            <h4>₹{book.price}</h4>
          </div>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;