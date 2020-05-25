package Experiment;

public class ScenicSpot {
	String name;//名字
	String introduction;//简介
	int welcomeDegree;//欢迎度
	String restArea;//是否有休息区
	String toilet;//是否有厕所
	
	int minDistance;//最小距离
	int minTime;//最少时间
	ScenicSpot fromScenicSpot;//出发地景点
	LinkedList<Relationship> relationship;//链表
	
	public ScenicSpot() {
		name=null;
		introduction=null;
		welcomeDegree=0;
		restArea=null;
		toilet=null;
		minDistance=0;
		minTime=0;
		fromScenicSpot=null;
		relationship=null;
	}
	public ScenicSpot(String name,LinkedList<Relationship> list) {
		this.name=name;
		introduction=null;
		welcomeDegree=0;
		restArea=null;
		toilet=null;
		minDistance=0;
		minTime=0;
		fromScenicSpot=null;
		relationship=list;
	}
	public ScenicSpot(String name,String introduction,int welcomeDegree,String restArea,String toilet,int minDistance,int minTime,ScenicSpot fromScenicSpot,LinkedList<Relationship> relationship) {
		this.name=name;
		this.introduction=introduction;
		this.welcomeDegree=welcomeDegree;
		this.restArea=restArea;
		this.toilet=toilet;
		this.minDistance=minDistance;
		this.minTime=minTime;
		this.fromScenicSpot=fromScenicSpot;
		this.relationship=relationship;
	}
	
	public String getName() {
		return name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public int getWelcomeDegree() {
		return welcomeDegree;
	}
	public String getRestArea() {
		return restArea;
	}
	public String getToilet() {
		return toilet;
	}
	public int getMinDistance() {
		return minDistance;
	}
	public int getMinTime() {
		return minTime;
	}
	public ScenicSpot getFromScenicSpot() {
		return fromScenicSpot;
	}
	public LinkedList<Relationship> getRelationship() {
		return relationship;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setIntroduction(String introduction) {
		this.introduction=introduction;
	}
	public void setWelcomeDegree(int welcomeDegree) {
		this.welcomeDegree=welcomeDegree;
	}
	public void setMinDistance(int minDistance) {
		this.minDistance=minDistance;
	}
	public void setMinTime(int minTime) {
		this.minTime=minTime;
	}
	public void setRestArea(String restArea) {
		this.restArea=restArea;
	}
	public void setToilet(String toilet) {
		this.toilet=toilet;
	}
	public void setFromScenicSpot(ScenicSpot fromScenicSpot) {
		this.fromScenicSpot=fromScenicSpot;
	}
	public void setRelationship(LinkedList<Relationship> relationship) {
		this.relationship=relationship;
	}
}
