package com.zemoga.tech.test.webapp.modules.portfolio.dataprovider;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;
import com.zemoga.tech.test.webapp.fundation.framework.exceptions.PortfolioSystemException;

public interface ZemogaPortfolioDataProvider {

	PortfolioDTO getPortfolioInformationByPortfolioId(final Integer portfolioId)
			throws PortfolioSystemException;

	void updatePortfolioInformationByPortfolioId(final PortfolioDTO portfolio)
			throws PortfolioSystemException;
}
