package entities;

import java.time.LocalDate;

import enumEntities.PaymentStatus;

public class Bills {

	private String name;
	private double value;
	private LocalDate date;
	private PaymentStatus status;
	
	public Bills() {
		
	}

	public Bills(String name, double value, LocalDate date, PaymentStatus status) {
		this.name = name;
		this.value = value;
		this.date = date;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
}
