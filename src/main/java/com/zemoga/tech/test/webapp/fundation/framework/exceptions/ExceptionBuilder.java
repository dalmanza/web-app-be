package com.zemoga.tech.test.webapp.fundation.framework.exceptions;

public final class ExceptionBuilder {

	private String message;
	private Throwable exception;

	private ExceptionBuilder() {
	}

	public static ExceptionBuilder builder() {
		return new ExceptionBuilder();
	}

	public ExceptionBuilder withMessage(final String message) {
		this.message = message;
		return this;
	}

	public ExceptionBuilder withException(final Throwable exception) {
		this.exception = exception;
		return this;
	}

	public PortfolioSystemException portfolioSystemException() {
		return new PortfolioSystemException(message, exception);
	}
}
