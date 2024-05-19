package com.safeguard.safeguardbackend.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamoDBTable(tableName = "payment")
public class Payment {
    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private String accountFromId;

    @DynamoDBAttribute
    private String accountToId;

    @DynamoDBAttribute
    private Double amount;
}
