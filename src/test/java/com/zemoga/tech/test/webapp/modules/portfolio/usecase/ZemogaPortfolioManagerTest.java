package com.zemoga.tech.test.webapp.modules.portfolio.usecase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.zemoga.tech.test.webapp.crosscutting.domain.PortfolioDTO;
import com.zemoga.tech.test.webapp.fundation.framework.exceptions.PortfolioSystemException;
import com.zemoga.tech.test.webapp.modules.portfolio.DataAcrossTestingProject;
import com.zemoga.tech.test.webapp.modules.portfolio.dataprovider.ZemogaPortfolioDataProvider;

@RunWith(MockitoJUnitRunner.class)
public class ZemogaPortfolioManagerTest {

	@Mock
	private ZemogaPortfolioDataProvider dataprovider;

	@InjectMocks
	private ZemogaPortforlioManager usecase;

	@Test
	public void searchPortfolioTest() {

		try {
			when(dataprovider.getPortfolioInformationByPortfolioId(
					Mockito.anyInt())).thenReturn(
							DataAcrossTestingProject.createPortfolioDTO());

			final PortfolioDTO searchPortfolio = usecase.searchPortfolio(1);

			assertEquals(DataAcrossTestingProject.DESCRIPTION,
					searchPortfolio.getDescription());
			assertEquals(DataAcrossTestingProject.IMAGE_URL,
					searchPortfolio.getImageURL());
			assertEquals(DataAcrossTestingProject.TITLE,
					searchPortfolio.getTitle());
			assertEquals(DataAcrossTestingProject.TWITTER,
					searchPortfolio.getTwitterUserName());

		} catch (final PortfolioSystemException e) {
			fail();
		}
	}

	@Test(expected = PortfolioSystemException.class)
	public void searchPortfolioThrowsExceptionTest()
			throws PortfolioSystemException {
		when(dataprovider
				.getPortfolioInformationByPortfolioId(Mockito.anyInt()))
						.thenThrow(PortfolioSystemException.class);

		usecase.searchPortfolio(2);
	}

}
