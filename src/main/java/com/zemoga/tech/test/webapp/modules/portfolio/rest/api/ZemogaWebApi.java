package com.zemoga.tech.test.webapp.modules.portfolio.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;
import com.zemoga.tech.test.webapp.fundation.framework.exceptions.PortfolioSystemException;
import com.zemoga.tech.test.webapp.modules.portfolio.usecase.ZemogaPortforlioManager;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/portfolio-information")
public class ZemogaWebApi {

	@Autowired
	private ZemogaPortforlioManager portfolioManager;

	@GetMapping(value = "/{portfolio-id}")
	public ResponseEntity<Object> getPortfolioInformation(
			@PathVariable("portfolio-id") final Integer portfolioId) {
		try {
			log.info("web-api: Searching portfolio with id: {}", portfolioId);
			return ResponseEntity
					.ok(portfolioManager.searchPortfolio(portfolioId));
		} catch (final PortfolioSystemException e) {
			log.error("There was an error looking for the portfolio");
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Object> updatePortfolioInformation(
			@RequestBody final PortfolioDTO portfolio) {
		try {
			log.info("web-api: updating portfolio with id: {}",
					portfolio.getId());
			return ResponseEntity
					.ok(portfolioManager.updatePortfolio(portfolio));
		} catch (final PortfolioSystemException e) {
			log.error("There was an error looking for the portfolio");
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping(value = "/twitter-time-line/{search}")
	public ResponseEntity<Object>
			getTwitterTimeLine(@PathVariable("search") final String search) {
		try {
			log.info("web-api: searching tweets");
			return ResponseEntity.ok(portfolioManager.searchTweets(search));
		} catch (final PortfolioSystemException e) {
			log.error("There was an error looking for the tweets");
			return ResponseEntity.badRequest().build();
		}

	}
}
