create database hospital;
use hospital;
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    age INT CHECK (age >= 18), -- Ensure a minimum age of 18
    dob DATE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL
);
INSERT INTO admin (name, username, password, age, dob, phone)
VALUES ('John Doe', 'root', 'admin', 30, '1994-05-15', '1234567890');
INSERT INTO admin (name, username, password, age, dob, phone)
VALUES ('Mahin Alam', 'rm', 'rm', 24, '2000-05-15', '1234567892');
CREATE TABLE patient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    consulted_doctor VARCHAR(100),
    disease_details VARCHAR(255),
    phone_no VARCHAR(15) UNIQUE NOT NULL,
    blood_group VARCHAR(5),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert dummy data
INSERT INTO patient (name, consulted_doctor, disease_details, phone_no, blood_group)
VALUES 
    ('John Doe', 'Dr. Smith', 'Fever and cough', '1234567890', 'O+'),
    ('Jane Roe', 'Dr. Brown', 'Migraine', '9876543210', 'A-');
    
CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_name VARCHAR(100) NOT NULL,
    doctor_name VARCHAR(100) NOT NULL,
    appointment_date DATE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    appointment_no VARCHAR(10) UNIQUE NOT NULL
);

CREATE TABLE bloodbank (
    blood_group VARCHAR(3) NOT NULL,
    quantity INT NOT NULL,
    expiry_date DATE NOT NULL
);

use hospital;
-- Create the Doctors table
CREATE TABLE Doctors (
    DoctorID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Speciality VARCHAR(100) NOT NULL,
    Department VARCHAR(100) NOT NULL,
    Salary DECIMAL(10, 2) NOT NULL,
    JoiningDate DATE NOT NULL
);

-- Create the Staff table
CREATE TABLE Staff (
    StaffID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Position VARCHAR(100) NOT NULL,
    Salary DECIMAL(10, 2) NOT NULL,
    JoiningDate DATE NOT NULL
);

-- Create the Board table
CREATE TABLE Board (
    BoardID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Role VARCHAR(100) NOT NULL,
    Salary DECIMAL(10, 2) NOT NULL
);

-- Insert data into Doctors
INSERT INTO Doctors (Name, Speciality, Department, Salary, JoiningDate)
VALUES
('Dr. Alice Smith', 'Cardiologist', 'Cardiology', 200000.00, '2022-01-15'),
('Dr. John Doe', 'Neurologist', 'Neurology', 250000.00, '2023-03-01');

-- Insert data into Staff
INSERT INTO Staff (Name, Position, Salary, JoiningDate)
VALUES
('Emma Taylor', 'Nurse', 50000.00, '2021-06-10'),
('Jack Wilson', 'Lab Technician', 60000.00, '2020-12-05');

-- Insert data into Board
INSERT INTO Board (Name, Role, Salary)
VALUES
('Richard King', 'Chairperson', 300000.00),
('Sophia Green', 'Treasurer', 150000.00);

create database employee;
use employee;
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    age INT CHECK (age >= 18), -- Ensure a minimum age of 18
    dob DATE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL
);
INSERT INTO admin (name, username, password, age, dob, phone)
VALUES ('John Doe', 'root', 'admin', 30, '1994-05-15', '1234567890');
INSERT INTO admin (name, username, password, age, dob, phone)
VALUES ('Mahin Alam', 'rm', 'rm', 24, '2000-05-15', '1234567892');







