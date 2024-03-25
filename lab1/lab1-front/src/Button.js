import React, { useState } from 'react';
import axios from 'axios';

const Button = () => {
  const [cities, setCities] = useState([]);

  const handleClick = () => {
    axios.get('http://localhost:8080/api/cities')
      .then(response => {
        setCities(response.data);
      })
      .catch(error => {
        console.error('Error fetching cities:', error);
      });
  };

  return (
    <div>
      <button onClick={handleClick}>Get Cities</button>
      <ul>
        {cities.map(city => (
          <li key={city.id}>{city.name} {city.id}</li>
        ))}
      </ul>
    </div>
  );
};

export default Button;
