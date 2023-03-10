package de.arthurpicht.barnacleGeneratorTest.tc_05.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ForeignKey;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
public class AddressVOF {

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = {"user_table"}, referenceColumnName = {"id"}, entityMethodName = {"user"})
    protected String userId;

    @Barnacle
    protected String email;

}
