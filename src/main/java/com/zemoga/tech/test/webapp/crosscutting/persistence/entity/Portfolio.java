package com.zemoga.tech.test.webapp.crosscutting.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
@Table(name = "portfolio")
public class Portfolio {

	@Id
	@Column(name = "idportfolio")
	private final Integer idPortfolio;

	@Column(name = "description")
	private final String description;

	@Column(name = "image_url")
	private final String imageURL;

	@Column(name = "twitter_user_name")
	private final String twitterUserName;

	@Column(name = "title")
	private final String title;
}
