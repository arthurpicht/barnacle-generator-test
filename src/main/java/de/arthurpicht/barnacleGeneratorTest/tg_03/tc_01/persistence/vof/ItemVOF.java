package de.arthurpicht.barnacleGeneratorTest.tg_03.tc_01.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
public class ItemVOF {

    @Barnacle
    @PrimaryKey
    protected String id;

    @Barnacle
    protected String description;

}
