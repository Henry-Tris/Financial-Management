package entities;

import java.util.Objects;

import enumEntities.BudgetBucket;

public class Category {

	private String name;
	private BudgetBucket bucket;
	
	public Category() {
		
	}

	public Category(String name, BudgetBucket bucket) {
		this.name = name;
		this.bucket = bucket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BudgetBucket getBucket() {
		return bucket;
	}

	public void setBucket(BudgetBucket bucket) {
		this.bucket = bucket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(name, other.name);
	}
	
}
