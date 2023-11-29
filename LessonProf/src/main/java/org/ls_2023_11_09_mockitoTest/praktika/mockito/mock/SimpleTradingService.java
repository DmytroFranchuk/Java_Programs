package org.ls_2023_11_09_mockitoTest.praktika.mockito.mock;

public class SimpleTradingService implements TradingService {

	TradeRepository tradeRepository;
	AuditService auditService;

	public SimpleTradingService(TradeRepository tradeRepository, AuditService auditService) {
		this.tradeRepository = tradeRepository;
		this.auditService = auditService;
	}

	@Override
	public Long createTrade(Trade trade) throws CreateTradeException {
		Long id = tradeRepository.createTrade(trade);
		auditService.logNewTrade(trade);
		return id;
	}
}