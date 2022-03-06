CREATE TABLE CarDetails (
   id INTEGER PRIMARY KEY,
   engineSize INTEGER,
   horsePower INTEGER,
   torque INTEGER,
   fuelType TEXT,
   fuelEcoUrban REAL,
   fuelEcoHighway REAL,
   make TEXT,
   model TEXT,
   country TEXT,
   FOREIGN KEY(Country) REFERENCES FuelPrices(Country)
);

CREATE TABLE FuelPrices(
    country TEXT,
    petrol91 REAL,
    petrol95 REAL,
    petrol100 REAL,
    diesel REAL,
    hybrid REAL,
    electric REAL,
    ruc REAL -- used in NZ for 100km travelled in diesel
);