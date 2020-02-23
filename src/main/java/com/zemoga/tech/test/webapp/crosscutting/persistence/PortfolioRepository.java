package com.zemoga.tech.test.webapp.crosscutting.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;
import com.zemoga.tech.test.webapp.crosscutting.persistence.entity.Portfolio;

public interface PortfolioRepository
		extends CrudRepository<Portfolio, Integer> {

	@Query("SELECT new com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO(p.idPortfolio, "
			+ " p.description, p.imageURL, p.twitterUserName, p.title)"
			+ " FROM Portfolio p WHERE p.idPortfolio = :portfolioId")
	PortfolioDTO getPortfolioInformationByUserId(
			@Param("portfolioId") final Integer portfolioId);

	@Transactional
	@Modifying
	@Query("UPDATE Portfolio p SET p.description = :#{#portfolio.description},"
			+ " p.title = :#{#portfolio.title}"
			+ " WHERE p.idPortfolio = :#{#portfolio.idPortfolio}")
	void updatePortfolioInformationByPortfolioId(
			@Param("portfolio") final Portfolio portfolio);

}
