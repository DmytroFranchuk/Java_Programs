package org.ls_09_11_2023_mockitoTest.praktika.mockito.stub;

import java.util.Collection;

public interface PricingService {

	// [... other methods ...]
	
	Price getHighestPricedTrade(Collection<Trade> trades);
}