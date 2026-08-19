package entities;

import java.time.LocalDate;

import enumEntities.Status;

public class Deal {

	private double value;
	private LocalDate date;
	private Status type;
	
	public Deal() {
		
	}

	public Deal(double value, LocalDate date, Status type) {
		this.value = value;
		this.date = date;
		this.type = type;
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

	public Status getType() {
		return type;
	}

	public void setType(Status type) {
		this.type = type;
	}
}
