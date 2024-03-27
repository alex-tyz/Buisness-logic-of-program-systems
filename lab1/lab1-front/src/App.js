import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Button, { ButtonPage } from './Button'; // Ваш компонент с кнопкой и списком городов
import Booking from './Booking'; // Ваш компонент для бронирования дат

const App = () => {
  return (
    
    <Router>
      <div>
        <Routes>  
          <Route exact path="/" element={<Button />} />
          <Route path="/booking/:city" element={<Booking />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
