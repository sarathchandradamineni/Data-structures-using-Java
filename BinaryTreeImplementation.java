//Implementation of the Binary Tree using linked list
//Operations included are Creation of the Tree and traversals such as pre,post,In order traversals and finding height of the tree

//Class containing main method
public class BinaryTreeImplementation 
{
	Node root;
	public BinaryTreeImplementation()
	{
		root  = null;
	}
	public static void main(String args[])
	{
		BinaryTreeImplementation bti = new BinaryTreeImplementation();
		Implementation i = new Implementation();
		i.createTree();
		
		System.out.println("the tree is");
		i.display();
		
		System.out.println("Preorder traversal is:");
		i.preorder();
		System.out.println("");
		
		System.out.println("Post order traversal is:");
		i.postorder();
		System.out.println("");
		
		System.out.println("Inorder traversal is:");
		i.inorder();
		
		System.out.println("");
		i.height();
	}
}

//Node structure of the tree
class Node
{
	char info;
	Node lchild;
	Node rchild;
	public Node(char data)
	{
		info = data;
		lchild = null;
		rchild = null;
	}
}

//Class that implements all the operations of the tree using the linked list
class Implementation
{
	Node node;
	
	//Creation of the tree
	public void createTree()
	{
	    node = new Node('A');
		node.lchild = new Node('B');
		node.rchild = new Node('C');
		node.lchild.lchild = new Node('D');
		node.lchild.rchild = new Node('E');
		node.rchild.lchild = new Node('F');
		node.rchild.rchild = new Node('G');
	}
	
	//Display of the tree
	public void display()
	{
		display(node,0);
		System.out.println("");
	}
	
	public void display(Node p,int level)
	{
		if(p == null)
			return;
		
		display(p.rchild,level+1);
		System.out.println();
		
		for(int i = 0;i < level;i++)
			System.out.print("      ");
		System.out.println(p.info);
		
		display(p.lchild,level+1);
	}
	
	//pre-order traversal 
	//order : root-left-right 
	public void preorder()
	{
		preorder(node);
		System.out.println("");
	}
	
	public void preorder(Node p)
	{
		if(p == null)
			return;
		System.out.print(p.info);
		preorder(p.lchild);
		preorder(p.rchild);
	}
	
	//post-order traversal
	//order : left-right-root
	public void postorder()
	{
		postorder(node);
		System.out.println("");
	}
	
	public void postorder(Node p)
	{
		if(p == null)
			return;
		
		postorder(p.lchild);
		postorder(p.rchild);
		System.out.print(p.info);
	}
	
	//In-order traversal
	//order : left-root-right
	public void inorder()
	{
		inorder(node);
		System.out.println("");
	}
	
	public void inorder(Node p)
	{
		if(p == null)
			return;
		
		inorder(p.lchild);
		System.out.print(p.info);
		inorder(p.rchild);
	}
	
	//finding the height of the tree
	public void height()
	{
		int tree_height = height(node);
		System.out.println("height of the tree is "+tree_height);
	}
	
	public int height(Node p)
	{
		int hL,hR;
		if(p == null)
			return 0;
		
		hL = height(p.lchild);
		hR = height(p.rchild);
		
		if(hL >= hR)
			return 1+hL;
		else
			return 1+hR;
	}
}
