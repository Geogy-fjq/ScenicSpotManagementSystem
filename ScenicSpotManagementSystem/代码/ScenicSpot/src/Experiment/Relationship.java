package Experiment;

public class Relationship {
	ScenicSpot scenicSpot;
	int distance;
	int time;
	
	public Relationship() {
		scenicSpot=null;
		distance=0;
		time=0;
	}
	public Relationship(ScenicSpot scenicSpot) {
		this.scenicSpot=scenicSpot;
		distance=0;
		time=0;
	}
	public Relationship(ScenicSpot scenicSpot,int distance,int time) {
		this.scenicSpot=scenicSpot;
		this.distance=distance;
		this.time=time;
	}
	
	public ScenicSpot getScenicSpot() {
		return scenicSpot;
	}
	public int getDistance() {
		return distance;
	}
	public int getTime() {
		return time;
	}
	
	public void setScenicSpot(ScenicSpot scenicSpot) {
		this.scenicSpot=scenicSpot;
	}
	public void setDistance(int distance) {
		this.distance=distance;
	}
	public void setTime(int time) {
		this.time=time;
	}
}
