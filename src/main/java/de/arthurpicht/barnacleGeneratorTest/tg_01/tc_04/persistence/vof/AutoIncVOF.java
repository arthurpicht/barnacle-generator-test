package de.arthurpicht.barnacleGeneratorTest.tg_01.tc_04.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations;
import de.arthurpicht.barnacle.annotations.Annotations.Barnacle;
import de.arthurpicht.barnacle.annotations.Annotations.TableName;

@Barnacle
@TableName("auto_inc")
public class AutoIncVOF {

    @Barnacle
    @Annotations.PrimaryKey(autoIncrement = true)
    protected int id;

    @Barnacle
    protected String name;

}
