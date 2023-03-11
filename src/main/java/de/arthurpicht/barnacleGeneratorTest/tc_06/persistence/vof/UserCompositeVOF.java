package de.arthurpicht.barnacleGeneratorTest.tc_06.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations;
import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
@Annotations.TableName("user_composite")
public class UserCompositeVOF {

    @Barnacle
    @PrimaryKey
    protected String id1;

    @Barnacle
    @PrimaryKey
    protected String id2;

    @Barnacle
    protected String userName;

}
