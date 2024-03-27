import React from 'react';

const Cart = ({ cartItems }) => {
  return (
    <div>
      <h2>Cart</h2>
      <ul>
        {cartItems.map((item, index) => (
          <li key={index}>{item.date} - {item.fromCity} to {item.toCity} - ${item.cost}</li>
        ))}
      </ul>
    </div>
  );
};

export default Cart;
