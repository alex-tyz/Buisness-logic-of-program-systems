import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Button = () => {
  const [cities, setCities] = useState([]);
  const [topCities, setTopCities] = useState([]);

  useEffect(() => {
    // Получение всех городов при монтировании компонента
    fetchCities();
  }, []);

  const fetchCities = () => {
    axios.get('http://localhost:8080/api/cities')
      .then(response => {
        setCities(response.data);
        // Вызов функции для получения ТОП 5 городов по рейтингу
        getTopCities(response.data);
      })
      .catch(error => {
        console.error('Error fetching cities:', error);
      });
  };

  const getTopCities = (cities) => {
    // Сортировка городов по рейтингу
    const sortedCities = cities.sort((a, b) => b.rating - a.rating);
    // Получение первых 5 городов
    const topFive = sortedCities.slice(0, 5);
    setTopCities(topFive);
  };

  const handleClick = () => {
    // Обновление списка городов при нажатии кнопки
    fetchCities();
  };

  return (
    <div>
      <button onClick={handleClick}>Get Cities</button>
      <ul>
        {/* Вывод ТОП 5 городов */}
        {topCities.map(city => (
          <li key={city.id}>{city.name} {city.rating}</li>
        ))}
      </ul>
    </div>
  );
};

export default Button;
