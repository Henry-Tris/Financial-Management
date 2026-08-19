package entities;

import java.time.LocalDate;

import enumEntities.ExpenseContext;
import enumEntities.TypeStatus;

public class Deal {

	private double value;
	private LocalDate date;
	private TypeStatus type;
	private String name;
	private Category category;
	private ExpenseContext context;
	
	public Deal() {
		
	}
	
	public Deal(double value, LocalDate date, TypeStatus type, String name, Category category, ExpenseContext context) {
		this.value = value;
		this.date = date;
		this.type = type;
		this.name = name;
		this.category = category;
		this.context = context;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ExpenseContext getContext() {
		return context;
	}

	public void setContext(ExpenseContext context) {
		this.context = context;
	}
}
