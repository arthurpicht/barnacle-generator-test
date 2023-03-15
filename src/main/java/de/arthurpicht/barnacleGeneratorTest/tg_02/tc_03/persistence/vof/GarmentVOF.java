package de.arthurpicht.barnacleGeneratorTest.tg_02.tc_03.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
public class GarmentVOF {

    @Barnacle
    @PrimaryKey
    protected String id;

    @Barnacle
    protected String name;

}
