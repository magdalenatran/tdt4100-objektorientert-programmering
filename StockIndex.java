package patterns.observable;

import java.util.ArrayList;

public class StockIndex implements StockListener{
	private final String name; 
	private ArrayList<Stock> stocks = new ArrayList<Stock>(); 
	private double index = 0;

	public StockIndex(String name, Stock... stock) { //tar inn 
		this.name = name;
		if (stock == null) {
			this.index = 0;
		}
		for (Stock currentStock: stock) {
			stocks.add(currentStock);
			currentStock.addStockListener(this);
			this.index += currentStock.getPrice();
		}
	}
	//adds a stock
	public void addStock(Stock stock) {
		if (!stocks.contains(stock)) {
			stocks.add(stock);
			this.index += stock.getPrice();
		}
	}
	
	//removes stock
	public void removeStock(Stock stock) {
		if (stocks.contains(stock)) {
			stocks.remove(stock);
			this.index -= stock.getPrice();
		}
	}
	//gets index
	public double getIndex() {
		return this.index;
	}
	
	//registrates the changes in the stock
	@Override
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
		// TODO Auto-generated method stub
		if (oldPrice != newPrice && stocks.contains(stock)) {
			this.index += newPrice - oldPrice;
		}

		
	}
	
	public String toString() {
		return "StockIndex [name=" + name + ", index=" + index
				+ ", stocks=" + stocks + "]";
	}

}
