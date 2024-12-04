create database hospital
use hospital
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




