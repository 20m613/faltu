package ccdsap;

import java.util.HashMap;

public class DisjointSetTest {
	public static void main(String[] args) {
		DisjointSet set=new DisjointSet();
		set.create(1);
		set.create(3);
		set.create(2);
		set.create(4);
		set.create(5);
		set.create(6);
		set.create(7);
		set.merge(1, 2);
		set.merge(1, 3);
		set.merge(5, 6);
		set.merge(5, 1);
		set.merge(7, 5);
		set.merge(5, 6);
		//set.merge(4, 3);
		System.out.println(set.find(1).data);
		System.out.println(set.find(2).data);
		System.out.println(set.find(3).data);
		System.out.println(set.find(4).data);
		System.out.println(set.find(5).data);
		System.out.println(set.find(6).data);
		System.out.println(set.find(7).data);
	}
	
}
class Node{
	Integer data;
	int rank;
	Node parent;
}
class DisjointSet{
	HashMap<Integer, Node> map=new HashMap<Integer , Node>();//to keep track of the nodes present
	public void create(int data){
		Node node=new Node();
		node.data=data;
		node.rank=0;
		node.parent=node;
		map.put(data, node);
	}
	
	public void merge(Integer data1, Integer data2){
		Node node1=find(data1);
		Node node2=find(data2);
		Node parent1=node1.parent;
		Node parent2=node2.parent;
		if(parent1.rank==parent2.rank){
			parent1.parent=parent2;//parent2<---parent1
			parent2.rank+=1;
		}
		else if(parent1.rank<parent2.rank){
			parent1.parent=parent2;
		}
		else
			parent2.parent=parent1;
		
	}
	public Node find(Integer data){//returns the parent of the set to which the node with data=data belongs
		return findNode(map.get(data));
	}
	public Node findNode(Node node){//for path compression
		Node parent=node.parent;
		if(node==parent)//as root's parent is itself
			return node;
		node.parent=findNode(node.parent);
		return node.parent;//this is for path decomposition ie. setting the parent of every child node directly to the root.
	}
}