package Experiment;

import java.util.Scanner;

public class B_ParkingLotSystem {
	Queue<Car> queue;//便道
	Stack<Car> stack;//假设停车场有3个停车位
	Stack<Car> stack1;//假设让路停车场地有2个停车位
	
	//初始化
	public B_ParkingLotSystem() {
		queue=new Queue<Car>();
		stack=new Stack<Car>(3);
		stack1=new Stack<Car>(2);
	}
	//车辆到达
    public String arrive(String number,String arrivalTime) {
    	String str=null;
		Car car=new Car(number,arrivalTime);
		if(stack.isEmpty() || stack.search(number)==-1) {//该车牌号未存入
			if(!stack.isFull()) {
				stack.push(car);
				int pos=stack.search(number)+1;
				str="车牌号为"+number+"的车辆"+"已经停入停车场,停车位置为:"+pos+"号。";
			}
			else {
				queue.push(car);
				int pos=queue.search(number)+1;
				str="车牌号为"+number+"的车辆"+"暂时停入便道,停车位置为:"+pos+"号。";
			}
		}
		else {//该车牌号已经存在
			str="输入错误!请重新输入!";
		}
		return str;
    }
    //车辆离开
    public String leave(String number,String leaveTime) {
    	String str=null;
		String[] leaveTime1=leaveTime.split(":");
		int lt1=Integer.parseInt(leaveTime1[0]);
		int lt2=Integer.parseInt(leaveTime1[1]);
		int pos=stack.search(number);
		if(pos!=-1) {//该车辆在停车场中
			//从栈中找到该车辆的信息，并获取到达时间
			Car c=stack.get(stack.search(number));
			String[] arrivalTime=c.getArrivalTime().split(":");
			int at1=Integer.parseInt(arrivalTime[0]);
			int at2=Integer.parseInt(arrivalTime[1]);
			//计算停留时间和费用
			int time=(lt1-at1)*60+(lt2-at2);
			int fee=(int) (time*0.12);
			//将后面的车依次暂时停放到让路停车场地中
			Car t;
			for(int i=1;i<pos;i++) {
				t=(Car) stack.pop();
				stack1.push(t);
			}
			//该车离开，输出信息
			stack.pop();
			str="车牌号为"+number+"的车辆"+"离开停车场。停留时间为"+time+"分钟,应交纳"+fee+"元。";
			//将让路停车场地中的车依次开回到停车场中
			for(int i=1;i<pos;i++) {
				t=(Car) stack1.pop();
				stack.push(t);
			}
			//该车离开后若有空位，将便道中的车开到停车场中
			if(!stack.isFull() && !queue.isEmpty()) {
				t=queue.pop().data;
				stack.push(t);
				t.setArrivalTime(leaveTime);
				String number1=t.getNumber();
				int pos3=stack.search(number1)+1;
				str=str+"+"+"车牌号为"+number1+"的车辆"+"已经停入停车场,停车位置为:"+pos3+"号。";
			}
		}
		else {
			str="该车辆不存在!请重新输入!";
		}
		return str;
    }
}
