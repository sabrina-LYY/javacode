import java.util.Scanner;

class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val){
        this.val = val;
    }
}

public class testDemo {
    //知道先序遍历，输出中序遍历的序列
    public static int i=0;
    public static Node CreateTree(String str){

        Node root = null;
        if(str.charAt(i)!='#'){
            root = new Node(str.charAt(i));
            i++;
            root.left = CreateTree(str);
            root.right = CreateTree(str);
        }else{
            i++;
        }
        return root;
    }

    public static void inorderTraversal(Node root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Node root = CreateTree(str);
        inorderTraversal(root);

    }

}
