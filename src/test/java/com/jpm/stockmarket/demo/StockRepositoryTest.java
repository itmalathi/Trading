package com.jpm.stockmarket.demo;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class StockRepositoryTest {

	StockRepository stockRepository = StockRepository.getInstance();
	
	@Before
	public void setUp()
	{
		stockRepository.populateDemoData();
	}
	
	@Test
	public void testDividentYield_For_Tea()
	{
		double dividentYield = stockRepository.getDividentYield("TEA", 1.5);
		assertEquals(dividentYield, 0, 1e-9);
	}
	
	@Test
	public void testDividentYield_For_Pop()
	{
		double dividentYield = stockRepository.getDividentYield("POP", 1.5);
		assertEquals(dividentYield, 5.33, 0.1);
	}
	
	@Test
	public void testDividentYield_For_Gin()
	{
		double dividentYield = stockRepository.getDividentYield("GIN", 1.5);
		assertEquals(dividentYield, 1.33, 0.1);
	}
	
	@Test
	public void testPeratio_For_Tea()
	{
		double peRatio = stockRepository.getPERatio("TEA", 1.5);
		assertEquals(peRatio, 0, 1e-9);
	}
	
	@Test
	public void testPeratio_For_Pop()
	{
		double peRatio = stockRepository.getPERatio("POP", 1.5);
		assertEquals(peRatio, 0.187, 0.1);
	}
	
	@Test
	public void testStockGin()
	{
		Stock stock = stockRepository.getStock("gin");
		assertEquals(stock.getStockType(), ProductType.Preferred);
		
		assertEquals(stock.getParValue(), 100);
		
		assertEquals(stock.getFixedDividend(), 2.0, 1e-9);
		assertEquals(stock.getLastDividend(), 8.0, 1e-9);
	}
}
