import java.lang.instrument.IllegalClassFormatException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node {
    Node left;
    Node right;
    int val;

    Node(int x, Node a, Node b) {
        val = x;
        left = a;
        right = b;
    }

    Node() {

    }

    ;

    Node(int x, int y, int z) {
        val = x;
        left = new Node(y, null, null);
        right = new Node(z, null, null);

    }
    Node(int x, Node node, int y){
        val=x;
        left=node;
        right=new Node(y,null,null);
    }
    Node(int x, int y, Node b){
        val=x;
        left=new Node(y,null,null);
        right=b;
    }
    public String toString(){
        return val+"->";
    }
}

public class TreeNode {
    static Node root;

    void create() {
        root=new Node(5,new Node(12,new Node(9,2,1),new Node(10,null,6)),new Node(7,new Node(3,null,4),null));
    }
    void tientu(Node t){
        if(t!=null){
            System.out.print(t);
            tientu(t.left);
            tientu(t.right);
        }
    }
    void trungtu(Node t){
        if(t!=null){
            trungtu(t.left);
            System.out.print(t);
            trungtu(t.right);
        }
    }
    void hautu(Node t){
        if(t!=null){
            hautu(t.left);
            hautu(t.right);
            System.out.print(t);
        }
    }
    int height(Node t){
        if(t==null){
            return 0;
        }
        int a=height(t.right);
        int b=height(t.left);
        if(a>b){
            return a+1;
        }
        return b+1;
    }
    public static boolean exist=false;
    void findx(Node t,int x){
        if(root==null){
            System.out.println("empty tree");
        }
        if(t.val==x){
            exist=true;
            return;
        }
        if(t!=null && !exist){
            findx(t.left,x);
        }
        if(t!=null && !exist){
            findx(t.right,x);
        }
    }
    void knode(Node t,int currentlevel,int level){
        if(t==null){
            return;
        }
        if(currentlevel==level){
            System.out.print(t);
            return;
        }
        knode(t.left,currentlevel+1,level);
        knode(t.right,currentlevel+1,level);
    }
   void allNodeAtLevel(Node t,int k){
        if(t==null){
            return;
        }
        allNodeAtLevel(t.left,k-1);
        allNodeAtLevel(t.right,k-1);
       if(k==0){
           System.out.print(t);
       }
   }
    public static void main(String[] args) {
        TreeNode tree=new TreeNode();
        tree.create();
//        System.out.println("tien tu: ");
//        tree.tientu(root);
//        System.out.println("null");
//        System.out.println("trung tu: ");
//        tree.hautu(root);
//        System.out.println("null");
//        System.out.println("hau tu: ");
//        tree.trungtu(root);
//        System.out.println("null");
//        System.out.println("chieu cao cua cay: "+tree.height(root));
//        tree.findx(root,9);
//        System.out.println(exist);
//        tree.knode(root,0,3);
        tree.allNodeAtLevel(root,3);
    }
}

