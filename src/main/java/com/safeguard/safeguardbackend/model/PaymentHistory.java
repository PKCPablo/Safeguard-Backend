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
@DynamoDBTable(tableName = "paymentHistory")
public class PaymentHistory {
    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private String userId;

    @DynamoDBAttribute
    private List<String> paymentsId;
}
