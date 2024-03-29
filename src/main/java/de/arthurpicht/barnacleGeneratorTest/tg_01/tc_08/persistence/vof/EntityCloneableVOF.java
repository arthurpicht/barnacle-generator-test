package de.arthurpicht.barnacleGeneratorTest.tg_01.tc_08.persistence.vof;



import static de.arthurpicht.barnacle.annotations.Annotations.*;

@Barnacle
@CloneableVo
public class EntityCloneableVOF {

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
