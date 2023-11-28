package org.ls_2023_11_09_mockitoTest.praktika.mockito.stub;

public class PricingRepository {

	// [... other methods ...]

	public Price getPriceForTrade(Trade trade) {
		return trade.price;
	}
}