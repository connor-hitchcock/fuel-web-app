import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

//API client imports
import {
  ApolloClient,
  InMemoryCache,
  ApolloProvider,
  useQuery,
  gql
} from "@apollo/client";

reportWebVitals();

const client = new ApolloClient({
  uri: 'http://localhost:8080/graphql/',
  cache: new InMemoryCache(),
//  fetchOptions: {
//    mode: 'no-cors'
//  }
});

const queryA = gql`
  query {
    people {
      personID
      firstName
      middleName
      lastName
      aage
      birthday
      personCars {
        personID
        licensePlate
        urbanRuralRatio
        fuelCost100km
      }
    }
  }
`;


client
  .query(queryA)
  .then(result => console.log(result));