SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS entityserializablecloneable;
DROP TABLE IF EXISTS entityserializable;
SET REFERENTIAL_INTEGRITY TRUE;
CREATE TABLE entityserializablecloneable (tempBarnacleGenerator varchar(1));
ALTER TABLE entityserializablecloneable ADD COLUMN (id VARCHAR(255) NOT NULL);
ALTER TABLE entityserializablecloneable ADD COLUMN (first_name VARCHAR(255));
ALTER TABLE entityserializablecloneable ADD COLUMN (last_name VARCHAR(255));
ALTER TABLE entityserializablecloneable DROP COLUMN tempBarnacleGenerator;
ALTER TABLE entityserializablecloneable ADD PRIMARY KEY (id);
CREATE TABLE entityserializable (tempBarnacleGenerator varchar(1));
ALTER TABLE entityserializable ADD COLUMN (id VARCHAR(255) NOT NULL);
ALTER TABLE entityserializable ADD COLUMN (first_name VARCHAR(255));
ALTER TABLE entityserializable ADD COLUMN (last_name VARCHAR(255));
ALTER TABLE entityserializable DROP COLUMN tempBarnacleGenerator;
ALTER TABLE entityserializable ADD PRIMARY KEY (id);
