package Experiment;

import java.util.NoSuchElementException;

public class Stack<Type> {
	private Type[] elements=null;
    private int maxSize=0;//栈容量
    private int top=-1;//栈顶指针
    
    //构造函数
    public Stack(){
        this(10);   
    }
    public Stack(int Size){
        if(Size>=0){
            this.maxSize=Size;
            elements=(Type[]) new Object[Size];
            top=-1;
        }
        else{
        	throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    //判断是否为空
    public boolean isEmpty(){
        return top==-1;
    }
    //判断是否为满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //进栈
    public boolean push(Type e){
        if(isFull()){
        	return false;
        }
        else {
        	top++;
	        elements[top]=e;
	        return true; 
        }
    }
    //查看栈顶元素
    public Type peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return elements[top];
        }
    }
    //弹出栈顶元素
    public Type pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return elements[top--];
        }
    }
    //返回指定元素的位置
    public int search(String e){
        int i=top;
        while(!isEmpty()){
            if(((Car) peek()).getNumber().equals(e)){
                break;
            }
            top--;
        }
        int result=top+1;
        top=i;
        return result-1;      
    }
    //返回指定索引的元素
    public Type get(int index){
    	if(index<0 && index>=elements.length) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	else {
    		return elements[index];
    	}
    }
}
