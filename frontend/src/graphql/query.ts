import { request, gql } from 'graphql-request'

const query = gql`
	carDetails {
		licensePlate 
		engineSize
		horsepower
		torque
		fuelType
		fuelEcoUrban
		fuelEcoRural
		make
		model
		year
		country
		fuelPrice {
			country
			petrol91
			petrol95
			petrol100
			diesel
			ruc
			electric
		}
	}
`

request('https://localhost:8080/graphql', query).then((data) => console.log(data))