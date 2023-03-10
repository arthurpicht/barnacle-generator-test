SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS addresscomposite;
DROP TABLE IF EXISTS user_composite;
SET REFERENTIAL_INTEGRITY TRUE;
CREATE TABLE addresscomposite (tempBarnacleGenerator varchar(1));
ALTER TABLE addresscomposite ADD COLUMN (userId1 VARCHAR(255) NOT NULL);
ALTER TABLE addresscomposite ADD COLUMN (userId2 VARCHAR(255) NOT NULL);
ALTER TABLE addresscomposite ADD COLUMN (email VARCHAR(255));
ALTER TABLE addresscomposite DROP COLUMN tempBarnacleGenerator;
ALTER TABLE addresscomposite ADD PRIMARY KEY (userId1, userId2);
CREATE TABLE user_composite (tempBarnacleGenerator varchar(1));
ALTER TABLE user_composite ADD COLUMN (id1 VARCHAR(255) NOT NULL);
ALTER TABLE user_composite ADD COLUMN (id2 VARCHAR(255) NOT NULL);
ALTER TABLE user_composite ADD COLUMN (userName VARCHAR(255));
ALTER TABLE user_composite DROP COLUMN tempBarnacleGenerator;
ALTER TABLE user_composite ADD PRIMARY KEY (id1, id2);
ALTER TABLE addresscomposite ADD CONSTRAINT fk_address_composite FOREIGN KEY (userId1, userId2) REFERENCES user_composite (id1, id2);
