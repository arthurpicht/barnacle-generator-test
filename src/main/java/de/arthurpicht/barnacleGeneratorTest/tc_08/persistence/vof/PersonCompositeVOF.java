package de.arthurpicht.barnacleGeneratorTest.tc_08.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ForeignKey;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;
import de.arthurpicht.barnacle.annotations.Annotations.Unique;

@Barnacle
public class PersonCompositeVOF {

    @Barnacle
    @PrimaryKey
    protected String id;

    @Barnacle
    protected String userName;

    @Barnacle
    @Unique(name="uk_1")
    @ForeignKey(referenceTableName = "garment_composite", referenceColumnName = {"id1"}, foreignKeyName = "fk_person_garment")
    protected String favoriteGarmentId1;

    @Barnacle
    @Unique(name="uk_1")
    @ForeignKey(referenceTableName = "garment_composite", referenceColumnName = {"id2"}, foreignKeyName = "fk_person_garment")
    protected String favoriteGarmentId2;

}
