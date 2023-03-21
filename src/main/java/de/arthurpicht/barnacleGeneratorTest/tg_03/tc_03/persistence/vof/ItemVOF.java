package de.arthurpicht.barnacleGeneratorTest.tg_03.tc_03.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
public class ItemVOF {

    @Barnacle
    @PrimaryKey
    protected String id1;

    @Barnacle
    @PrimaryKey
    protected String id2;

    @Barnacle
    protected String description;

}
