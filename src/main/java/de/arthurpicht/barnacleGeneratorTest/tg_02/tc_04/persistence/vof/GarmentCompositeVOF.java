package de.arthurpicht.barnacleGeneratorTest.tg_02.tc_04.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations;
import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.PrimaryKey;

@Barnacle
@Annotations.TableName("garment_composite")
public class GarmentCompositeVOF {

    @Barnacle
    @PrimaryKey
    protected String id1;

    @Barnacle
    @PrimaryKey
    protected String id2;

    @Barnacle
    protected String name;

}
