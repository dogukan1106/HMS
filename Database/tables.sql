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