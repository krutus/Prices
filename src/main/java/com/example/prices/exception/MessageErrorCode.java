package com.example.prices.exception;

public enum MessageErrorCode {

	ERROR_PRICES_NOT_FOUND {
		@Override
		public String getDescription() {
			return "No se ha encontrado en base de datos el precio solicitado.";
		}
	},
	ERROR_UNEXPECTED {
		@Override
		public String getDescription() {
			return "Unexpected Error";
		}
	}
	;

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public abstract String getDescription();
}
