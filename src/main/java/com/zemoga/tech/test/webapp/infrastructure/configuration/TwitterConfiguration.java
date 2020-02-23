package com.zemoga.tech.test.webapp.infrastructure.configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfiguration {

	public static Twitter getTwitterinstance() {
		final ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("KRy7l0v8wex3w8Sy5zThai3Ea")
				.setOAuthConsumerSecret(
						"X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu")
				.setOAuthAccessToken(
						"1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja")
				.setOAuthAccessTokenSecret(
						"tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj");
		final TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();

	}
}
