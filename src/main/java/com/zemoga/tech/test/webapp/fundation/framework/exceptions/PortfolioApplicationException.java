package com.zemoga.tech.test.webapp.fundation.framework.exceptions;

public class PortfolioApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public PortfolioApplicationException(final String message) {
		super(message);
	}

	public PortfolioApplicationException(final String message,
			final Throwable exception) {
		super(message, exception);
	}

}
