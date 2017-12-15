package genericImplementations.tree;

public class TreeMain {
	public static void main(String[] args){
		Tree tree=new Tree();
		tree.addNode(new Node(1));
		tree.addNode(new Node(2));
		tree.addNode(new Node(3));
		tree.addNode(new Node(4));
		tree.addNode(new Node(5));
		tree.addNode(new Node(6));
		tree.addNode(new Node(7));
		tree.addNode(new Node(8));
		tree.addNode(new Node(9));
		
		System.out.println("PreOrder!!");
		tree.preOrderTraversal();
		System.out.println("\nPostOrder!!");
		tree.postOrderTraversal();
		System.out.println("\nInOrder!!");
		tree.inOrderTraversal();
		System.out.println("\nMORIS INORDER!!");
		tree.morisInOrder();
		//System.out.println("Done!!");
		System.out.println("\nSearch:  "+tree.search(1));
		System.out.println("Height:  "+tree.getHeight());
		System.out.println("HeightNoRecursion:  "+tree.getHeightNoRecursion());
//		//System.out.println("Ancestors:  ");
//		//tree.printAllAncestors(5);
		System.out.println("LCA of (5,7)"+tree.LCA(5, 10));
		tree.createTreeFromPreOrder("11212212122");
	}
}