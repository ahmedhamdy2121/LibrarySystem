package application.objectModel;

import java.util.List;

public class CheckOutRecord {

	private double totalFine;
	
	public double getTotalFine() {
		return totalFine;
	}

	public void setTotalFine(double totalFine) {
		this.totalFine = totalFine;
	}

	public List<CheckOutEntry> getCheckOutEntries() {
		return checkOutEntries;
	}

	public void setCheckOutEntries(List<CheckOutEntry> checkOutEntries) {
		this.checkOutEntries = checkOutEntries;
	}

	private List<CheckOutEntry> checkOutEntries;
	
}
