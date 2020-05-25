package Experiment;

public class Queue<Type> {
	//链式队列的节点
    class Node<Type> {
    	Type data;
        Node<Type> next;//下一个节点
        public Node() {
        	data=null;
        	next=null;
        }
        public Node(Type data,Node<Type> next) {
            this.data=data;
            this.next=next;
        }
    }
	private Node<Type> front;//队头
	private Node<Type> rear;//队尾
	private int size;
	
	//初始化队列
    public Queue() {
    	front=new Node<Type>();
    	rear=new Node<Type>();
    	size=0;
    }
    //判断队列是否为空
    public boolean isEmpty() {
    	return size==0;
    }
    //返回队列元素个数
    public int getSize() {
    	return size;
    }
    //在队尾插入元素
    public boolean push(Type e) {
    	if(isEmpty()) {
    		rear=front=new Node<Type>(e,null);//实例化一个节点，front、rear都指向该节点
    	}
    	else {
    		Node<Type> newNode=new Node<Type>(e,null);
            rear.next=newNode;//加入队尾
            rear=newNode;//更改队尾位置 
    	}
    	size++;
    	return true;
    }
    //删除队首元素
    public Node<Type> pop() {
    	if(isEmpty()) {
    		throw new IndexOutOfBoundsException();
    	}
    	else {
    		Node<Type> value = front;//取出队首元素
            front=(Queue<Type>.Node<Type>) front.next;//更改队首位置
            value.next=null;
            size--;
            return value;
    	}
    }
    //返回队首元素
    public Node<Type> peek(){
    	if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
    	else{
            return front;
        }
    }
    //返回元素在堆栈中的位置
    public int search(String e){
    	Node<Type> i=front;
    	int n=0;
    	while(i!=null) {
    		n++;
    		if(((Car) i.data).getNumber().equals(e)) {
    			return n-1;
    		}
    		i=(Queue<Type>.Node<Type>) i.next;
    	}
        return -1;      
    }
}
