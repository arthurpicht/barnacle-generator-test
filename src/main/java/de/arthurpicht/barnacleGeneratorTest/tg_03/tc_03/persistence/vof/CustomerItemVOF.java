package de.arthurpicht.barnacleGeneratorTest.tg_03.tc_03.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.*;

@Barnacle
@AssociationTable(foreignKeyNameA = "fk_customer", foreignKeyNameB = "fk_item")
@TableName("customer_item")
public class CustomerItemVOF {

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = "customer", referenceColumnName = "id_part_1", foreignKeyName = "fk_customer")
    protected String customerIdPart1;

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = "customer", referenceColumnName = "id_part_2", foreignKeyName = "fk_customer")
    protected String customerIdPart2;

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = "item", referenceColumnName = "id1", foreignKeyName = "fk_item")
    protected String itemId1;

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = "item", referenceColumnName = "id2", foreignKeyName = "fk_item")
    protected String itemId2;

}
