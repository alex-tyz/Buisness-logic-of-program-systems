import React, { useEffect, useState, useHistory } from 'react';
import axios from 'axios';
import Cart from './Cart';

const Booking = ({ city }) => {
  const [dates, setDates] = useState([]);
  const [cart, setCart] = useState([]);
  const history = useHistory;

  useEffect(() => {
    fetchDatesForCity(city);
  }, [city]);

  const fetchDatesForCity = (cityName) => {
    axios.get(`http://localhost:8080/api/booking/${cityName}`)
      .then(response => {
        setDates(response.data);
      })
      .catch(error => {
        console.error('Error fetching dates:', error);
      });
  };

  const addToCart = (date) => {
    setCart([...cart, date]);
  };



  return (
    <div>
      <h2>Available dates for {city}</h2>
      <form action="http://localhost:3000">
            <button type="submit">Back</button>
</form>
      <ul>
        {dates.map(date => (
          <li key={date.id}>
            Date: {date.date}, From: {date.fromCity}, To: {date.toCity}, Cost: {date.cost}, Free: {date.free ? 'Yes' : 'No'}
            <button onClick={() => addToCart(date)}>Buy</button>
          </li>
        ))}
      </ul>
      <Cart cartItems={cart} />
    </div>
  );
};

export default Booking;
