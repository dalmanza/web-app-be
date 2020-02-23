package com.zemoga.tech.test.webapp.fundation.framework.exceptions;

public class PortfolioSystemException extends PortfolioApplicationException {

	private static final long serialVersionUID = 1L;

	public PortfolioSystemException(final String message,
			final Throwable exception) {
		super(message, exception);
	}

}
