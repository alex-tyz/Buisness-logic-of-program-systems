import React, { useEffect, useState, useHistory } from 'react';
import axios from 'axios';

const Booking = ({ city }) => {
  const [dates, setDates] = useState([]);

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
  const addToCart = (cityName, date, cost) => {
    axios.get(`http://localhost:8080/api/booking/${cityName}/buy/${date.id}`)
      .then(response => {
        
        console.log(`Buy ${cityName}`);
      })
      .catch(error => {
        console.log(`error buying ${cityName}`);
      });
  };
  const handlePayment = async (city, date, cost) => {
    try {
      const response = await axios.post('http://localhost:8080/api/payment', null, {
        params: {
          city: city,
          date: date,
          cost: cost
        },
        responseType: 'arraybuffer'
      });
      const blob = new Blob([response.data], { type: 'application/pdf' });
  
      const url = window.URL.createObjectURL(blob);
  
      const link = document.createElement('a');
      link.href = url;
      link.download = 'ticket.pdf';
      link.click();
      window.URL.revokeObjectURL(url);
  
      alert('Payment successful! Your ticket has been downloaded.');
    } catch (error) {
      console.error('Error processing payment:', error);
      alert('Error processing payment. Please try again later.');
    }
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
            {date.free && <button onClick={() => handlePayment(date.fromCity, date.date, date.cost)}>Buy</button>}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Booking;
