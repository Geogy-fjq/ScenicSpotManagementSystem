package Experiment;

public class AVLTree<ScenicSpot> {
	private AVLTreeNode<ScenicSpot> root;//AVL树的根 
	
	class AVLTreeNode<Type>{//定义AVL树的结点（内部类）
		ScenicSpot data;
		int height;//高度
		AVLTreeNode<ScenicSpot> leftChild,rightChild;//左孩子、右孩子
		
		public AVLTreeNode(ScenicSpot data) {
			this.data=data;
			height=0;
			leftChild=rightChild=null;
		}
	}
	//构造空的AVL
	public AVLTree() {
		root=null;
	}
	//清空AVL
	public void clear() {
		root=null;
	}
	//判断是否为空
	public boolean isEmpty() {
		return root==null;
	}
	//树的高度
	private int height(AVLTreeNode<ScenicSpot> Root) {
	    if(Root!= null) {
	    	return Root.height;
	    }
	    return 0;
	}
	public int height() {
	    return height(root);
	}
	//获取两个数中较大的数
	private int max(int a,int b) {
		int flag=-1;
		if(a>=b) {
			flag=a;
		}
		else if(a<b) {
			flag=b;
		}
		return flag;
	}
	//LL旋转
	private AVLTreeNode<ScenicSpot> LLRotation(AVLTreeNode<ScenicSpot> n2) {
	    AVLTreeNode<ScenicSpot> n1;
	    n1=n2.leftChild;
	    n2.leftChild=n1.rightChild;
	    n1.rightChild=n2;
	    n2.height=max(height(n2.leftChild),height(n2.rightChild))+1;
	    n1.height=max(height(n1.leftChild),height(n1.rightChild))+1;
	    return n1;
	}
	//RR旋转
	private AVLTreeNode<ScenicSpot> RRRotation(AVLTreeNode<ScenicSpot> n1) {
	    AVLTreeNode<ScenicSpot> n2;
	    n2=n1.rightChild;
	    n1.rightChild=n2.leftChild;
	    n2.leftChild=n1;
	    n1.height=max(height(n1.leftChild),height(n1.rightChild))+1;
	    n2.height=max(height(n2.leftChild),height(n2.rightChild))+1;
	    return n2;
	}
	//LR旋转
	private AVLTreeNode<ScenicSpot> LRRotation(AVLTreeNode<ScenicSpot> n3) {
	    n3.leftChild=RRRotation(n3.leftChild);
	    return LLRotation(n3);
	}
	//RL旋转
	private AVLTreeNode<ScenicSpot> RLRotation(AVLTreeNode<ScenicSpot> n3) {
	    n3.rightChild=LLRotation(n3.rightChild);
	    return RRRotation(n3);
	}
	//插入
	private AVLTreeNode<ScenicSpot> insert(ScenicSpot x,AVLTreeNode<ScenicSpot> node) {
	    if(node==null) {//空的AVL树，新建节点
	    	node=new AVLTreeNode<ScenicSpot>(x);
	    }
	    if(search(x)!=null) {
	    	delete(x);
	    }
    	int result=((Experiment.ScenicSpot) x).getMinDistance()-((Experiment.ScenicSpot) node.data).getMinDistance();
	    if(result<0) {//插入到左子树
	    	node.leftChild=insert(x,node.leftChild);
	        if(height(node.leftChild)-height(node.rightChild)>=2) {//插入节点后，若AVL树失去平衡，则进行相应的调节
	        	if(((Experiment.ScenicSpot) x).getMinDistance()-((Experiment.ScenicSpot) node.leftChild.data).getMinDistance()<0) {
	        		node=LLRotation(node);
	        	}   
	            else {
	            	node=LRRotation(node);
	            }   
	        } 
	    }
	    else if(result>0) {//插入到右子树
	    	node.rightChild=insert(x,node.rightChild);
	        if(height(node.rightChild)-height(node.leftChild)>=2) {//插入节点后，若AVL树失去平衡，则进行相应的调节
	        	if(((Experiment.ScenicSpot) x).getMinDistance()-((Experiment.ScenicSpot) node.rightChild.data).getMinDistance()>0) {
	        		node=RRRotation(node);
	        	}      
	            else {
	            	node=RLRotation(node);
	            }
	        } 
	    }
	    node.height=max(height(node.leftChild),height(node.rightChild))+1;
	    return node;
	}
	public void insert(ScenicSpot x) {
	    root=insert(x,root);
	}
	
	//找出左子树的最大结点
	private AVLTreeNode<ScenicSpot> maximum(AVLTreeNode<ScenicSpot> node,AVLTreeNode<ScenicSpot> root){//传入参数为被删除节点的左孩子node
		if(node.rightChild==null){//node的右孩子为空，则node为最大结点
			return node;
		}
		else {
			node=node.rightChild;
			return maximum(node,root);
		}
	}
	public AVLTreeNode<ScenicSpot> maximum(AVLTreeNode<ScenicSpot> node){
		return maximum(node,root);
	}
	//找出右子树的最小结点
	private AVLTreeNode<ScenicSpot> minimum(AVLTreeNode<ScenicSpot> node,AVLTreeNode<ScenicSpot> root){//传入参数为被删除节点的右孩子node
		if(node.leftChild==null){//node的左孩子为空，则node为最小结点
			return node;
		}
		else {
			node=node.leftChild;
			return minimum(node,root);
		}
	}
	public AVLTreeNode<ScenicSpot> minimum(AVLTreeNode<ScenicSpot> node){
		return minimum(node,root);
	}
	//删除
	private AVLTreeNode<ScenicSpot> delete(AVLTreeNode<ScenicSpot> node,AVLTreeNode<ScenicSpot> Root) {
	    if(Root==null || node==null) {//根或要删除的结点为空，返回null
	    	return null;
	    }
	    int result=((Experiment.ScenicSpot) node.data).getMinDistance()-((Experiment.ScenicSpot) Root.data).getMinDistance();
    	if(result<0) {//待删除的节点在左子树中
	    	Root.leftChild=delete(node,Root.leftChild);
	        if(height(Root.rightChild)-height(Root.leftChild)>=2) {//删除节点后，若AVL树失去平衡，则进行相应的调节
	            AVLTreeNode<ScenicSpot> r=Root.rightChild;
	            if (height(r.leftChild)>=height(r.rightChild)) {
	            	Root=RLRotation(Root);
	            }
	            else {
	            	Root=RRRotation(Root);
	            }
	        }
	    } 
	    else if(result>0) {//待删除的节点在右子树中
	    	Root.rightChild=delete(node,Root.rightChild);
	        if(height(Root.leftChild)-height(Root.rightChild)>=2) {//删除节点后，若AVL树失去平衡，则进行相应的调节
	            AVLTreeNode<ScenicSpot> l=Root.leftChild;
	            if(height(l.rightChild)>=height(l.leftChild)) {
	            	Root=LRRotation(Root);
	            }	
	            else {
	            	Root=LLRotation(Root);
	            }
	        }
	    } 
	    else {//Root是对应要删除的节点
	        if((Root.leftChild!=null) && (Root.rightChild!=null)) {//Root的左右孩子都非空
	            if (height(Root.leftChild)>height(Root.rightChild)) {//若Root的左子树比右子树高，则找出Root的左子树中的最大节点，将该最大节点的值赋值给Root，删除该最大节点。
	                AVLTreeNode<ScenicSpot> max=maximum(Root.leftChild);
	                Root.data=max.data;
	                Root.leftChild=delete(max,Root.leftChild);
	            } 
	            else {//若Root的左子树不比右子树高，则找出Root的右子树中的最小节点，将该最小节点的值赋值给Root，删除该最小节点。
	                AVLTreeNode<ScenicSpot> min=minimum(Root.rightChild);
	                Root.data=min.data;
	                Root.rightChild=delete(min,Root.rightChild);
	            }
	        } 
	        else {//Root的左右孩子存在为空
	        	if((Root.leftChild!=null)) {
	        		Root=Root.leftChild;
	        	}
	        	else if((Root.rightChild!=null)) {
	        		Root=Root.rightChild;
	        	}
	        	else {
	        		Root=null;
	        	}
	        }
	    }
	    if(Root!=null) {
	    	Root.height=max(height(Root.leftChild),height(Root.rightChild))+1;
	    }
	    return Root;
	}
	public ScenicSpot delete(ScenicSpot x) {
	    AVLTreeNode<ScenicSpot> a; 
	    if((a=search(x,root))!=null) {
	        root=delete(a,root);
	        return x;
	    }
	    return null;
	}
		
	//递归搜索
	private AVLTreeNode<ScenicSpot> search(ScenicSpot x,AVLTreeNode<ScenicSpot> node){
		if(node==null) {//搜索失败
			return null;
		}
		int result=((Experiment.ScenicSpot) x).getMinDistance()-((Experiment.ScenicSpot) node.data).getMinDistance();
		if(result<0) {
			return search(x,node.leftChild);//在左子树递归搜索
		}
		else if(result>0) {
			return search(x,node.rightChild);//在右子树递归搜索
		}
		else {
			return node;//相等，搜索成功
		}
	}
	public AVLTreeNode<ScenicSpot> search(ScenicSpot x){
		return search(x,root);
	}
	//寻找最小结点
	private AVLTreeNode<ScenicSpot> minNode(AVLTreeNode<ScenicSpot> node){
		if(node==null){
			return null;
		}
		while(node.leftChild!=null){
			node=node.leftChild;
		}
		return node;
	}
	public AVLTreeNode<ScenicSpot> minNode(){
		return minNode(root);
	}
	//中序遍历
	private void inOrder(AVLTreeNode<ScenicSpot> node){
		if(node!=null){
			inOrder(node.leftChild);
			System.out.println(((Experiment.ScenicSpot) node.data).getName()+((Experiment.ScenicSpot) node.data).getMinDistance());
			inOrder(node.rightChild);
		}
	}
	public void inOrder(){
		inOrder(root);
	}
}
