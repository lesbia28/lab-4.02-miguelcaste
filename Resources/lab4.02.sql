USE lab402;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee(
id BIGINT NOT NULL,
department VARCHAR(255),
name VARCHAR(255),
status  VARCHAR (255),
PRIMARY KEY(id)
);

INSERT INTO employee (id, department, name, status) VALUES
(356712, 'cardiology', 'Alonso Flores', 'ON_CALL'),
(564134, 'immunology',  'Sam Ortega', 'ON'),
(761527, 'cardiology',  'German Ruiz', 'OFF'),
(166552, 'pulmonary',  'Maria Lin', 'ON'),
(156545, 'orthopaedic',  'Paolo Rodriguez', 'ON_CALL'),
(172456, 'psychiatric',  'John Paul Armes', 'OFF');

DROP TABLE IF EXISTS patient;

CREATE TABLE patient(
id BIGINT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
date_of_birth DATE,
admitted_by BIGINT,
PRIMARY KEY(id),
FOREIGN KEY(admitted_by) REFERENCES employee(id)
);

INSERT INTO patient (name, date_of_birth, admitted_by) VALUES
('Jaime Jordan', '1984-03-02', 564134),
('Marian Garcia',  '1972-01-12', 564134),
('Julia Dusterdieck',  '1954-06-11', 356712),
('Steve McDuck',  '1931-11-10', 761527),
('Marian Garcia',  '1999-02-15', 172456);


