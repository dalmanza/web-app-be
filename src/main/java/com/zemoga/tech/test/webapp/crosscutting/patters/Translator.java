package com.zemoga.tech.test.webapp.crosscutting.patters;

@FunctionalInterface
public interface Translator<I, O> {
	O translate(final I input);
}
