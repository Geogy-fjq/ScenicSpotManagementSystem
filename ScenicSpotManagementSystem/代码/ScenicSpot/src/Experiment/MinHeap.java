package Experiment;

public class MinHeap<Type> {
	 private Type[] data;
	 int size;
	 
	 //构造函数
     public MinHeap(int size) {
    	 data=(Type[]) new Object[size];
    	 size=0;
     }
     //返回堆的大小
     public int getSize() {
    	 return size;
     }
     //判断是否为空
     public boolean isEmpty() {
    	 return size==0;
     }
     //返回指定元素的下标
     public int getPosition(Type node) {
    	 for(int i=0;i<size;i++) {
    		 if(((ScenicSpot) data[i]).getName().equals(((ScenicSpot) node).getName())) {
    			 return i;
    		 }
    	 }
    	 return -1;
     }
     //返回指定下标的元素
     public Type getValue(int index) {
		 if(index<0 || index>=getSize()) {
			 throw new ArrayIndexOutOfBoundsException();
		 }
    	 return data[index];
     }
     //插入元素
     public void insert(Type node) {
    	 ensureCapacity(getSize()*2+1);
    	 if(node!=null) {
    		 size++;
 			 data[size-1]=node;
 		 }
    	 heapUp(size-1);
     }
     //删除最小元素
     public Type deleteMin() {
    	 if(size>0) {
    		//把最后的一个叶子的数值赋值给index位置，并执行下降操作
    		 Type e=getValue(0);
			 data[0]=data[size-1]; 
			 heapDown(0); 
			 //缩减容量
			 size--;
			 trimToSize();
			 return e; 
    	 }
    	 return null;
     } 
     //删除指定元素
     public Type delete(Type node) {
    	 if(getPosition(node)!=-1) {
    		 //把最后的一个叶子的数值赋值给index位置，并执行下降操作
    		 Type e=getValue(getPosition(node));
			 data[getPosition(node)]=data[size-1]; 
			 heapDown(getPosition(data[size-1])); 
			 //缩减容量
			 size--;
			 trimToSize();
			 return e; 
    	 }
    	 return null;
     } 
     //让下标为index的元素上升到合适的位置
     public void heapUp(int index) {
        if(index>0) { 
            int p=index/2; 
            Type pValue=data[p]; 
            Type inValue=data[index]; 
            //如果父亲节点比index的数值大，就交换二者的数值 
            if(((ScenicSpot) pValue).getMinDistance()>=((ScenicSpot) inValue).getMinDistance()) { 
                swap(p,index);
                heapUp(p); 
            } 
        } 
    } 
     //让下标为index的元素下降到合适的位置
     public void heapDown(int index) {
         int minChild=0; 
         if(index*2+1>size-2) {//如果该节点没有左右儿子节点
             return; 
         }  
         else if(index*2+1<size-2) {//如果左右儿子都存在，取最小儿子
             if(((ScenicSpot) data[index*2+1]).getMinDistance()<=((ScenicSpot) data[index*2+2]).getMinDistance()) { 
            	 minChild=index*2+1; 
             } 
             else {
            	 minChild=index*2+2;
             }
         }
         else if(index*2+1==size-2) {//如果只有左儿子
        	 minChild=index*2+1; 
         } 
         if(((ScenicSpot) data[minChild]).getMinDistance()<((ScenicSpot) data[index]).getMinDistance()) {
             swap(minChild,index);
             heapDown(minChild); 
         } 
     }
     //获取左节点的数组下标
     public int left(int index) {
         return index*2+1;
     }
     //获取右节点的数组下标
     public int right(int index) {
         return index*2+2;
     }
     //交换数组下标为a和b的值
     public void swap(int a,int b) {
    	 Type tmp=data[a];
         data[a]=data[b];
         data[b]=tmp;
     }
     //重新设置根节点的值
     public void setRoot(Type value) {
         data[0]=value;
         heapUp(0);
     }
     //当堆长度不够用时，自动给堆增加长度
     public void ensureCapacity(int newSize) {
     	if(newSize<getSize()) {
     		return;
     	}
     	else {
     		Type[] old=data;
     		data=(Type[]) new Object[newSize];
         	for(int i=0;i<size;i++) {
         		data[i]=old[i];
     	    }
         	return;
     	}
     }
     //缩减容量至实际所需值
     public void trimToSize() {
     	ensureCapacity(size);
     }
     //先序遍历
     public void deepOrder(Type node) {
    	 if(this.getPosition(node)!=-1) {
    		 Stack<Type> s=new Stack<Type>();
    		 s.push(node);
    		 while(!s.isEmpty()) {
    			 Type now=s.pop();
    			 System.out.println(((ScenicSpot) now).getName()+":"+((ScenicSpot) now).getMinDistance());
    			 if(right(getPosition(now))<getSize()  && data[right(getPosition(now))]!=null) {
    				 Type childr=data[right(getPosition(now))];
    				 s.push(childr);
    			 }
    			 if(left(getPosition(now))<getSize()  && data[left(getPosition(now))]!=null) {
    				 Type childl=data[left(getPosition(now))];
    				 s.push(childl);
    			 }
    		}
    	}
    }
}
