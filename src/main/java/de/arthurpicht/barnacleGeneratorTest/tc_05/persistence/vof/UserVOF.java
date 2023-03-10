package de.arthurpicht.barnacleGeneratorTest.tc_05.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations;
import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
@Annotations.TableName("user_table")
public class UserVOF {

    @Barnacle
    @PrimaryKey
    protected String id;

    @Barnacle
    protected String userName;

}
