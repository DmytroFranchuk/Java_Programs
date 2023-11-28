package org.ls_2023_11_09_mockitoTest.praktika.mockito.stub;

import java.util.Collection;

public interface PricingService {

	// [... other methods ...]
	
	Price getHighestPricedTrade(Collection<Trade> trades);
}