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


INSERT INTO Location (startDate, endDate, locationName) VALUES
	('17 JUL', '27 JUL', 'anaseuli I'),
	('17 JUL', '27 JUL', 'cageri I'),
	('17 JUL', '27 JUL', 'borjomi I'),
	('17 JUL', '27 JUL', 'rkoni I'),
	('17 JUL', '27 JUL', 'mtirala I'),
	('17 JUL', '27 JUL', 'okace I'),
	('17 JUL', '27 JUL', 'tusheti I'),
	('17 JUL', '27 JUL', 'lagodexi I'),

	('27 JUL', '6 AUG', 'arxoti II'),
	('27 JUL', '6 AUG', 'anaseuli II'),
	('27 JUL', '6 AUG', 'cageri II'),
	('27 JUL', '6 AUG', 'borjomi II'),
	('27 JUL', '6 AUG', 'rkoni II'),
	('27 JUL', '6 AUG', 'mtirala II'),
	('27 JUL', '6 AUG', 'okace II'),
	('27 JUL', '6 AUG', 'tusheti II'),
	('27 JUL', '6 AUG', 'lagodexi II'),

	('6 AUG', '16 AUG', 'arxoti III'),
	('6 AUG', '16 AUG', 'anaseuli III'),
	('6 AUG', '16 AUG', 'cageri III'),
	('6 AUG', '16 AUG', 'borjomi III'),
	('6 AUG', '16 AUG', 'rkoni III'),
	('6 AUG', '16 AUG', 'mtirala III'),
	('6 AUG', '16 AUG', 'okace III'),
	('6 AUG', '16 AUG', 'tusheti III'),
	('6 AUG', '16 AUG', 'lagodexi III');





