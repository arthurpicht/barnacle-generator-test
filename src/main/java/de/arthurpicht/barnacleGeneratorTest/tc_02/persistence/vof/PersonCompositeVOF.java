package de.arthurpicht.barnacleGeneratorTest.tc_02.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ColumnName;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;
import de.arthurpicht.barnacle.annotations.Annotations.TableName;

@Barnacle
@TableName("person_composite")
public class PersonCompositeVOF {

    @Barnacle
    @ColumnName("first_name")
    @PrimaryKey
    protected String firstName;

    @Barnacle
    @ColumnName("last_name")
    @PrimaryKey
    protected String lastName;

    @Barnacle
    protected int age;

}
