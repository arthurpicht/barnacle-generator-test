package de.arthurpicht.barnacleGeneratorTest.tg_01.tc_06.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;
import de.arthurpicht.barnacle.annotations.Annotations.Unique;

@Barnacle
public class PersonVOF {

    @Barnacle
    @PrimaryKey
    protected String id;

    @Barnacle
    @Unique(name="uk_name")
    protected String firstName;

    @Barnacle
    @Unique(name="uk_name")
    protected String lastName;

}
