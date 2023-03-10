package de.arthurpicht.barnacleGeneratorTest.tc_05.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ForeignKey;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
public class AddressCompositeVOF {

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = {"user_composite"}, referenceColumnName = {"id1"}, entityMethodName = {"user"}, foreignKeyName="fk_address_composite")
    protected String userId1;

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = {"user_composite"}, referenceColumnName = {"id2"}, entityMethodName = {"user"}, foreignKeyName="fk_address_composite")
    protected String userId2;

    @Barnacle
    protected String email;

}
