import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import { books } from './data/books';

function App() {
  const [view, setView] = useState('all'); // 'books', 'blogs', 'courses', 'all'

  const showBooks = view === 'books' || view === 'all';
  const showBlogs = view === 'blogs' || view === 'all';
  const showCourses = view === 'courses' || view === 'all';

  return (
    <div>
      <h1>🧠 BloggerApp - Conditional Rendering Demo</h1>

      <div>
        <button onClick={() => setView('books')}>Show Books</button>
        <button onClick={() => setView('blogs')}>Show Blogs</button>
        <button onClick={() => setView('courses')}>Show Courses</button>
        <button onClick={() => setView('all')}>Show All</button>
        <button onClick={() => setView('none')}>Clear</button>
      </div>

      <hr />

      {/* Conditional Rendering */}
      {showBooks && <BookDetails books={books} />}
      {showBlogs && <BlogDetails show={true} />}
      {showCourses && <CourseDetails show={true} />}
    </div>
  );
}

export default App;