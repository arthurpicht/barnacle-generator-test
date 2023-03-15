package de.arthurpicht.barnacleGeneratorTest.tc_09.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ForeignKey;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;
import de.arthurpicht.barnacle.annotations.Annotations.Unique;

@Barnacle
public class PersonVOF {

    @Barnacle
    @PrimaryKey
    protected String id;

    @Barnacle
    @Unique
    protected String userName;

    @Barnacle
    protected String firstName;

}
