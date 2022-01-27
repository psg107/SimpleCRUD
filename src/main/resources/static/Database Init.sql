-- CREATE DATABASE SimpleCRUD

USE SimpleCRUD;

CREATE TABLE Drink
(
  DrinkID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(100),
  Price INT,
  RegEmployeeId INT
);

CREATE TABLE Employee
(
  EmployeeID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(100)
);

-- 테스트용 더미 데이터
INSERT INTO Employee(Name) Values('박상곤');
INSERT INTO Employee(Name) Values('김상곤');
INSERT INTO Employee(Name) Values('이상곤');

INSERT INTO Drink(Name, Price, RegEmployeeId) Values('싼 아메리카노', 500, 0);
INSERT INTO Drink(Name, Price, RegEmployeeId) Values('아메리카노', 2000, 0);
INSERT INTO Drink(Name, Price, RegEmployeeId) Values('비싼 아메리카노', 10000, 0);