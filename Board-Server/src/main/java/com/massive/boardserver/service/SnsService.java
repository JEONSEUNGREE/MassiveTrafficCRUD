package com.massive.boardserver.service;

import com.massive.boardserver.config.AWSConfig;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Service
public class SnsService {

	private final AWSConfig awsConfig;

	public SnsService(AWSConfig awsConfig) {
		this.awsConfig = awsConfig;
	}

	public AwsCredentialsProvider getAwsCredentials(String accessKeyID, String secretAccessKey) {
		AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKeyID, secretAccessKey);
		return () -> awsBasicCredentials;
	}

	public SnsClient getSnsClient() {
		return SnsClient.builder()
			.credentialsProvider(
				getAwsCredentials(awsConfig.getAwsAccessKey(), awsConfig.getAwsSecretKey())
			).region(Region.of(awsConfig.getAwsRegion()))
			.build();
	}

}