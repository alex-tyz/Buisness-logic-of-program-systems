import React from 'react';
import { useCart } from './CartContext'; // Импортируем хук для работы с корзиной

const Cart = () => {
  const { cart } = useCart(); // Получаем доступ к состоянию корзины через хук
console.log(cart);
  return (
    <div>
      <h2>Shopping Cart</h2>
      <ul>
        {cart.map((item, index) => ( // Используем index в качестве ключа
          <li key={index}>
            from {item.fromCity} to {item.toCity} at {item.date} - ${item.cost}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Cart;
