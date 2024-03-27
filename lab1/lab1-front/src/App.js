import React from 'react';
import { BrowserRouter as Router, Routes, Route, useParams } from 'react-router-dom';
import Button, { ButtonPage } from './Button'; // Ваш компонент с кнопкой и списком городов
import Booking, {BookingPage}from './Booking'; // Ваш компонент для бронирования дат

const App = () => {
  return (
    <Router>
      <div>
        <Routes>  
          <Route exact path="/" element={<Button />} />
          <Route path="/booking/:city" element={<BookingWrapper />} />
        </Routes>
      </div>
    </Router>
  );
};

const BookingWrapper = () => {
  const { city } = useParams(); // Получаем параметр маршрута 'city'
  return <Booking city={city} />; // Передаем city в компонент Booking
};

export default App;
