package de.arthurpicht.barnacleGeneratorTest.tg_03.tc_03.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.ColumnName;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
public class CustomerVOF {

    @Barnacle
    @PrimaryKey
    @ColumnName("id_part_1")
    protected String idPart1;

    @Barnacle
    @PrimaryKey
    @ColumnName("id_part_2")
    protected String idPart2;

    @Barnacle
    protected String name;

}
