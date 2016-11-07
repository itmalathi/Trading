///////////////////////////////////////////////////////////////////////////////////
////////////////DemoStockMarket//////////////////////////////////////////////////

package com.jpm.stockmarket.demo;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Creates, manipulates and manages Stock Repository information

public class StockRepository {
	
	private static StockRepository instance;
	public List<Stock> stocks = new ArrayList<>();
	Logger logger = LoggerFactory.getLogger(StockRepository.class);
	
	private StockRepository() {
		
	}

	// Singleton class
	public static StockRepository getInstance() {
		if (instance == null) {
			instance = new StockRepository();
		}
		return instance;
	}

	public void populateDemoData() {
		addStock(new Stock("TEA", ProductType.Common, 0, null, 100));
		addStock(new Stock("POP", ProductType.Common, 8, null, 100));
		addStock(new Stock("ALE", ProductType.Common, 23, null, 60));
		addStock(new Stock("GIN", ProductType.Preferred, 8, 2.0, 100));
		addStock(new Stock("JOE", ProductType.Common, 13, null, 250));
	}
	
	// Adds stock to the repository
	private void addStock(Stock stock)
	{
		stocks.add(stock);
		logger.debug("Stock " + stock.toString() + " is added");
	}

	// Returns the required stock
	public Stock getStock(String stockName) {
		Stock matchingStock = null;
		Stock stock = stocks.stream().filter(e -> e.getStockName().equalsIgnoreCase(stockName)).findFirst().get();
		if (stock != null) {
			logger.debug("Stock " + stockName + " is not found in the repository");
			return stock;
		}
		return matchingStock;
	}
	
	//Calculates Dividend Yield for a given stock
	public double getDividentYield(String stockName, double price) {
		Stock stock = getStock(stockName);
		return stock.getDividentYield(price);
	}

	//Calculates PERatio for a given stock
	public double getPERatio(String stockName, double price) {
		Stock stock = getStock(stockName);
		return stock.getPERatio(price);
	}
	
}
