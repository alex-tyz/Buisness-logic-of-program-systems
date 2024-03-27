import React from 'react';
import { BrowserRouter as Router, Routes, Route, useParams } from 'react-router-dom';
import Button, { ButtonPage } from './Button'; // Ваш компонент с кнопкой и списком городов
import Booking, {BookingPage}from './Booking'; // Ваш компонент для бронирования дат
import Cart from './Cart'
import { CartProvider } from './CartContext';

const App = () => {
  return (
    <Router>
      <CartProvider> {/* Оборачиваем все компоненты в провайдер корзины */}
        <div>
          <Routes>  
            <Route exact path="/" element={<Button />} />
            <Route path="/booking/:city" element={<BookingWrapper />} />
            <Route path="/cart" element={<Cart />} /> {/* Путь к компоненту корзины */}
          </Routes>
        </div>
      </CartProvider>
    </Router>
  );
};

const BookingWrapper = () => {
  const { city } = useParams(); // Получаем параметр маршрута 'city'
  return <Booking city={city} />; // Передаем city в компонент Booking
};

export default App;
