package com.zemoga.tech.test.webapp.crosscutting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDTO {

	private Integer id;
	private String description;
	private String imageURL;
	private String twitterUserName;
	private String title;
}
