package com.techgem.tma.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("aws")
public class DynamodbConfiguration {

    private static final DynamoDBMapperConfig.TableNameResolver TABLE_NAME_RESOLVER = (className, config) -> "tasks";

    ClientConfiguration getClientConfiguration() {
        ClientConfiguration cfg = new ClientConfiguration();
        cfg.setProtocol(Protocol.HTTPS);
        cfg.setProxyPort(8099);
        return cfg;
    }

    @Bean(name = "dynamoDBMapper")
    public DynamoDBMapper dynamoDBMapper() {
        Regions region = Regions.US_EAST_1;
        DynamoDBMapperConfig dbMapperConfig = new DynamoDBMapperConfig.Builder().withTableNameResolver(TABLE_NAME_RESOLVER).build();
        AmazonDynamoDBClient dynamoClient = getAmazonDynamoDBClient(region);
        return new DynamoDBMapper(dynamoClient, dbMapperConfig);
    }

    // This Client is configured for Non-Local Profile for Dev, QA, Perf and Prod Profiles on EC2 Instances.
    private AmazonDynamoDBClient getAmazonDynamoDBClient(Regions region) {
        return (AmazonDynamoDBClient) AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withClientConfiguration(getClientConfiguration()).withRegion(region).build();
    }


}
