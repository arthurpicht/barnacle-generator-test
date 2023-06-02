SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS entitycustomtype;
SET REFERENTIAL_INTEGRITY TRUE;
CREATE TABLE entitycustomtype (tempBarnacleGenerator varchar(1));
ALTER TABLE entitycustomtype ADD COLUMN (id INTEGER NOT NULL);
ALTER TABLE entitycustomtype ADD COLUMN (code VARCHAR(5));
ALTER TABLE entitycustomtype DROP COLUMN tempBarnacleGenerator;
ALTER TABLE entitycustomtype ADD PRIMARY KEY (id);
