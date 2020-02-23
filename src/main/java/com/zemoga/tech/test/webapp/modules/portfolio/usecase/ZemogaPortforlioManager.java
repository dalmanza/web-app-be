package com.zemoga.tech.test.webapp.modules.portfolio.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;
import com.zemoga.tech.test.webapp.crosscutting.domain.TweetDTO;
import com.zemoga.tech.test.webapp.fundation.framework.exceptions.ExceptionBuilder;
import com.zemoga.tech.test.webapp.fundation.framework.exceptions.PortfolioSystemException;
import com.zemoga.tech.test.webapp.fundation.framework.stereotypes.UseCase;
import com.zemoga.tech.test.webapp.infrastructure.configuration.TwitterConfiguration;
import com.zemoga.tech.test.webapp.modules.portfolio.dataprovider.ZemogaPortfolioDataProvider;

import lombok.extern.log4j.Log4j2;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Log4j2
@UseCase
public class ZemogaPortforlioManager {

	private static final String ERROR_SEARCHING_TWEETS =
			"Error searching for tweets";

	private static final String ERROR_SEARCHING_PORTFOLIO =
			"There was an error searching portfolio";

	private static final String ERROR_UPDATING_PORTFOLIO =
			"There was an error updating portfolio";

	@Autowired
	private ZemogaPortfolioDataProvider dataprovider;

	public PortfolioDTO searchPortfolio(final Integer portfolioId)
			throws PortfolioSystemException {
		try {
			log.info("use-case: retrieving portfolio");
			return dataprovider
					.getPortfolioInformationByPortfolioId(portfolioId);
		} catch (final PortfolioSystemException e) {
			log.error(ERROR_SEARCHING_PORTFOLIO);
			throw ExceptionBuilder.builder()
					.withMessage(ERROR_SEARCHING_PORTFOLIO).withException(e)
					.portfolioSystemException();
		}
	}

	public PortfolioDTO updatePortfolio(final PortfolioDTO portfolio)
			throws PortfolioSystemException {
		try {
			log.info("use-case: updating portfolio");
			dataprovider.updatePortfolioInformationByPortfolioId(portfolio);
			return dataprovider
					.getPortfolioInformationByPortfolioId(portfolio.getId());
		} catch (final PortfolioSystemException e) {
			log.error(ERROR_UPDATING_PORTFOLIO);
			throw ExceptionBuilder.builder()
					.withMessage(ERROR_UPDATING_PORTFOLIO).withException(e)
					.portfolioSystemException();
		}
	}

	public List<TweetDTO> searchTweets(final String search)
			throws PortfolioSystemException {
		try {
			final Twitter twitter = TwitterConfiguration.getTwitterinstance();
			QueryResult results;
			results = twitter.search(new Query(search));
			return results.getTweets().stream().limit(5L)
					.map(tweet -> TweetDTO.builder()
							.user(tweet.getUser().getName())
							.tweet(tweet.getText()).build())
					.collect(Collectors.toList());
		} catch (final TwitterException e) {
			log.error(ERROR_SEARCHING_TWEETS);
			throw ExceptionBuilder.builder().withMessage(ERROR_SEARCHING_TWEETS)
					.withException(e).portfolioSystemException();
		}
	}

}
