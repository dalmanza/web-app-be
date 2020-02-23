package com.zemoga.tech.test.webapp.crosscutting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TweetDTO {

	private String user;
	private String tweet;

}
