package com.zemoga.tech.test.webapp.modules.portfolio.usecase.patterns;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;
import com.zemoga.tech.test.webapp.crosscutting.patters.Translator;
import com.zemoga.tech.test.webapp.crosscutting.persistence.entity.Portfolio;
import com.zemoga.tech.test.webapp.fundation.framework.stereotypes.DesignConcept;

@DesignConcept
public class PortfolioDTOTOEntity
		implements Translator<PortfolioDTO, Portfolio> {

	@Override
	public Portfolio translate(final PortfolioDTO input) {
		return Portfolio.builder().idPortfolio(input.getId())
				.description(input.getDescription()).title(input.getTitle())
				.build();
	}

}
