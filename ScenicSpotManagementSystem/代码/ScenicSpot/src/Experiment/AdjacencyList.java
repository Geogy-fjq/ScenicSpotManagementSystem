package Experiment;

public class AdjacencyList {
	//定义邻接表的属性
	private SequenceList<ScenicSpot> sqlList=new SequenceList<ScenicSpot>();
	
	//返回该邻接表
	public SequenceList<ScenicSpot> getList() {
		return sqlList;
	}
	//判断是否为空
	public boolean isEmpty() {
		return sqlList.isEmpty();
	}
	//返回顶点的个数
	public int getSize() {
		return sqlList.size();
	}
	//查找指定顶点值在邻接表中的位置
	public int getPosition(String name) {
		for(int i=0;i<sqlList.getSize();i++) {
			if((sqlList.get(i).getName()).equals(name)) {
				return i;
			}
		}
		return -1;
	}
	//根据位置查找顶点
	public ScenicSpot getValue(int i) {
		if(i>=0 && i<sqlList.size()) {
			return sqlList.get(i);
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	//返回列表的所有顶点名
	public String[] values() {
		String[] List=new String[sqlList.getSize()];
		for(int i=0;i<sqlList.getSize();i++) {
			List[i]=sqlList.get(i).getName();
		}
		return List;
	}
	//插入顶点
	public void addVertex(ScenicSpot v) {
		if(this.getPosition(v.name)==-1) {
			sqlList.add(v);
		}
	}
	//删除指定顶点
	public void deleteVetex(ScenicSpot v) {
		sqlList.delete(getPosition(v.name));
	}
	//插入边
	public ScenicSpot addEdge(String name,Relationship data) {
		ScenicSpot v=this.getValue(getPosition(name));
		if(v.getRelationship().getPosition(data.getScenicSpot().getName())==-1) {//该边还未存在，加入边
			v.getRelationship().add(data);
			return v;
		}
		return null;
	}
	//删除指定边
	public ScenicSpot deleteEdge(String name,Relationship data) {
		ScenicSpot v=this.getValue(getPosition(name));
		v.getRelationship().delete(data.getScenicSpot().getName());
		return v;
	}
}
