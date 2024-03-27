import { useState } from 'react';

function useLocalStorage(key, initialValue) {
  const [storedValue, setStoredValue] = useState(() => {
    try {
      const item = window.localStorage.getItem(key);
      return item ? JSON.parse(item) : initialValue;
    } catch (error) {
      console.error(`Error retrieving data from localStorage for key ${key}:`, error);
      return initialValue;
    }
  });

  const setValue = (value) => {
    try {
      const serializedValue = JSON.stringify(value);
      window.localStorage.setItem(key, serializedValue);
      setStoredValue(value);
    } catch (error) {
      console.error(`Error saving data to localStorage for key ${key}:`, error);
    }
  };

  return [storedValue, setValue];
}

export default useLocalStorage;
