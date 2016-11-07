///////////////////////////////////////////////////////////////////////////////////
////////////////DemoStockMarket//////////////////////////////////////////////////

package com.jpm.stockmarket.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum TradeType {
	Buy, Sell
}

// Contains Trade information
public class Trade {
	private String stockName;
	private int quantity;
	private double price;
	TradeType tradeType;
	Date timeStamp;
	Logger logger = LoggerFactory.getLogger(Trade.class);

	public Trade(String stockName, int quantity, double price, TradeType tradeType, Date timeStamp) {
		this.stockName = stockName;
		this.quantity = quantity;
		this.price = price;
		this.tradeType = tradeType;
		this.timeStamp = timeStamp;
	}

	// Overrides to display in a proper way
	@Override
	public String toString() {
		return "StockName : " + stockName + " Quantity : " + quantity +  " Price : " + price + " TradeType :  " + tradeType + " TimeStamp : " + timeStamp;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
