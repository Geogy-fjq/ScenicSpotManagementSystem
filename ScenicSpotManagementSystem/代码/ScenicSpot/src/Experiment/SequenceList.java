package Experiment;

public class SequenceList<Type> {
    private Type[] elements;
    private int size;
    private static final int DefaultCapacity=20;     
    
    //创建默认容量为20的空表
    public SequenceList() {
		this(DefaultCapacity);
    }
    //构造容量为length的空表
    public SequenceList(int length) {
    	elements=(Type[]) new Object[length];
    	size=0;
    } 
    
    //返回顺序表的大小
    public int getSize() {
    	return size;
    }
    //指定位置插入元素
    public void insert(int index,Type v) {
    	if(index<0||index>=size) {
    		ensureCapacity(size*2+1);//容量不足自动增加容量
    	}
    	for(int i=size;i>index;i--) {
    		elements[i]=elements[i-1];
    	}
    	elements[index]=(Type) v;
    	size++;
    }
    //末尾追加元素
    public boolean add(Type v) {
    	insert(size,v);
    	return true;
    } 
    //删除指定位置的元素
    public boolean delete(int index) {
     	if(index<0||index>=size) {
   		    throw new ArrayIndexOutOfBoundsException();
     	}
   		for(int i=index;i<size-1;i++) {
   			elements[i]=elements[i+1];
   		}
   		size--;
   		trimToSize();//将容量缩减为实际所需值
   		return true;
    }
    //查找指定元素的索引
    public int find(String n) {
    	if(n!=null) {
    		for(int i=0;i<size;i++) {
    			if(n.equals(elements[i])) {
    				return i;
    			}
    		}
    	}
    	else {
    		for(int i=0;i<size;i++) {
    			if(elements[i]==null) {
    				return i;
    			}
    		}
    	}
    	return -1;
    }
    //根据下标返回元素值
    public Type get(int index) {
    	if(index<0||index>=size) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	return elements[index];
    }
    //修改指定下标的元素
    public Type set(int index,Type newElement) {
    	if(index<0||index>=size) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	Type oldElement=elements[index];
    	elements[index]=newElement;
    	return oldElement;
    }
    
    //返回顺序表的元素个数
    public int size(){
    	return size;
    }
    //清空顺序表
    public void clear(){
    	size=0;
    }
    //判断顺序表是否为空，为空则返回true
    public boolean isEmpty() {
    	return size==0;
    }
    //当顺序表长度不够用时，自动给顺序表增加长度
    public void ensureCapacity(int newSize) {
    	if(newSize<size) {
    		return;
    	}
    	else {
    		Type oldElements[]=elements;
        	elements=(Type[]) new Object[newSize];
        	for(int i=0;i<size;i++) {
        		elements[i]=oldElements[i];
    	    }
        	return;
    	}
    }
    //缩减容量至实际所需值
    public void trimToSize() {
    	ensureCapacity(size);
    }
    //打印顺序表
    public void print() {
    	for(int i=0;i<size;i++) {
    		System.out.println(elements[i]);
    	}
    }
	
}
