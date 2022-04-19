export type FuelType = "PETROL91" | "PETROL95" | "PETROL100" | "DIESEL" | "HYBRID" | "ELECTRIC"

export type CarDetail = {
  licensePlate: string,
  engineSize: number,
  horsepower: number,
  torque: number,
  fuelType: FuelType,
  fuelEcoUrban: number,
  fuelEcoRural: number,
  make: string,
  model: string,
  year: number,
  country: string
}