package patterns.observable;

import java.util.ArrayList;

public class Stock {
	
	private final String ticker; //stock name
	private ArrayList<StockListener> stockListeners = new ArrayList<>(); //stocks
	private double stockPrice; //old stockprice
	
	public Stock(String ticker, double stockPrice) {
		this.ticker = ticker;
		this.stockPrice = stockPrice;
	}
	
	public String getTicker() {
		return this.ticker;
	}
	
	public void setPrice(double newPrice) {
		if (newPrice <= 0) {
			throw new IllegalArgumentException("The price has to be a value above 0");
		}
		double oldPrice = this.stockPrice;
		this.stockPrice = newPrice;
		for (StockListener listener : stockListeners) {
			listener.stockPriceChanged(this, oldPrice, newPrice);
		}
	}
	
	public double getPrice() {
		return this.stockPrice;
	}
	
	public void addStockListener(StockListener stock) {
		if (!stockListeners.contains(stock)) { //add if the stock is not in the list
			stockListeners.add(stock); 
		}
	}

	public void removeStockListener(StockListener stock) {
		if (stockListeners.contains(stock)) {
			stockListeners.remove(stock); //removes if the stock is in the list
		}
	}
	//prints out the stock
	public String toString() {
		return "Stock [ticker=" + ticker + ", price=" + stockPrice
				+ ", length of stockListenerList " +  stockListeners.size() + "]";
	}
	

}
