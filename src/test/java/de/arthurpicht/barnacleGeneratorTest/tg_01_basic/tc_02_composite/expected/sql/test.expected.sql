SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS person_composite;
SET REFERENTIAL_INTEGRITY TRUE;
CREATE TABLE person_composite (tempBarnacleGenerator varchar(1));
ALTER TABLE person_composite ADD COLUMN (first_name VARCHAR(255) NOT NULL);
ALTER TABLE person_composite ADD COLUMN (last_name VARCHAR(255) NOT NULL);
ALTER TABLE person_composite ADD COLUMN (age INTEGER);
ALTER TABLE person_composite DROP COLUMN tempBarnacleGenerator;
ALTER TABLE person_composite ADD PRIMARY KEY (first_name, last_name);
