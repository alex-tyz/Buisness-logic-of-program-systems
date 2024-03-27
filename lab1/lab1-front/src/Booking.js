import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

const Booking = () => {
  const { city } = useParams();
  const [dates, setDates] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Получение доступных дат для бронирования для выбранного города
    fetchDatesForCity(city);
  }, [city]);

  const fetchDatesForCity = (cityName) => {
    // Здесь вы можете выполнить запрос на бэкенд для получения доступных дат
    // Замените URL на соответствующий URL вашего бэкенд-сервера
    fetch(`http://localhost:8080/api/dates/${cityName}`)
      .then(response => response.json())
      .then(data => {
        setDates(data);
      })
      .catch(error => {
        console.error('Error fetching dates:', error);
        setError('Failed to fetch available dates');
      });
  };

  return (
    <div>
      <h2>Booking for {city}</h2>
      {error && <div>Error: {error}</div>}
      <ul>
        {dates.map(date => (
          <li key={date}>{date}</li>
        ))}
      </ul>
    </div>
  );
};

export default Booking;
