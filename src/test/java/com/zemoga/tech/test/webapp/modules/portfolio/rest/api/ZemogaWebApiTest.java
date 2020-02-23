package com.zemoga.tech.test.webapp.modules.portfolio.rest.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.zemoga.tech.test.webapp.fundation.framework.exceptions.PortfolioSystemException;
import com.zemoga.tech.test.webapp.modules.portfolio.DataAcrossTestingProject;
import com.zemoga.tech.test.webapp.modules.portfolio.usecase.ZemogaPortforlioManager;

@RunWith(MockitoJUnitRunner.class)
public class ZemogaWebApiTest {

	@Mock
	private ZemogaPortforlioManager portfolioManager;

	@InjectMocks
	private ZemogaWebApi api;

	@Test
	public void getPortfolioInformationTest() {
		try {
			when(portfolioManager.searchPortfolio(Mockito.anyInt()))
					.thenReturn(DataAcrossTestingProject.createPortfolioDTO());

			final ResponseEntity<Object> response =
					api.getPortfolioInformation(1);

			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertNotNull(response.getBody());

		} catch (final PortfolioSystemException e) {
			fail();
		}
	}

	@Test
	public void getPortfolioInformationThrowsExceptionTest()
			throws PortfolioSystemException {
		when(portfolioManager.searchPortfolio(Mockito.anyInt()))
				.thenThrow(PortfolioSystemException.class);

		final ResponseEntity<Object> response = api.getPortfolioInformation(1);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
}
