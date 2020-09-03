DROP TABLE IF EXISTS Lease;

CREATE TABLE Lease (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  requestedAmount VARCHAR(250) NULL,
  creditStatus VARCHAR(250) NULL
);

DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  lease_id INT NULL,
  coApplicant_id INT NULL,
  personId VARCHAR(250) NULL,
  name VARCHAR(250) NULL,
  income VARCHAR(250) NULL
);

DROP TABLE IF EXISTS Vehicle;

CREATE TABLE Vehicle (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  vehicleLease_id INT NULL,
  make VARCHAR(250) NULL,
  model VARCHAR(250) NULL,
  vinNumber VARCHAR(250) NULL,
  licensePlate VARCHAR(250) NULL
);

