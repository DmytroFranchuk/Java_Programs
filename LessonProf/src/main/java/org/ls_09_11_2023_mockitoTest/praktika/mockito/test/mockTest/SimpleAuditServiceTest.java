package org.ls_09_11_2023_mockitoTest.praktika.mockito.test.mockTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ls_09_11_2023_mockitoTest.praktika.mockito.mock.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SimpleAuditServiceTest {

	@Mock  // actually, this is a stub
	TradeRepository tradeRepository;

	@Mock
	Trade trade;

	@Mock  // and this one is indeed a mock
	AuditService auditService;

	@Test
	public void testAuditLogEntryMadeForNewTrade() throws Exception {
	//	Trade trade = new Trade("Ref", "Description ");

		when(tradeRepository.createTrade(trade)).thenReturn(anyLong());

		TradingService tradingService = new SimpleTradingService(tradeRepository, auditService);
		tradingService.createTrade(trade);

		verify(auditService).logNewTrade(trade);
	}
}