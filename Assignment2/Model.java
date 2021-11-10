package sse4350;

public class Model {
	private int ID;
	private String Name;
	private double Math;
	private double Science;
	
	public int getID(){
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public double Math(){
		return Math;
	}
	public void setMath(double Math) {
		this.Math = Math;
	}
	public double Science() {
		return Science;
	}
	public void setScience(double Science) {
		this.Science = Science;
	}
}
