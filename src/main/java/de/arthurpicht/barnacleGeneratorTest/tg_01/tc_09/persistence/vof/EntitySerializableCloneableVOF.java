package de.arthurpicht.barnacleGeneratorTest.tg_01.tc_09.persistence.vof;

import java.io.Serializable;

import static de.arthurpicht.barnacle.annotations.Annotations.*;

@Barnacle
@SerializableVo(
        serialVersionUID = 42L
)
@CloneableVo
public class EntitySerializableCloneableVOF implements Serializable {

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
