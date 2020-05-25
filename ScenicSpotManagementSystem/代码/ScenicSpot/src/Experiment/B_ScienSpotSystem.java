package Experiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class B_ScienSpotSystem {
	private AdjacencyList adjList=new AdjacencyList();//邻接表
	String notice;//公告
	
	public B_ScienSpotSystem(String file1,String file2) {
		adjList=loadWork(file1,file2);
		notice="暂无公告";
	}
	
	/*
     * 共享模块
     */
	//用户界面获得通知
	public String getNotice() {
		return notice;
	}
	//管理员界面发布通知
	public void setNotice(String notice) {
		this.notice=notice;
	}
	//读取文件信息
	public AdjacencyList loadWork(String file1,String file2){
		LinkedList<Relationship> linkList;//链表
		//读取节点的信息
		try {
			FileReader fr1=new FileReader(file1);
			BufferedReader bf1=new BufferedReader(fr1);
			String str;
			int min=10000000;
			//按行读取字符串
			while ((str=bf1.readLine())!=null) {
				String arr[]=str.split("\\+");//划分字符串
				String name=arr[0];
				String introduction=arr[1];
				int welcomeDegree=Integer.parseInt(arr[2]);
				String restArea=arr[3];
				String toilet=arr[4];
				linkList=new LinkedList<Relationship>();
				ScenicSpot scenicSpot=new ScenicSpot(name,introduction,welcomeDegree,restArea,toilet,min,min,null,linkList);//顶点
				adjList.addVertex(scenicSpot);
				min++;
			}
			bf1.close();
			fr1.close();
		} 
		catch (IOException exc) {
			exc.printStackTrace();
		}
		//读取边的信息
		try {
			FileReader fr2=new FileReader(file2);
			BufferedReader bf2=new BufferedReader(fr2);
			String str;
			//按行读取字符串
			while ((str=bf2.readLine())!=null) {
				String arr[]=str.split(",");//划分字符串
				//正向关系
				String name=arr[0];
				String toName=arr[1];
				ScenicSpot toScenicSpot=adjList.getValue(adjList.getPosition(toName));
				Relationship relationship=new Relationship(toScenicSpot,Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));//景点(边)
				adjList.addEdge(name,relationship);
				//反向关系
				ScenicSpot toScenicSpot1=adjList.getValue(adjList.getPosition(name));
				Relationship relationship1=new Relationship(toScenicSpot1,Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));//景点(边)
				adjList.addEdge(toName,relationship1);
			}
			bf2.close();
			fr2.close();
		} 
		catch (IOException exc) {
			exc.printStackTrace();
		}
		return adjList;
	}
	
	/*
     * 用户模块
     */
	//邻接表转换成邻接矩阵
	public AdjacencyMatrix listToMatrix(){
		int size=adjList.getSize();
		AdjacencyMatrix matrix=new AdjacencyMatrix(size);
		SequenceList<String> sqlList=new SequenceList<String>();
		//顶点的顺序表的增添
		for(int i=0;i<size;i++) {
			sqlList.add(adjList.getValue(i).getName());
			matrix.setSqlList(sqlList);
		}
		//边的权值的增添
		for(int i=0;i<size;i++) {//遍历邻接表中的每个顶点
			LinkedList<Relationship> list=adjList.getValue(i).getRelationship();
			SequenceList<String> arr=list.ergodic();
			for(int j=0;j<arr.size();j++) {
				matrix.setWeight(i,adjList.getPosition(arr.get(j)),list.getNode(j+1).next.data.getDistance());
			}
		}
		return matrix; 
	}
	
	//输出邻接矩阵
	public void outMatrix(AdjacencyMatrix matrix){
		System.out.print("\t");
		for(int i=0;i<matrix.numOfVertices();i++) {
			System.out.print(matrix.getSqlList().get(i)+"\t");
		}
		System.out.print("\r\n");
		for(int i=0;i<matrix.numOfVertices();i++) {
			System.out.print(matrix.getSqlList().get(i)+"\t");
			for(int j=0;j<matrix.numOfVertices();j++) {
				System.out.print(matrix.getWeight(i,j)+"\t");
			}
			System.out.print("\r\n");
		}
	}
	
	//查找景点:精确查找和模糊查找两种
    public String serach(String key) {
    	String str="";
    	for(int i=0;i<adjList.getSize();i++) {
    		if(adjList.getValue(i).getName().contains(key)) {
    			str=str+""+adjList.getValue(i).getName()+":"+adjList.getValue(i).getIntroduction();
    	    }
    	}
    	return str;
    }
    
    //快速排序(递归)：景点欢迎度、岔路数等
    private String quickSort(String[] a,int[] b,int low,int high) {
		if(low<=high) {
			//进行快速排序
			int i=low;
			int j=high;
			int index=b[i];//用数组的第一个数作为基准值
			String value=a[i];
			while(i<j) {//进行扫描
				while(i<j && b[j]<index) {
					j--;
				}
				if(i<j) {//比基准值小的记录替换到左侧
					b[i]=b[j];
					a[i]=a[j];
					i++;
				}
				while(i<j && b[i]>=index) {
					i++;
				}
				if(i<j) {//比基准值大的记录替换到右侧
					b[j]=b[i];
					a[j]=a[i];
					j--;
				}
			}
			b[i]=index;//将基准值替换回list[i]
			a[i]=value;
			quickSort(a,b,low,i-1);
			quickSort(a,b,i+1,high);
			//转换成固定格式的输出字符串
	    	String out=new String();
	    	for(int k=1;k<=a.length;k++) {
	    		out=out+k+"."+a[k-1]+" ";
	    	}
			return out;
		}
		return null;
    }
    public String quickSort(String key) {
    	//获取邻接表中的的景点名和景点欢迎度
    	String[] Name=new String[adjList.getSize()];
    	int[] Key=new int[adjList.getSize()];
    	if(key.equals("景点欢迎度")) {
    		for(int i=0;i<adjList.getSize();i++) {
    			Name[i]=adjList.getValue(i).getName();
    			Key[i]=adjList.getValue(i).getWelcomeDegree();
    		}
    	}
    	else if(key.equals("岔路数")){
    		for(int i=0;i<adjList.getSize();i++) {
    			Name[i]=adjList.getValue(i).getName();
    			Key[i]=adjList.getValue(i).getRelationship().size();
    		}
    	}
    	return quickSort(Name,Key,0,Key.length-1);
    }
    
    //两端插入排序：有无休息区、有无厕所等
    public String insertSort(String key) {
    	//获取邻接表中的的景点名和有无休息区、有无厕所
    	String[] Name=new String[adjList.getSize()];
    	String[] Key=new String[adjList.getSize()];
    	if(key.equals("有无休息区")) {
    		for(int i=0;i<adjList.getSize();i++) {
    			Name[i]=adjList.getValue(i).getName();
    			Key[i]=adjList.getValue(i).getRestArea();
    		}
    	}
    	else if(key.equals("有无厕所")){
    		for(int i=0;i<adjList.getSize();i++) {
    			Name[i]=adjList.getValue(i).getName();
    			Key[i]=adjList.getValue(i).getToilet();
    		}
    	}
    	//进行插入排序
    	String[] b=new String[Key.length];
    	int j=0,k=0;
    	for(int i=0;i<Key.length;i++) {
			if(Key[i].equals("是")) {
				b[j]=Name[i];
				j++;
			}
			else {
				b[Key.length-k-1]=Name[i];
				k++;
			}
		}
    	//转换成固定格式的输出字符串
    	String out=new String();
    	for(int i=1;i<=b.length;i++) {
    		out=out+i+"."+b[i-1]+" ";
    	}
    	return out;
    }
    
    //用AVL树求最短距离：Dijkstra最短路径算法
  	public AdjacencyList shortestPath1(String c) {
  		//初始化
  		adjList.getValue(adjList.getPosition(c)).setMinDistance(0);//源点到其自身的距离为0
  		adjList.getValue(adjList.getPosition(c)).setMinTime(0);//源点到其自身的时间为0
  		AVLTree<ScenicSpot> tree=new AVLTree<ScenicSpot>();
  		//全部顶点插入AVL树
	    for(String v:adjList.values()) {
	        tree.insert(adjList.getValue(adjList.getPosition(v)));
	    }
	    //计算各顶点的最少路程、时间
	    while(!(tree.isEmpty())){
	    	ScenicSpot v=tree.delete(tree.minNode().data);//删除费距离最小的顶点
	        if(v!=null) {
	        	LinkedList<Relationship> ser=v.getRelationship();//获取v的所有邻接边(点)
	        	for(int i=0;i<ser.size();i++) {//更新
	        		Relationship s=ser.getNode(i).next.data;
	            	ScenicSpot spot=adjList.getValue(adjList.getPosition(s.getScenicSpot().getName()));
	          		if(spot.getMinDistance()>(s.getDistance()+v.getMinDistance())){
	          			ScenicSpot name=adjList.getValue(adjList.getPosition(spot.getName()));
		            	tree.delete(name);
		            	name.setMinDistance(s.getDistance()+v.getMinDistance());//更新距离
		            	name.setMinTime(s.getTime()+v.getMinTime());//更新时间
		            	name.setFromScenicSpot(v);//更新顶点
		            	tree.insert(name);
	          		}
	            }
	        }
	      	else {
	      		break;
	      	}
	    }
	    return adjList;
  	}
  	
    //用最小堆求最短路径：Dijkstra最短路径算法
  	public AdjacencyList shortestPath2(String c){
  		MinHeap<ScenicSpot> tree=new MinHeap<ScenicSpot>(adjList.getSize());
  		adjList.getValue(adjList.getPosition(c)).setMinDistance(0);//源点到其自身的距离为0
  		adjList.getValue(adjList.getPosition(c)).setMinTime(0);//源点到其自身的时间为0
  		//将各个顶点插入最小堆
	    for(String v:adjList.values()) {
	        tree.insert(adjList.getValue(adjList.getPosition(v)));
	    }
	    //计算各顶点的最少路程、时间
	    while(!(tree.isEmpty())){
	    	ScenicSpot v=tree.deleteMin();//删除费距离最小的顶点
	        if(v!=null) {
	        	LinkedList<Relationship> ser=v.getRelationship();//获取v的所有邻接边(点)
	        	for(int i=0;i<=ser.size();i++) {//更新
	        		Relationship s=ser.getNode(i).next.data;
	            	ScenicSpot spot=adjList.getValue(adjList.getPosition(s.getScenicSpot().getName()));
	          		if(spot.getMinDistance()>(s.getDistance()+v.getMinDistance())){
	          			ScenicSpot name=adjList.getValue(adjList.getPosition(spot.getName()));
		            	tree.delete(name);
		            	name.setMinDistance(s.getDistance()+v.getMinDistance());//更新距离
		            	name.setMinTime(s.getTime()+v.getMinTime());//更新时间
		            	name.setFromScenicSpot(v);//更新顶点
		            	tree.insert(name);
	          		}
	            }
	        }
	      	else {
	      		break;
	      	}
	    }
	    return adjList;
  	}
  	
    //求最短路径
  	public String OutPutShortestPath(String c,String fc) {
  		//获取路径、路程、时间
  		adjList=shortestPath2(c);//最短路径计算后得到的邻接表
  		int distance=adjList.getValue(adjList.getPosition(fc)).getMinDistance();//路程
  		int time=adjList.getValue(adjList.getPosition(fc)).getMinTime();//时间
  		//路径
  		ScenicSpot fcS=adjList.getValue(adjList.getPosition(fc));
  		String all=null,path=null;
  		if(fcS.getFromScenicSpot()!=null) {
  			path=fc;
  			fcS=fcS.getFromScenicSpot();
  			while(fcS.getFromScenicSpot()!=null) {
  				path=fcS.getName()+"——"+path;
  				fcS=fcS.getFromScenicSpot();
  			}
  		} 
  		path=c+"——"+path;
  		all=path+","+Integer.toString(distance)+","+Integer.toString(time);
  		return all;
  	}
  	
    //求最短哈密尔顿回路（导游线路图）:最小生成树Prim算法
    public AdjacencyMatrix toPrim(AdjacencyMatrix c,String name) {
    	int n=c.numOfVertices();//顶点的个数
    	int pos=c.getVertexPos(name);//name在邻接矩阵中的位置
    	int[] lowDis=new int[n];//各个顶点离最小生成树的最短权值
    	String[] closest=new String[n];//离最小生成树最近的节点
    	AdjacencyMatrix m=new AdjacencyMatrix(n);
    	AdjacencyMatrix.Edge e;
    	SequenceList<AdjacencyMatrix.Edge> E=new SequenceList<AdjacencyMatrix.Edge>();
    	SequenceList<String> u=new SequenceList<String>();//存放所有已访问过的顶点集合
		boolean[] already=new boolean[n];//标记已经进入最小生成树的节点
		already[pos]=true;
		u.add(name);
		//初始化该节点到每个节点权值
		for(int i=0;i<n;i++) {
			lowDis[i]=c.getWeight(pos,i);
			closest[i]=c.getValue(pos);
		}
		//算法主体
		for(int i=0;i<n-1;i++) {
			int min=32767;
			int j=pos;//标记新加入生成树的顶点
			//寻求还未加入生成树且离生成树最近的节点
			for(int k=0;k<n;k++) {
				if(!already[k] && lowDis[k]<min) {
					min=lowDis[k];
					j=k;
				}
			}
			already[j] = true;
			u.add(c.getValue(j));
			e=m.new Edge(closest[j],c.getValue(j),min);
			E.add(e);
			//更新还未进入生成树的所有节点的最小权值
			for(int k=0;k<n;k++) {
			    if(!already[k] && (c.getWeight(j,k)<lowDis[k] || lowDis[k]==32767)) {
			    	lowDis[k] =c.getWeight(j,k);//更新该节点最小的权值
					closest[k] = c.getValue(j);//更新该节点离最小生成树中最近的点
				}
			}
		}
        m.setSqlList(u);
        for(int p=0;p<E.getSize();p++) {
        	m.setWeight(m.getVertexPos(E.get(p).start),m.getVertexPos(E.get(p).end),E.get(p).weight);
        	m.setWeight(m.getVertexPos(E.get(p).end),m.getVertexPos(E.get(p).start),E.get(p).weight);
        }
		return m;
    }
    
    //求最短哈密尔顿回路（导游线路图）
    public AdjacencyMatrix shortLoop(AdjacencyMatrix c) {
    	int n=c.numOfVertices();//顶点的个数
    	AdjacencyMatrix m=new AdjacencyMatrix(n);
    	m.setSqlList(c.getSqlList());
    	SequenceList<String> v=new SequenceList<String>();//存放所有已访问过的顶点集合
    	shortMatrix(c,m);
		for(int i=0;i<n;i++) {
			if(m.getEdges(i).getSize()==1) {
				v.add(m.getValue(i));
			}
		}
		//当该顶点的度为2时，该边加入新图
		if(v.getSize()>=2) {
			for(int a=0;a<v.getSize();a++) {
				for(int b=a+1;b<v.getSize();b++) {
					if(c.getWeight(m.getVertexPos(v.get(a)),m.getVertexPos(v.get(b)))!=32767) {
						m.setWeight(m.getVertexPos(v.get(a)),m.getVertexPos(v.get(b)),c.getWeight(m.getVertexPos(v.get(a)),m.getVertexPos(v.get(b))));
						m.setWeight(m.getVertexPos(v.get(b)),m.getVertexPos(v.get(a)),c.getWeight(m.getVertexPos(v.get(a)),m.getVertexPos(v.get(b))));
						a=b=v.getSize();
					}
				}
			}
		}
		shortMatrix(c,m);
		//当剩下的顶点的度为1时，该边加入新图
		for(int a=0;a<n;a++) {
			if(c.getEdges(a).getSize()==1 && m.getEdges(a).getSize()==1) {
				m.setWeight(c.getEdges(a).get(0),a,c.getWeight(c.getEdges(a).get(0),a));
				m.setWeight(a,c.getEdges(a).get(0),c.getWeight(c.getEdges(a).get(0),a));
			}
		}
		shortMatrix(c,m);
		return m;
    }
    //简化邻接表
    private void shortMatrix(AdjacencyMatrix c,AdjacencyMatrix m) {
		int n=c.numOfVertices();//顶点的个数
		//简化邻接表
		for(int a=0;a<n;a++) {
			if(m.getEdges(a).getSize()==2) {
				for(int b=0;b<n;b++) {
					c.setWeight(a,b,32767);
					c.setWeight(b,a,32767);
				}
			}
		}
		//当该顶点的度为2时，该边加入新图
		for(int a=0;a<n;a++) {
			if(c.getEdges(a).getSize()==2 && m.getEdges(a).getSize()==0) {
				m.setWeight(c.getEdges(a).get(0),a,c.getWeight(c.getEdges(a).get(0),a));
				m.setWeight(a,c.getEdges(a).get(0),c.getWeight(c.getEdges(a).get(0),a));
				m.setWeight(c.getEdges(a).get(1),a,c.getWeight(c.getEdges(a).get(1),a));
				m.setWeight(a,c.getEdges(a).get(1),c.getWeight(c.getEdges(a).get(1),a));
			}
		}
    }
    //求最短哈密尔顿回路（导游线路图）
    public void shortLoop(AdjacencyMatrix c,String name) {
    	AdjacencyMatrix k=shortLoop(c);
    	String s=k.travel(k.getVertexPos(name));
    	System.out.println(s);
    }
    
    
    /*
     * 管理员模块
     */
    //插入景点
    public boolean insertScenicSpot(String str) {
    	//文件中插入景点
    	boolean k=false;
		try {
			FileWriter fw=new FileWriter("ScenicSpot.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(str);
			bw.newLine();
			bw.close();
			fw.close();
			k=true;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		//邻接表中插入景点
		String[] a=str.split("\\+");
		LinkedList<Relationship> link=new LinkedList<Relationship>();
		ScenicSpot s=new ScenicSpot(a[0],a[1],Integer.parseInt(a[2]),a[3],a[4],0,0,null,link);
		adjList.addVertex(s);
		return k;
    }
    
    //删除景点
	public boolean deleteScenicSpot(String name) {
		//文件中删除景点
    	boolean k=false;
		try {
			//将文件中的信息全部读出，保存在数组里
			FileReader fr0=new FileReader("ScenicSpot.txt");
			BufferedReader br0=new BufferedReader(fr0);
		    String str0=null;
		    boolean flag=false;
			while((str0=br0.readLine())!=null){
				String arr[]=str0.split("\\+");//划分字符串
				String name1=arr[0];
				if(name.equals(name1)) {
					flag=true;
				}
			}
			br0.close();
			fr0.close();
			if(flag==true) {
				//将文件中的信息全部读出，保存在数组里
				FileReader fr=new FileReader("ScenicSpot.txt");
				BufferedReader br=new BufferedReader(fr);
			    String str=null;
				ArrayList<String> list=new ArrayList<String>();
				while((str=br.readLine())!=null){
					String arr[]=str.split("\\+");//划分字符串
					String name1=arr[0];
					if(!(name.equals(name1))) {
						list.add(str);
					}
				}
				br.close();
				fr.close();
				//将数组里的信息重新保存到文件中
				FileWriter fw=new FileWriter("ScenicSpot.txt");
				BufferedWriter bw=new BufferedWriter(fw);
				for(int i=0;i<list.size();i++ ){
					bw.write(list.get(i));
					bw.newLine();
				}
				bw.close();
				fw.close();
				k=true;
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		//邻接表中删除景点
		adjList.deleteVetex(adjList.getValue(adjList.getPosition(name)));
		return k;
	}
	
	//插入路线
	public boolean insertRelationship(String str) {
		//文件中插入路线
    	boolean k=false;
		try {
			FileWriter fw=new FileWriter("Relationship.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(str);
			bw.newLine();
			bw.close();
			fw.close();
			k=true;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		//邻接表中插入路线
		String[] a=str.split(",");
		//若该起点存在
		if(adjList.getPosition(a[0])!=-1) {
			if(adjList.getPosition(a[1])==-1) {//该终点不存在
				LinkedList<Relationship> link=new LinkedList<Relationship>();
				ScenicSpot f=new ScenicSpot(a[1],link);
				Relationship r1=new Relationship(adjList.getValue(adjList.getPosition(a[0])),Integer.parseInt(a[2]),Integer.parseInt(a[3]));
				Relationship r2=new Relationship(f,Integer.parseInt(a[2]),Integer.parseInt(a[3]));
				adjList.addVertex(f);
				adjList.addEdge(a[1],r1);
				adjList.addEdge(a[0],r2);
			}
		}
		//该起点不存在
		else {
			if(adjList.getPosition(a[1])!=-1) {//该终点存在
				LinkedList<Relationship> link=new LinkedList<Relationship>();
				ScenicSpot c=new ScenicSpot(a[0],link);
				Relationship r1=new Relationship(adjList.getValue(adjList.getPosition(a[1])),Integer.parseInt(a[2]),Integer.parseInt(a[3]));
				Relationship r2=new Relationship(c,Integer.parseInt(a[2]),Integer.parseInt(a[3]));
				adjList.addVertex(c);
				adjList.addEdge(a[0],r1);
				adjList.addEdge(a[1],r2);
			}
			else {//该终点不存在
				LinkedList<Relationship> link1=new LinkedList<Relationship>();
				LinkedList<Relationship> link2=new LinkedList<Relationship>();
				ScenicSpot s1=new ScenicSpot(a[0],link1);
				ScenicSpot s2=new ScenicSpot(a[1],link2);
				adjList.addVertex(s1);
				adjList.addVertex(s2);
				Relationship r1=new Relationship(s1,Integer.parseInt(a[2]),Integer.parseInt(a[3]));
				Relationship r2=new Relationship(s2,Integer.parseInt(a[2]),Integer.parseInt(a[3]));
				adjList.addEdge(a[0],r2);
				adjList.addEdge(a[1],r1);
			}
		}
		
		return k;
	}
	
	//删除路线
	public boolean deleteRelationship(String namec,String namef) {
		//文件中删除路线
		boolean k=false;
		try {
			//查看该信息是否存在
			FileReader fr0=new FileReader("Relationship.txt");
			BufferedReader br0=new BufferedReader(fr0);
		    String str0=null;
			boolean flag=false;
			while((str0=br0.readLine())!=null){
				String arr[]=str0.split(",");//划分字符串
				String name=namec+","+namef;
				String name1=arr[0]+","+arr[1];
				if(name.equals(name1)) {
					flag=true;
				}
			}
			br0.close();
			fr0.close();
			if(flag==true) {
				//将文件中的信息全部读出，保存在数组里
				FileReader fr=new FileReader("Relationship.txt");
				BufferedReader br=new BufferedReader(fr);
			    String str=null;
				ArrayList<String> list=new ArrayList<String>(); 
				while((str=br.readLine())!=null){
					String arr[]=str.split(",");//划分字符串
					String name=namec+","+namef;
					String name1=arr[0]+","+arr[1];
					if(!name.equals(name1)) {
						list.add(str);
					}
				}
				br.close();
				fr.close();
				//将数组里的信息重新保存到文件中
				FileWriter fw=new FileWriter("Relationship.txt");
				BufferedWriter bw=new BufferedWriter(fw);
				for(int i=0;i<list.size();i++ ){
					bw.write(list.get(i));
					bw.newLine();
				}
				bw.close();
				fw.close();
				k=true;
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return k;
	}
}
