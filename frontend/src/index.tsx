import React from 'react';
import ReactDOM from 'react-dom/client';
import reportWebVitals from './reportWebVitals';
import ResponsiveAppBar from './components/ResponsiveAppBar';
import ItemList from './components/ItemList';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <ResponsiveAppBar />
    <ItemList />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
    />
  </React.StrictMode>
);

reportWebVitals();
