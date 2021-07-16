
public class Node {
	String str;
	int frq;
	Node left;
	Node right;
	String huffmanCode;
	
	public Node() {
		this.str = null;
		this.frq = 0;
		this.left = null;
		this.right = null;
	}
	
	public Node(String s, int i) {
		this.str = s;
		this.frq = i;
		this.left = null;
		this.right = null;
	}
	
	public Node(String s, int i, Node l, Node r) {
		this.str = s;
		this.frq = i;
		this.left = l;
		this.right = r;
	}
	
	public String getString() {
		return str;
	}
	
	public int getFrequency() {
		return frq;
	}
	
	public void setString(String s) {
		this.str = s;
	}
	
	public void setFrequency(int i) {
		this.frq = i;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setLeft(Node l) {
		this.left = l;
	}
	
	public void setRight(Node r) {
		this.right = r;
	}
	
}
