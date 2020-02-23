package com.zemoga.tech.test.webapp.modules.portfolio.dataprovider.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;
import com.zemoga.tech.test.webapp.crosscutting.patters.Translator;
import com.zemoga.tech.test.webapp.crosscutting.persistence.PortfolioRepository;
import com.zemoga.tech.test.webapp.crosscutting.persistence.entity.Portfolio;
import com.zemoga.tech.test.webapp.fundation.framework.exceptions.ExceptionBuilder;
import com.zemoga.tech.test.webapp.fundation.framework.exceptions.PortfolioSystemException;
import com.zemoga.tech.test.webapp.fundation.framework.stereotypes.DataProvider;
import com.zemoga.tech.test.webapp.modules.portfolio.dataprovider.ZemogaPortfolioDataProvider;

import lombok.extern.log4j.Log4j2;

@Log4j2
@DataProvider
public class ZemogaPortfolioJPADataProvider
		implements ZemogaPortfolioDataProvider {

	private static final String ERROR_LOOKING_FOR_PORTFOLIO =
			"There was an error looking for portfolio";

	private static final String ERROR_UPDATING_PORTFOLIO =
			"There was an error looking for portfolio";

	@Autowired
	private PortfolioRepository repository;

	@Autowired
	@Qualifier("portfolioDTOTOEntity")
	Translator<PortfolioDTO, Portfolio> translatorDTOToEntity;

	@Override
	public PortfolioDTO getPortfolioInformationByPortfolioId(
			final Integer portfolioId) throws PortfolioSystemException {
		try {
			log.info("data-provider: Searching portfolio in the database");
			return repository.getPortfolioInformationByUserId(portfolioId);
		} catch (final DataAccessException e) {
			log.error(ERROR_LOOKING_FOR_PORTFOLIO);
			throw ExceptionBuilder.builder()
					.withMessage(ERROR_LOOKING_FOR_PORTFOLIO).withException(e)
					.portfolioSystemException();
		}

	}

	@Override
	public void updatePortfolioInformationByPortfolioId(
			final PortfolioDTO portfolio) throws PortfolioSystemException {
		try {
			log.info("data-provider: updating portfolio in the database");
			repository.updatePortfolioInformationByPortfolioId(
					translatorDTOToEntity.translate(portfolio));
		} catch (final DataAccessException e) {
			log.error(ERROR_UPDATING_PORTFOLIO);
			throw ExceptionBuilder.builder()
					.withMessage(ERROR_UPDATING_PORTFOLIO).withException(e)
					.portfolioSystemException();
		}
	}

}
