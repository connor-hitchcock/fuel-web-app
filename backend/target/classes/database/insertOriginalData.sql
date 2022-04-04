-- Insert FuelPrice Entries
INSERT INTO FuelPrice (country, petrol91, petrol95, petrol100, diesel, ruc, electric)
VALUES ("New Zealand", 2.62, 2.70, 2.89, 1.87, 7.6, 0.2631);

-- Insert CarDetail Entries
INSERT INTO CarDetail (licensePlate, engineSize, horsepower, torque, fuelType, fuelEcoUrban, fuelEcoRural, make, model,
year, country)
VALUES ("AAA111", 1.8, 147, 180, "PETROL91", 9.9, 7.0, "Toyota", "Auris", 2010, "New Zealand");

INSERT INTO CarDetail (licensePlate, engineSize, horsepower, torque, fuelType, fuelEcoUrban, fuelEcoRural, make, model,
year, country)
VALUES ("BBB222", 2.7, 190, 400, "DIESEL", 9.0, 6.3, "Audi", "A4", 2008, "New Zealand");

INSERT INTO CarDetail (licensePlate, engineSize, horsepower, torque, fuelType, fuelEcoUrban, fuelEcoRural, make, model,
year, country)
VALUES ("CCC333", 1.3, 86, 122, "PETROL91", 7.2, 5.5, "Mazda", "Demio", 2007, "New Zealand");

INSERT INTO CarDetail (licensePlate, engineSize, horsepower, torque, fuelType, fuelEcoUrban, fuelEcoRural, make, model,
year, country)
VALUES ("DDD444", 2.0, 140, 320, "DIESEL", 7.7, 5.7, "Volkswagen", "Jetta", 2006, "New Zealand");

INSERT INTO CarDetail (licensePlate, engineSize, horsepower, torque, fuelType, fuelEcoUrban, fuelEcoRural, make, model,
year, country)
VALUES ("EEE555", 3.1, 133, 294, "DIESEL", 13.5, 10.5, "Isuzu", "Big Horn", 1996, "New Zealand");

INSERT INTO CarDetail (licensePlate, engineSize, horsepower, torque, fuelType, fuelEcoUrban, fuelEcoRural, make, model,
year, country)
VALUES ("FFF666", 2.0, 126, 300, "DIESEL", 7.2, 5.3, "Toyota", "Corolla", 2009, "New Zealand");

INSERT INTO CarDetail (licensePlate, engineSize, horsepower, torque, fuelType, fuelEcoUrban, fuelEcoRural, make, model,
year, country)
VALUES ("GGG777", 1.5, 102, 133, "PETROL91", 8.4, 6.3, "Suzuki", "Swift", 2008, "New Zealand");

-- Insert Person Entries
INSERT INTO Person (email, username, password, firstName, middleName, lastName, age, birthday)
VALUES ("fergus.hitchcock@gmail.com", "guchii", "null", "Connor", "Fergus", "Hitchcock", 23, "17-07-1999");

INSERT INTO Person (email, username, password, firstName, middleName, lastName, age, birthday)
VALUES ("fergus.hitchcock@xtra.co.nz", "fergusHitchcock", "null", "Fergus", "Paul", "Hitchcock", 49, "29-04-1973");

INSERT INTO Person (email, username, password, firstName, middleName, lastName, age, birthday)
VALUES ("alex.hobson@gmail.com", "alexHobson", "null", "Alex", "Middlename", "Hobson", 23, "01-01-1999");

-- Insert PersonCar Entries
INSERT INTO PersonCar (email, licensePlate, urbanRuralRatio, fuelCost100km)
VALUES ("fergus.hitchcock@gmail.com", "AAA111", 0.7, 0.0);

INSERT INTO PersonCar (email, licensePlate, urbanRuralRatio, fuelCost100km)
VALUES ("fergus.hitchcock@gmail.com", "BBB222", 0.3, 0.0);

INSERT INTO PersonCar (email, licensePlate, urbanRuralRatio, fuelCost100km)
VALUES ("fergus.hitchcock@gmail.com", "CCC333", 0.5, 0.0);

INSERT INTO PersonCar (email, licensePlate, urbanRuralRatio, fuelCost100km)
VALUES ("fergus.hitchcock@gmail.com", "DDD444", 0.2, 0.0);

INSERT INTO PersonCar (email, licensePlate, urbanRuralRatio, fuelCost100km)
VALUES ("fergus.hitchcock@xtra.co.nz", "EEE555", 0.05, 0.0);

INSERT INTO PersonCar (email, licensePlate, urbanRuralRatio, fuelCost100km)
VALUES ("fergus.hitchcock@xtra.co.nz", "FFF666", 0.05, 0.0);

INSERT INTO PersonCar (email, licensePlate, urbanRuralRatio, fuelCost100km)
VALUES ("alex.hobson@gmail.com", "GGG777", 0.9, 0.0);
