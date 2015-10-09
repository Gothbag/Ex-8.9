/*
 * created by Gothbag <josemariacagigalso@gmail.com
 * this represents a car
 * 
 */

public class Car {
	
	private String make;
	private String model;
	private int engineDisplacement;
	private int nCylinders;
	private double fiscalHorsepower;
	
	public Car() {
		super();
	}

	public Car(String make, String model, int engineDisplacement,
		int nCylinders) {
		super();
		this.make = make;
		this.model = model;
		this.engineDisplacement = engineDisplacement;
		this.nCylinders = nCylinders;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getEngineDisplacement() {
		return engineDisplacement;
	}
	public void setEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}
	public int getNCylinders() {
		return nCylinders;
	}
	public void setNCylinders(int nCylinders) {
		this.nCylinders = nCylinders;
	}
	public double getFiscalHorsepower() {
		return fiscalHorsepower;
	}
	public void setFiscalHorsepower(double fiscalHorsepower) {
		this.fiscalHorsepower = calcFiscalHorsepower();
		if (this.fiscalHorsepower == 0) {
			this.fiscalHorsepower = fiscalHorsepower;
		}
	}
	
	public double calcFiscalHorsepower() {
		return 0.08 * this.nCylinders * Math.pow(this.engineDisplacement / this.nCylinders, 0.6);
	}
	
	public String toString(){
		return this.getMake() + " " + this.getModel() + " " + this.getEngineDisplacement() + " " + this.getNCylinders() + " " + this.getFiscalHorsepower();		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + engineDisplacement;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + nCylinders;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (engineDisplacement != other.engineDisplacement)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (nCylinders != other.nCylinders)
			return false;
		return true;
	}

}