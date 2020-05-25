package Experiment;

import java.util.NoSuchElementException;

public class LinkedList<Type> {
	//单向链表的内部结点类
    class Node<Type>{
    	Type data;
    	Node<Type> next;
    	
    	public Node(){
    		data=null;
    		next=null;
    	}
    	public Node(Type data,Node<Type> next){
    		this.data=data;
    		this.next=next;
    	}	
    }
    //定义链表的属性：大小、头结点、当前结点
    private int size;
    private Node<Type> first;
    private Node<Type> current;
    
    //初始化链表
    public LinkedList() {
    	size=0;
    	first=new Node<Type>();
    	current=first;
    }
    //判断链表是否为空
    public boolean isEmpty() {
    	return size==0;
    }
    //返回链表的元素个数
    public int size() {
    	return size;
    }
    //查找指定元素的索引
    public int getPosition(String data) {
    	int f=-1;
    	Node<Type> p=first.next;
    	int i=0;
    	while(p!=null && i<size) {
    		if(((Relationship) p.data).getScenicSpot().getName().equals(data)) {
    			f=i;
    			break;
    		}
    		else {
    			p=p.next;
    			i++;
    		}
    	}
    	return f;
    }
    //查找指定索引的节点
    public Node<Type> getNode(int index) {
    	if(index<0||index>size){
    		throw new NoSuchElementException();
    	}
    	else {
    		Node<Type> p=first;
    		int i=0;
    		while(p!=null && i<index-1) {
    			p=p.next;
    			i++;
    		}
    		return p;
    	}
    }  
    //按顺序添加元素元素
    public Type add(Type data) {
    	Node<Type> current=new Node<Type>(data,first.next);
    	first.next=current;
    	current=current.next;
    	size++;
    	return data;
    }
    //在指定位置插入元素
    public Type insert(Type data,int index) {
    	if(index<0||index>size){
    		throw new NoSuchElementException();
    	}
    	else {
    		if(index==0) {//在头结点处插入元素
    			Node<Type> current=new Node<Type>(data,first);
    	    	first=current;
    	    	size++;
        	}
        	else {
        		Node<Type> current=new Node<Type>(data,this.getNode(index).next);
        		this.getNode(index).next=current;
        		size++;
        	}
    		return data;
    	}
    }
    //修改指定索引的元素
    public boolean set(int index,Type data) {
    	if(index<0||index>size){
    		throw new NoSuchElementException();
    	}
    	else {
    		current=this.getNode(index);
    		this.remove(index);
    		this.insert(data,index);
    		return true;
    	}
    }
    //删除指定索引的元素
    public Type remove(int index) {
    	if(index<0||index>size){
    		throw new NoSuchElementException();
    	}
    	else {
    		Node<Type> p=first;
    		int i=0;
    		while(p!=null && i<index-1) {
    			p=p.next;
    			i++;
    		}
    		Node<Type> current;
    		if(index==0) {
    	    	current=first;
    	    	p=first=first.next;
    	    	size--;
        	}
        	else {
        		current=p.next;
        		p.next=current.next;
        		size--;
        	}
    		return current.data;
    	}
    }
    //删除指定元素
    public Type delete(String data) {
    	int index=this.getPosition(data);
    	return this.remove(index);
    	
    }
    //移动当前结点至第一个有效结点
    public boolean first() {
    	if(!isEmpty()) {
    		current=first;
    		return true;
    	}
    	else {
    		current=null;
    		return false;
    	}
    }
    //遍历链表中的元素，返回顺序表
    public SequenceList<String> ergodic() {
    	current=first;
    	SequenceList<String> arr=new SequenceList<String>();
    	while(current.next!=null) {
    		arr.add(((Relationship) current.next.data).getScenicSpot().getName());
    		current=current.next;
    	}
		return arr;
    }
    //打印链表
    public void print() {
    	current=first;
    	while(current.next!=null) {
    		System.out.println(((Relationship) current.next.data).getScenicSpot().getName()+","+((Relationship) current.next.data).getDistance());
    		current=current.next;
    	}
    }
    
}
