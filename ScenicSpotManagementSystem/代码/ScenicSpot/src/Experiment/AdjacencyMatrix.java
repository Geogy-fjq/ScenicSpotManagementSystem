package Experiment;

public class AdjacencyMatrix {
	private final static int maxNumEdges=225;
	private final static int maxNumVertices=15;
	private SequenceList<String> verticesList;
	private int[][] edges=new int[maxNumVertices][maxNumVertices];
	private int currentEdges;
	
	class Edge {
		String start;
		String end;
		int weight;
		public Edge(String minstart,String mindest,int weight) {
			this.start=minstart;
			this.end=mindest;
			this.weight=weight;
		}
	}
	public AdjacencyMatrix(int size) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(i==j) {
					edges[i][j]=0;
				}
				else {
					edges[i][j]=32767;
				}
			}
		}
		currentEdges=0;
	}
	public SequenceList<String> getSqlList() {
		return verticesList;
	}
	//初始化顶点的顺序表
	public void setSqlList(SequenceList<String> verticesList) {
		this.verticesList=verticesList;
	}
	//判断是否为空
	public boolean isEmpty() {
		return verticesList.isEmpty();
	}
	//判断是否为满
	public boolean isFull() {
		return currentEdges==maxNumEdges;
	}
	//返回顶点的数量
	public int numOfVertices() {
		return verticesList.getSize();
	}
	//返回边的数量
	public int numOfEdges() {
		for(int i=0;i<numOfVertices();i++) {
			for(int j=0;j<numOfVertices();j++) {
				if(edges[i][j]!=0 && edges[i][j]!=32767) {
					currentEdges++;
				}
			}
		}
		return currentEdges;
	}
	//返回顶点的位置
	public int getVertexPos(String v) {
		return verticesList.find(v);
	}
	//返回指定索引的顶点值
	public String getValue(int index) {
		if(index>=0 && index<verticesList.getSize()) {
			return verticesList.get(index);
		}
		return null;
	}
	//返回两个顶点的权值（边）
	public int getWeight(int un,int v2) {
		if((un>=0 && un<numOfVertices())&&(v2>=0 && v2<numOfVertices())) {
			return edges[un][v2];
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	//修改两个顶点的权值（边）
	public int setWeight(int v1,int v2,int weight) {
		if((v1>=0 && v1<verticesList.getSize())&&(v2>=0 && v2<verticesList.getSize())) {
			edges[v1][v2]=weight;
			return edges[v1][v2];
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	//返回顶点v的的邻接边数
	public SequenceList<Integer> getEdges(int v) {  
		SequenceList<Integer> list=new SequenceList<Integer>();
		for(int i=0;i<numOfVertices();i++) {
	 		if(edges[v][i]!=32767 && edges[v][i]!=0) {
				list.add(i);
			}
	 	}
	 	return list;
	}
	//返回顶点v的第一个邻接顶点的下标
	public int getFirstNeighbor(int v) {  
		for(int i=0;i<numOfVertices();i++) {
	 		if(edges[v][i]!=32767 && edges[v][i]!=0) {
				return i;
			}
	 	}
	 	return -1;
	}
	//返回在v后w个的邻接顶点
	public int getNextNeighbor(int v,int w) {   
		for(int i=w+1;i<numOfVertices();i++) {
			if (edges[v][i]!=32767 && edges[v][i]!=0) {
				return i;
			}
		}
		return -1;
	}  
	//深度遍历
	private void DFS(int v,int[] visited) {
		System.out.print(getValue(v)+"——");
		visited[v]=1;
		int next=getFirstNeighbor(v);
		while (next!=-1) {
			if (visited[next]==0) {
				DFS(next,visited);
			}
			next=getNextNeighbor(v,next);
		}
    }
	public void DFS(int v) {
		int[] visited=new int[numOfVertices()];
		System.out.print("以'"+getValue(v)+"'为起始点的导游线路是:");
		DFS(v,visited);
		System.out.print(getValue(v));
	}
	//遍历
	public String travel(int v) {
		boolean[] visited=new boolean[numOfVertices()];
		String start=getValue(v);
		String str="以'"+start+"'为起始点的导游线路是:"+start+"——";
		int dis=0;
		visited[v]=true;
		for(int j=0;j<=numOfVertices();j++) {
			for(int i=0;i<=numOfVertices();i++) {
				if (edges[v][i]!=32767 && edges[v][i]!=0 && visited[i]==false) {
					dis+=getWeight(v,i);
					str+=getValue(i)+"——";
					v=i;
					visited[i]=true;
				}
			}
		}
		dis+=getWeight(this.getVertexPos(start),v);
		str+=start+"  (总距离是:"+dis+")";
		return str;
	}
}
