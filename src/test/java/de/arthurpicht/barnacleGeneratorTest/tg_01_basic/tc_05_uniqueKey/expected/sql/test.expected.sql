SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS person;
SET REFERENTIAL_INTEGRITY TRUE;
CREATE TABLE person (tempBarnacleGenerator varchar(1));
ALTER TABLE person ADD COLUMN (id VARCHAR(255) NOT NULL);
ALTER TABLE person ADD COLUMN (userName VARCHAR(255));
ALTER TABLE person ADD COLUMN (firstName VARCHAR(255));
ALTER TABLE person DROP COLUMN tempBarnacleGenerator;
ALTER TABLE person ADD PRIMARY KEY (id);
ALTER TABLE person ADD CONSTRAINT uk_userName UNIQUE (userName);