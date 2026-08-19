package entities;

import java.time.LocalDate;

import enumEntities.TypeStatus;

public class Deal {

	private double value;
	private LocalDate date;
	private TypeStatus type;
	
	public Deal() {
		
	}

	public Deal(double value, LocalDate date, TypeStatus type) {
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

	public TypeStatus getType() {
		return type;
	}

	public void setType(TypeStatus type) {
		this.type = type;
	}
}
