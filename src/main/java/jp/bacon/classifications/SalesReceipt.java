package jp.bacon.classifications;

import java.util.Calendar;

public class SalesReceipt {
	private final Calendar itsSaleDate;
	private final double itsAmount;

	public SalesReceipt(Calendar saleDate, double amount) {
		itsSaleDate = saleDate;
		itsAmount = amount;
	}

	public Calendar GetSaleDate() {
		return itsSaleDate;
	}

	public double GetAmount() {
		return itsAmount;
	}
}
