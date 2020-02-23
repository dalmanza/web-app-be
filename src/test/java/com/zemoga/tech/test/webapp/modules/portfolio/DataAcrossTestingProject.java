package com.zemoga.tech.test.webapp.modules.portfolio;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;

public class DataAcrossTestingProject {

	public static final String TWITTER = "twitter";

	public static final String TITLE = "title";

	public static final String IMAGE_URL = "image url";

	public static final String DESCRIPTION = "description";

	public static PortfolioDTO createPortfolioDTO() {
		return PortfolioDTO.builder().id(1).description(DESCRIPTION)
				.imageURL(IMAGE_URL).title(TITLE).twitterUserName(TWITTER)
				.build();
	}

}
