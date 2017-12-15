package genericImplementations.tree;
import java.util.*;

public class Tree {
	private Node root=null;
	GenQueue<Node> queue = new GenQueue<Node>();
	public void addNode(Node node){
		if(root == null){
			root=node;
			root.setParent(null);
			queue.enqueue(root);
		}
		else {
			if(queue.peek().getLeft()==null){
				queue.peek().setLeft(node);
				node.setParent(queue.peek());
			}	
			else{
				queue.peek().setRight(node);
				node.setParent(queue.peek());
				queue.dequeue();
			}
			queue.enqueue(node);
		}
	}
	
	public void  preOrderTraversal(){
		preOrderTraversalUtil(root);
	}
	private void preOrderTraversalUtil(Node root){
		if(root==null)
			return;
		
		else{
			System.out.print(root.getData()+" ");
			preOrderTraversalUtil(root.getLeft());
			preOrderTraversalUtil(root.getRight());
		}
	}
	public void  postOrderTraversal(){
		postOrderTraversalUtil(root);
	}
	private void postOrderTraversalUtil(Node root){
		if(root==null)
			return;
		
		else{
			postOrderTraversalUtil(root.getLeft());
			postOrderTraversalUtil(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	public void  inOrderTraversal(){
		inOrderTraversalUtil(root);
	}
	private void inOrderTraversalUtil(Node root){
		if(root==null)
			return;
		
		else{
			inOrderTraversalUtil(root.getLeft());
			System.out.print(root.getData()+" ");
			inOrderTraversalUtil(root.getRight());
		}
	}
	public boolean search(int data){
		return searchUtil(root, data);
	}
	
	private boolean searchUtil(Node root,int data){
		boolean temp;
		if(root==null)
			return false;
		
		else{
			if(data == root.getData())
				return true;
			temp=searchUtil(root.getLeft(), data);
			//System.out.print(root.getData()+" ");
			if(temp)
				return true;			
			else
				return searchUtil(root.getRight(),data);
		}
	}
	public int getHeight(){
		return heightUtil(root);
	}
	private int heightUtil(Node root){
		if(root==null)
			return -1;
		else{
			int left=heightUtil(root.getLeft());
			int right=heightUtil(root.getRight());
			//System.out.println("Left:  "+left+"\nRight:  "+right);
			if(left>right){
				return left+1;
			}
			else{
				return  right+1;
			}
		}
	}
	public int getHeightNoRecursion(){
		return getHeightNoRecursionUtil(root);
	}
	private int getHeightNoRecursionUtil(Node root){
		if(root == null)
			return 0;
		int numberOfLeaves=0;
		int diameter=0,tempDiameter=0;
		int numberOfFullNodes=0;
		GenQueue<Node> q=new GenQueue<Node>();
		q.enqueue(root);
		q.enqueue(null);
		int level=0;
		while(q.size()!=0){
			root=q.dequeue();
			if(root == null){
				if(q.size()!=0)		//if not checked --> will continue adding null and the loop will never end!!
					q.enqueue(null);
				if(diameter<=tempDiameter){
					diameter=tempDiameter;
					tempDiameter=0;
				}
				level++;
			}
			else{
				if(root.getLeft()==null && root.getRight()==null)
					numberOfLeaves++;
				if(root.getLeft()!=null && root.getRight()!=null)
					numberOfFullNodes++;
				if(root.getLeft()!=null)
					q.enqueue(root.getLeft());
				if(root.getRight()!=null)
					q.enqueue(root.getRight());
				tempDiameter++;
			}
		}
//		System.out.println("Number of Leaves:  "+numberOfLeaves);
//		System.out.println("Number of FullNodes:  "+numberOfFullNodes);//HaHa!
//		System.out.println("Diameter:  "+diameter);
		return level;
	}
//	public Node construcTree(String preOrder, String inOrder){
//		return constructTree(root,preOrder,inOrder);
//	}
//	private Node constructTree(Node root, String preOrder, String inOrder){
//		if(preOrder.length()==3)
//			return root;
//		else{
//
//				
//		}
//	}
	
	public void printAllAncestors(int data){
		int allAncestors[]=new int[200],length=0;
		length=printAllAncestors(root,data,allAncestors,length);
		System.out.println("Length:  "+length);
		for(int i=0;i<length;i++){
			System.out.println(allAncestors[i]+" ");
		}
	}
	private int printAllAncestors(Node root,int data, int[] ancestors, int length){
		if(root==null)
			return 0;
		else if(root.getData()==data){
			System.out.println("Data: "+root.getData());
			length++;
			System.out.println("FinalLength:  "+length);
			return length;
		}
		else{
			ancestors[length++]=root.getData();
			System.out.println("Length:  "+length);
			for(int i=0;i<length;i++){
				System.out.println(ancestors[i]+" ");
			}
			printAllAncestors(root.getLeft(),data,ancestors,length);
			System.out.println("Length After left:  "+length);
			if(root.getData()!=data){
				printAllAncestors(root.getRight(),data,ancestors,length);
				System.out.println("Length After Right:  "+length);
			}
			
		}
		return length;
	}
	
	
	public boolean LCA(int data1, int data2){
		return LCAUtil(root,data1,data2);
	}
	private boolean LCAUtil(Node root, int data1, int data2){
		boolean found1=false,found2=false;
		if(root == null)
			return false;
		if(root.getData()==data1){
			found1=true;
			//System.out.println("in data 1");
			return true;
		}
		if(root.getData()==data2){
			found2 = true;
			//System.out.println("IN DATA 2");
			return true;
		}
		boolean left=LCAUtil(root.getLeft(), data1, data2);
//		System.out.println("LEFT-->root.getData():  "+root.getData());
//		System.out.println("left:  "+left);
		boolean right= LCAUtil(root.getRight(), data1, data2);
//		System.out.println("RIGHT-->root.getData():  "+root.getData());
//		System.out.println("right:  "+right);
		if(left && right )
			return true;
		return false;
	}
	
	public void createTreeFromPreOrder(String preOrder){
		Node root=createTreeFromPreOrderUtil(preOrder,0);
		preOrderTraversalUtil(root);
	}
	//WTF is wrong with this!! :/
	private Node createTreeFromPreOrderUtil(String preOrder, int index){
		if(index>preOrder.length()-1){
			System.out.println("Returning:  "+index);
			return null;
		}
		Node newNode= new Node();
		System.out.println("Index:  "+index);
		newNode.setData(preOrder.charAt(index));
		newNode.setLeft(null);
		newNode.setRight(null);
		if(newNode.getData()=='2')
			return newNode;
		index+=1;
		newNode.setLeft(createTreeFromPreOrderUtil(preOrder, index));
		index+=1;
		newNode.setRight(createTreeFromPreOrderUtil(preOrder, index));
		return newNode;
	}
	
	//Moris Traversal is used for traversing without using queue/stack or recursion!!
	public void morisInOrder(){
		morisInOrderUtil(root);
	}
	private void morisInOrderUtil(Node root){
		Node current=root;
		while(current!=null){
			if(current.getLeft()==null){
				System.out.print(current.getData()+" ");
				current=current.getRight();
			}
			else{
				Node predecessor=getPredecessor(current);
				//System.out.println("Predecessor Data:  "+predecessor.getData());
				if(predecessor.getRight()==current){
					System.out.print(current.getData()+" ");
					current=current.getRight();
					predecessor.setRight(null);
				}
				else{
					predecessor.setRight(current);
					current=current.getLeft();
				}
			}
		}
	}
	private Node getPredecessor(Node node){
		Node current=node;
		if(node.getLeft()==null)
			return node;
		else{
			node=node.getLeft();
			while(node.getRight()!=null && node.getRight()!=current)
				node=node.getRight();
			return node;
		}
	}
}