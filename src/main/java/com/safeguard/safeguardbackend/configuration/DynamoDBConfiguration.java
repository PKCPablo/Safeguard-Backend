package com.safeguard.safeguardbackend.configuration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableDynamoDBRepositories(basePackages = {"com.safeguard.safeguardbackend.repository"})
public class DynamoDBConfiguration {

    @Bean
    @Primary
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDBMapper(amazonDynamoDB);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        return AmazonDynamoDBClientBuilder.defaultClient();
    }
}