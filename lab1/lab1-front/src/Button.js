import React, { useState, useEffect} from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const Button = () => {
  const [cities, setCities] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [selectedCity, setSelectedCity] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Получение ТОП 5 городов при монтировании компонента
    fetchTopCities();
  }, []);

  const fetchTopCities = () => {
    axios.get('http://localhost:8080/api/cities/top')
      .then(response => {
        setCities(response.data);
      })
      .catch(error => {
        console.error('Error fetching top cities:', error);
        setError('Failed to fetch top cities');
      });
  };

  const handleSearchChange = (event) => {
    setSearchQuery(event.target.value);
  };

  const handleSearchCity = () => {
    if (!searchQuery) {
      setError('Please enter a city name');
      return;
    }

    axios.get(`http://localhost:8080/api/cities/${searchQuery}`)
      .then(response => {
        setSelectedCity(response.data);
        setError(null);
      })
      .catch(error => {
        console.error('Error searching city:', error);
        setError('City not found');
      });
  };

  return (
    <div>
      <div>
        <input type="text" value={searchQuery} onChange={handleSearchChange} />
        <button onClick={handleSearchCity}>Search City</button>
      </div>
      {selectedCity && (
        <div>
          <h2>Selected City</h2>
          <p>Name: {selectedCity.name}</p>
          <p>Rating: {selectedCity.rating}</p>
        </div>
      )}
      {error && <div>Error: {error}</div>}
      <h2>Top 5 Cities</h2>
      <ul>
        {cities.map(city => (
          <li key={city.id}>
            {/* Ссылка для открытия нового окна с бронированием */}
            <Link to={`/booking/${city.name}`}>{city.name} - {city.rating}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Button;
