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
@DynamoDBTable(tableName = "producto")
public class Product {

    @DynamoDBHashKey
    private Integer id;

    @DynamoDBAttribute
    private String nombre;

    @DynamoDBAttribute
    private String precio;
}