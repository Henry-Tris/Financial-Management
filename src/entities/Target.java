package entities;

public class Target {

	private String goal;
	private double targetValue;
	private double currentValue;
	
	public Target() {
		
	}

	public Target(String goal, double targetValue, double currentValue) {
		this.goal = goal;
		this.targetValue = targetValue;
		this.currentValue = currentValue;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public double getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(double targetValue) {
		this.targetValue = targetValue;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	
}
