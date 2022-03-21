import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

//API client imports
import {
  ApolloClient,
  InMemoryCache,
  ApolloProvider,
  useQuery,
  gql
} from "@apollo/client";

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

const client = new ApolloClient({
  uri: 'http://localhost:8080/graphql/',
  cache: new InMemoryCache(),
  fetchOptions: {
    mode: 'no-cors'
  }
});

client
  .query({
    query: gql`
      query {
        people {
          personID
          firstName
          middleName
          lastName
          age
          birthday
          personCars {
            personID
            licensePlate
            urbanRuralRatio
            fuelCost100km
          }
        }
      }
    `
  })
  .then(result => console.log(result));