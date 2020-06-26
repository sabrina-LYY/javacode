import java.util.ArrayList;
import java.util.List;

class Node{
    public char value;
    public Node left;
    public Node right;

    public Node(char value){
        this.value = value;
    }
}

public class BinaryTree {
    public Node CreateNode(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;
        C.right=G;
        E.right=H;
        return A;
    }
    //前序遍历
    public void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value+" ");
        inOrderTraversal(root.right);
    }
    public void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value+" ");
    }

    public int getSize(Node root){
        if(root==null){
            return 0;
        }
        return 1+getSize(root.left)+getSize(root.right);
    }

    //遍历求结点个数
    static int size = 0;
    public int getSize2(Node root){
        if(root==null){
            return 0;
        }
        size++;
        getSize2(root.left);
        getSize2(root.right);
        return size;
    }

    //求叶子结点个数
    public int getLeafSize(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }else{
            return getLeafSize(root.left)+getLeafSize(root.right);
        }
    }
    //遍历思路求叶子结点个数
    static int leafSize = 0;

    public void getLeafSize2(Node root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            leafSize++;
            return;
        }else{
            getLeafSize2(root.left);
            getLeafSize2(root.right);
        }
    }

    //求第K层结点个数:左树的K-1层加上右树的K-1层
    public int getKLevelSize(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    //求二叉树的高度
    public int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
    }

    //查找value所在的节点
    public Node find(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.value==val){
            return root;
        }
        Node ret = find(root.left,val);
        if(ret!=null){
            return ret;
        }
        ret = find(root.right,val);
        if(ret!=null){
            return ret;
        }
        return null;
    }

}
