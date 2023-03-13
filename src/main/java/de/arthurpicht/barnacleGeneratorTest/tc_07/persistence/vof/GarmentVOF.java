package de.arthurpicht.barnacleGeneratorTest.tc_07.persistence.vof;

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
