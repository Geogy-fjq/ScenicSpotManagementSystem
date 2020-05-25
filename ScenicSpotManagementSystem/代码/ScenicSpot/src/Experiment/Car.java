package Experiment;

public class Car {
	String number;//汽车车牌号
    String arrivalTime;//汽车到达时间
    
    public Car() {
    	number=null;
    	arrivalTime=null;
    }
    public Car(String number,String arrivalTime) {
    	this.number=number;
    	this.arrivalTime=arrivalTime;
    }
    
    public String getNumber() {
    	return number;
    }
    public String getArrivalTime() {
    	return arrivalTime;
    }
    public void setNumber(String number) {
    	this.number=number;
    }
    public void setArrivalTime(String arrivalTime) {
    	this.arrivalTime=arrivalTime;
    }

}
