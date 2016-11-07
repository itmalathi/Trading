///////////////////////////////////////////////////////////////////////////////////
////////////////DemoStockMarket//////////////////////////////////////////////////

package com.jpm.stockmarket.demo;

import java.util.*;
import java.util.stream.Collectors;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Creates, manipulates and manages trade repository information 
public class TradeRepository {
	
	private static TradeRepository instance;
	List<Trade> trades = new ArrayList<Trade>();
	Logger logger = LoggerFactory.getLogger(TradeRepository.class);

	private TradeRepository() {

	}
	
	// Singleton class
	public static TradeRepository getInstance() {
		if (instance == null) {
			instance = new TradeRepository();
		}
		return instance;
	}

	// TEA, POP, ALE, GIN, JOE
	public void populateDemoData()
	{
		Date currentTime = new Date();
		addTrade(new Trade("TEA",10, 5, TradeType.Buy, currentTime));
		addTrade(new Trade("TEA",2, 5, TradeType.Sell, DateUtils.addMinutes(currentTime, 1)));
		addTrade(new Trade("TEA",1, 5, TradeType.Buy, DateUtils.addMinutes(currentTime, -6)));
		addTrade(new Trade("TEA",1, 5, TradeType.Buy, DateUtils.addMinutes(currentTime, -7)));
		
		addTrade(new Trade("POP",1, 5, TradeType.Buy, DateUtils.addSeconds(currentTime, -35)));
	}

	// Adds trade in the repository
	private void addTrade(Trade newTrade) {
		trades.add(newTrade);
		logger.debug("Trade " + newTrade.toString() + " is added");
	}

	private List<String> getTradedStocks() {
		return trades.stream().map(t -> t.getStockName()).distinct().collect(Collectors.toList());
	}

	// Calculates VolumeWeightStockPrice for the given stock
	public double getVolumeWeightStockPrice(String stock, Date startTime) {
		int totalCount = 0;
		double totalTransaction = 0;

		// filter only the required stocks and find the volume weight stock
		// price
		List<Trade> stockTrades = trades.stream()
				.filter(e -> e.getStockName().equalsIgnoreCase(stock) && startTime.compareTo(e.getTimeStamp()) < 0)
				.collect(Collectors.toList());

		if (stockTrades.size() == 0)
			return 0;

		logger.debug("\t\t\tLIST OF SELECTED TRADES");
		for (Trade item : stockTrades) {
			totalTransaction += item.getPrice() * item.getQuantity();
			totalCount += item.getQuantity();
			logger.debug(item.toString());
		}

		return totalTransaction / totalCount;
	}

	// Calculates All Share Index
	public double getAllShareIndex() {
		List<String> tradedStocks = getTradedStocks();

		if (tradedStocks == null) {
			return 0;
		}

		if (tradedStocks.size() == 0) {
			return 0;
		}

		double transactionSum = 0;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1970);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);

		Date dayStartTime = cal.getTime();

		for (String stock : tradedStocks) {
			if (transactionSum == 0) {
				transactionSum = getVolumeWeightStockPrice(stock, dayStartTime);
			} else {
				transactionSum *= getVolumeWeightStockPrice(stock, dayStartTime);
			}
		}

		return Math.pow(transactionSum, tradedStocks.size());
	}
}
