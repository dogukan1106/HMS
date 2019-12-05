CREATE SCHEMA `hms`;

CREATE TABLE hms.Patient
(
  id INT NOT NULL auto_increment,
  p_Tckn VARCHAR(11),
  p_Name VARCHAR(50) NOT NULL,
  email VARCHAR(40) NOT NULL,
  hashpw VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (p_Tckn),
  UNIQUE (email)
);

CREATE TABLE hms.Doctor
(
  id INT NOT NULL auto_increment,
  d_Name VARCHAR(50) NOT NULL,
  email VARCHAR(40) NOT NULL,
  hashpw VARCHAR(50) NOT NULL,
  departmentName VARCHAR(35) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (email)
);

CREATE TABLE hms.Make_Appointments
(
  id INT NOT NULL auto_increment,
  p_id INT NOT NULL,
  d_id INT NOT NULL,
  checkin_time VARCHAR(5) NOT NULL,
  date VARCHAR(10) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (p_id) REFERENCES Patient(id),
  FOREIGN KEY (d_id) REFERENCES Doctor(id)
);

CREATE TABLE hms.Administrator
(
  id INT NOT NULL auto_increment,
  hashpw VARCHAR(50) NOT NULL,
  email VARCHAR(40) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (email)
);
