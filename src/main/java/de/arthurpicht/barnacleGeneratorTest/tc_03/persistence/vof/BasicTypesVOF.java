package de.arthurpicht.barnacleGeneratorTest.tc_03.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ColumnName;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;
import de.arthurpicht.barnacle.annotations.Annotations.TableName;

@Barnacle
@TableName("basic_types")
public class BasicTypesVOF {

    @Barnacle
    @PrimaryKey
    protected String id;

    @Barnacle
    @ColumnName("my_boolean")
    protected boolean myBoolean;

    @Barnacle
    @ColumnName("my_int")
    protected int myInt;

    @Barnacle
    @ColumnName("my_long")
    protected long myLong;

    @Barnacle
    @ColumnName("my_float")
    protected float myFloat;

    @Barnacle
    @ColumnName("my_double")
    protected double myDouble;

    @Barnacle
    @ColumnName("my_byte")
    protected byte myByte;

    @Barnacle
    @ColumnName("my_short")
    protected short myShort;

}
