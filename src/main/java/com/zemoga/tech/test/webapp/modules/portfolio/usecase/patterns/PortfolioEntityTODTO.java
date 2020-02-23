package com.zemoga.tech.test.webapp.modules.portfolio.usecase.patterns;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;
import com.zemoga.tech.test.webapp.crosscutting.patters.Translator;
import com.zemoga.tech.test.webapp.crosscutting.persistence.entity.Portfolio;
import com.zemoga.tech.test.webapp.fundation.framework.stereotypes.DesignConcept;

@DesignConcept
public class PortfolioEntityTODTO
		implements Translator<Portfolio, PortfolioDTO> {

	@Override
	public PortfolioDTO translate(final Portfolio input) {
		return PortfolioDTO.builder().id(input.getIdPortfolio())
				.description(input.getDescription()).title(input.getTitle())
				.build();
	}

}
