SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS entitycloneable;
SET REFERENTIAL_INTEGRITY TRUE;
CREATE TABLE entitycloneable (tempBarnacleGenerator varchar(1));
ALTER TABLE entitycloneable ADD COLUMN (id VARCHAR(255) NOT NULL);
ALTER TABLE entitycloneable ADD COLUMN (first_name VARCHAR(255));
ALTER TABLE entitycloneable ADD COLUMN (last_name VARCHAR(255));
ALTER TABLE entitycloneable DROP COLUMN tempBarnacleGenerator;
ALTER TABLE entitycloneable ADD PRIMARY KEY (id);
