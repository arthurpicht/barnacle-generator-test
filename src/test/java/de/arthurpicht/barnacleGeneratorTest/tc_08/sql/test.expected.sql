SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS garment_composite;
DROP TABLE IF EXISTS personcomposite;
SET REFERENTIAL_INTEGRITY TRUE;
CREATE TABLE garment_composite (tempBarnacleGenerator varchar(1));
ALTER TABLE garment_composite ADD COLUMN (id1 VARCHAR(255) NOT NULL);
ALTER TABLE garment_composite ADD COLUMN (id2 VARCHAR(255) NOT NULL);
ALTER TABLE garment_composite ADD COLUMN (name VARCHAR(255));
ALTER TABLE garment_composite DROP COLUMN tempBarnacleGenerator;
ALTER TABLE garment_composite ADD PRIMARY KEY (id1, id2);
CREATE TABLE personcomposite (tempBarnacleGenerator varchar(1));
ALTER TABLE personcomposite ADD COLUMN (id VARCHAR(255) NOT NULL);
ALTER TABLE personcomposite ADD COLUMN (userName VARCHAR(255));
ALTER TABLE personcomposite ADD COLUMN (favoriteGarmentId1 VARCHAR(255));
ALTER TABLE personcomposite ADD COLUMN (favoriteGarmentId2 VARCHAR(255));
ALTER TABLE personcomposite DROP COLUMN tempBarnacleGenerator;
ALTER TABLE personcomposite ADD PRIMARY KEY (id);
ALTER TABLE personcomposite ADD CONSTRAINT uk_1 UNIQUE (favoriteGarmentId1, favoriteGarmentId2);
ALTER TABLE personcomposite ADD CONSTRAINT fk_person_garment FOREIGN KEY (favoriteGarmentId1, favoriteGarmentId2) REFERENCES garment_composite (id1, id2);
