DROP DATABASE IF EXISTS exchangeServiceGela;
CREATE DATABASE exchangeServiceGela
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
USE exchangeServiceGela;


CREATE TABLE Location(
	locationID INT AUTO_INCREMENT PRIMARY KEY,
	startDate VARCHAR(30) NOT NULL,
	endDate VARCHAR(30) NOT NULL,
	locationName VARCHAR(30) NOT NULL
);

CREATE TABLE Users (
	userID INT AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(30) UNIQUE NOT NULL,
	phoneNumber VARCHAR(30) UNIQUE NOT NULL,
	password VARCHAR(30) NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	lastName VARCHAR(30) NOT NULL,

	isSatisfied BOOLEAN NOT NULL,
	
	
	locationID INT NOT NULL,
	confirmed BOOLEAN NOT NULL,
	FOREIGN KEY (locationID) REFERENCES Location(locationID)

);

CREATE TABLE Pairs(
	pairID INT AUTO_INCREMENT PRIMARY KEY,
	userID INT NOT NULL,
	locationID INT NOT NULL,
	
    UNIQUE KEY theyKey (userID,locationID),
	FOREIGN KEY (userID) REFERENCES Users(userID),
	FOREIGN KEY (locationID) REFERENCES Location(locationID)
);

