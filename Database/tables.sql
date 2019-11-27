CREATE SCHEMA 'hms';

CREATE TABLE hms.Patient
(
  p_id INT NOT NULL,
  p_Tckn VARCHAR(11),
  p_Name VARCHAR(50) NOT NULL,
  p_Email VARCHAR(40) NOT NULL,
  p_Hashpw VARCHAR(16) NOT NULL,
  PRIMARY KEY (p_id),
  UNIQUE (p_Tckn),
  UNIQUE (p_Email)
);

CREATE TABLE hms.Doctor
(
  d_id INT NOT NULL,
  d_Name VARCHAR(50) NOT NULL,
  d_Email VARCHAR(40) NOT NULL,
  d_Hashpw VARCHAR(16) NOT NULL,
  departmentName VARCHAR(35) NOT NULL,
  PRIMARY KEY (d_id),
  UNIQUE (d_Email)
);