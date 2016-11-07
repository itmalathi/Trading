package com.jpm.stockmarket.demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TradeRepositoryTest {

	TradeRepository tradeRepository = TradeRepository.getInstance();
	
	@Before
	public void setUp()
	{
		tradeRepository.populateDemoData();
	}
	
	@Test
	public void testVolumeWeightStockPrice_For_Tea()
	{
		double val = tradeRepository.getVolumeWeightStockPrice("TEA", Utils.getStartTime());
		assertEquals(val, 5.0, 1e-9);
	}
	
	@Test
	public void testAllShareIndex()
	{
		double val = tradeRepository.getAllShareIndex();
		assertEquals(val, 625.0, 1e-9);
	}
}
