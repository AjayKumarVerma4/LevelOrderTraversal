package pack1;

import java.util.Scanner;


class Node 
{ 
    int data; 
    Node left, right; 
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 

public class LevelOrderTraversal {
 
    Node root; 
  
    public LevelOrderTraversal() 
    { 
        root = null; 
    } 
  
    void printLevelOrder() 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 
  
    int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            int lheight = height(root.left); 
            int rheight = height(root.right); 
              
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    } 
  
    void printGivenLevel (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
      
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
    	LevelOrderTraversal tree = new LevelOrderTraversal(); 
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the number of elements");
    	int N=sc.nextInt();
    	int ar[]=new int[N];
    	int i;
    	System.out.println("Enter the elements");
    	for(i=0;i<N;i++) {
    		ar[i]=sc.nextInt();
    	}
    	
    	tree.root=new Node(ar[0]);
    	for(i=1;i<N;i++) {
    		makeTree(tree,ar[i]);
    	}
    	
       System.out.println("Level order traversal of binary tree is "); 
       tree.printLevelOrder(); 
    } 
    static void makeTree(LevelOrderTraversal tree,int el) {
    	Node current=tree.root;
    	while(true) {
    		if(el<current.data) {
    			if(current.left==null) {
    				current.left=new Node(el);
    				System.out.println("Inserted "+el+" at left of "+current.data);
    				break;
    			}
    			else {
    				current=current.left;
    			}
    		}
    		else {
    			if(current.right==null) {
    				current.right=new Node(el);
    				System.out.println("Inserted "+el+" at right of "+current.data);
    				break;
    			}
    			else {
    				current=current.right;
    			}
    			
    		}
    	}
    }

}
