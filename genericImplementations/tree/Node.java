package genericImplementations.tree;

public class Node {
	private int data;
	private Node left;
	private Node right;
	private Node parent;
	//private int rBit;
	public Node(){}
//	public int getrBit() {
//		return rBit;
//	}
//	public void setrBit(int rBit) {
//		this.rBit = rBit;
//	}
	public Node(int data){
		this.data=data;
		//this.rBit=1;//1:it has right subtree 
					//0:the right node is a pointer to the inOrder successor
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
}