package de.arthurpicht.barnacleGeneratorTest.tc_03.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ColumnName;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;
import de.arthurpicht.barnacle.annotations.Annotations.TableName;

@Barnacle
@TableName("object_types")
public class ObjectTypesVOF {

    @Barnacle
    @PrimaryKey
    protected String id;

    @Barnacle
    @ColumnName("my_boolean")
    protected Boolean myBoolean;

    @Barnacle
    @ColumnName("my_int")
    protected Integer myInt;

    @Barnacle
    @ColumnName("my_long")
    protected Long myLong;

    @Barnacle
    @ColumnName("my_float")
    protected Float myFloat;

    @Barnacle
    @ColumnName("my_double")
    protected Double myDouble;

    @Barnacle
    @ColumnName("my_byte")
    protected Byte myByte;

    @Barnacle
    @ColumnName("my_short")
    protected Short myShort;

}
