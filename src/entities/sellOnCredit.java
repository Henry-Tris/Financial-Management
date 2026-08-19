package entities;

import java.time.LocalDate;

import enumStatus.Status;

public class sellOnCredit extends Deal{

	private String clientName;
	private String productName;
	private double value;
	private LocalDate date;
	private Status status;
	
	public sellOnCredit() {
		
	}

	public sellOnCredit(String clientName, String productName, double value, LocalDate date, Status status) {
		this.clientName = clientName;
		this.productName = productName;
		this.value = value;
		this.date = date;
		this.status = status;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
