package de.arthurpicht.barnacleGeneratorTest.tg_03.tc_01.persistence.vof;

import de.arthurpicht.barnacle.annotations.Annotations.*;

@Barnacle
@AssociationTable(foreignKeyNameA = "fk_customer", foreignKeyNameB = "fk_item")
@TableName("customer_item")
public class CustomerItemVOF {

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = "customer", referenceColumnName = "id", foreignKeyName = "fk_customer")
    protected String customerId;

    @Barnacle
    @PrimaryKey
    @ForeignKey(referenceTableName = "item", referenceColumnName = "id", foreignKeyName = "fk_item")
    protected String itemId;

}
