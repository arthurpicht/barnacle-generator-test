SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS auto_inc;
SET REFERENTIAL_INTEGRITY TRUE;
CREATE TABLE auto_inc (tempBarnacleGenerator varchar(1));
ALTER TABLE auto_inc ADD COLUMN (id INTEGER NOT NULL);
ALTER TABLE auto_inc ADD COLUMN (name VARCHAR(255));
ALTER TABLE auto_inc DROP COLUMN tempBarnacleGenerator;
ALTER TABLE auto_inc ADD PRIMARY KEY (id);
ALTER TABLE auto_inc ALTER COLUMN id INTEGER AUTO_INCREMENT;
