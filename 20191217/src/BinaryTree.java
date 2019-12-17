import java.util.*;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val) {
        this.val = val;
    }
}
public class BinaryTree {

    public BinaryTree() {
    }

    public TreeNode buildTree() {
        TreeNode root = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return root;
    }

    //给定一个二叉树，找出其最大深度。
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return leftHight > rightHight ? leftHight+1 : rightHight+1;
    }

    //判断一颗二叉树是否是平衡二叉树(每颗树都是平衡二叉树)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return (Math.abs(rightHight - leftHight) <= 1) &&
                isBalanced(root.left) && isBalanced(root.right);
    }


    //对称二叉树
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        if(leftTree==null&&rightTree!=null || leftTree!=null&&rightTree==null){
            return false;
        }
        if(leftTree==null && rightTree==null){
            return true;
        }
        return leftTree.val==rightTree.val &&
                isSymmetricChild(leftTree.left,rightTree.right) &&
                isSymmetricChild(leftTree.right,rightTree.left);
    }
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return false;
        }
        return isSymmetricChild(root.left,root.right);
    }

    //二叉树的前序遍历，非递归迭代实现
    List<Character> preOrderTraversalNor(TreeNode root){
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while ((cur !=null)){
                stack.push(cur);
                System.out.println(cur.val+" ");
                list.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return  list;
    }
    //二叉树的中序遍历，非递归迭代实现
    List<Character> inOrderTraversalNor(TreeNode root){
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while ((cur !=null)){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return  list;
    }

    //二叉树的后序遍历，非递归迭代实现


    //层序遍历
    void levelOrderTravel(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root !=null){
            queue.offer(root);//入队
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.val+" ");

            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }
}
