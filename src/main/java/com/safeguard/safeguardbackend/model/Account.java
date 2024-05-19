package com.safeguard.safeguardbackend.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamoDBTable(tableName = "account")
public class Account {
    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private String userId;

    @DynamoDBAttribute
    private Double balance;

    @DynamoDBAttribute
    private List<String> paymentsIds;
}
