///////////////////////////////////////////////////////////////////////////////////
////////////////DemoStockMarket//////////////////////////////////////////////////

package com.jpm.stockmarket.demo;

enum ProductType {
	Common, Preferred
};

// Contains Stock information
public class Stock {
	private String stockName;
	private ProductType stockType;
	private double lastDividend;
	private Double fixedDividend;
	private int parValue;

	public Stock(String stockName, ProductType stockType, double lastDividend, Double fixedDividend, int parValue) {
		this.stockName = stockName;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	@Override
	public String toString() {
		return "StockName : " + stockName + " StockType : " + stockType;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public ProductType getStockType() {
		return stockType;
	}

	public void setStockType(ProductType stockType) {
		this.stockType = stockType;
	}

	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDivident(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public int getParValue() {
		return parValue;
	}

	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

	// Calculates Dividend Yield
	public double getDividentYield(double price) {
		if (stockType == ProductType.Common) {
			return lastDividend / price;
		}

		if (fixedDividend == null) {
			return 0;
		}

		return (fixedDividend * parValue) / (100 * price);
	}

	// Calculates PEratio
	public double getPERatio(double price) {
		if (lastDividend == 0) {
			return 0;
		}

		return price / lastDividend;
	}

}
