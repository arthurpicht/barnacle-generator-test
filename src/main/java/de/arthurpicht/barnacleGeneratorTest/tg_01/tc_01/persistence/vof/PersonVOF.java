package de.arthurpicht.barnacleGeneratorTest.tg_01.tc_01.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ColumnName;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
public class PersonVOF {

    @Barnacle
    @ColumnName("id")
    @PrimaryKey
    protected String id;

    @Barnacle
    @ColumnName("first_name")
    protected String firstName;

    @Barnacle
    @ColumnName("last_name")
    protected String lastName;

}
