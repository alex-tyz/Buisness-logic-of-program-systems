import { createContext, useContext } from 'react';
import useLocalStorage from './useLocalStorage';

const CartContext = createContext();

export const CartProvider = ({ children }) => {
  const [cart, setCart] = useLocalStorage('cart', []); // Используем хук для сохранения состояния корзины в localStorage

  const addToCart = (item) => {
    setCart(prevCart => [...prevCart, item]);
  };

  const removeFromCart = (itemId) => {
    setCart(prevCart => prevCart.filter(item => item.id !== itemId));
  };

  const cartValue = {
    cart,
    addToCart,
    removeFromCart
  };

  return (
    <CartContext.Provider value={cartValue}>
      {children}
    </CartContext.Provider>
  );
};

export const useCart = () => {
  return useContext(CartContext);
};
