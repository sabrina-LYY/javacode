import sun.reflect.generics.tree.Tree;

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

    //前序遍历
    void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void preOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur !=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                System.out.println(cur.val+" ");
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }
    //二叉树的前序遍历，非递归迭代实现
    List<Character> preOrderTraversalNor2(TreeNode root){
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


    //中序遍历
    void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val+" ");
        inOrderTraversal(root.right);
    }

    void BinaryinOrederNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur !=null || !stack.empty()){
            while(cur !=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val+" ");
            cur = top.right;
        }
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


    //后序遍历
    void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val+" ");
    }



    /******************/
    public void binaryTreePostOrderNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur !=null && cur.right == prev){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.left == prev){
                stack.pop();
                System.out.println(cur.val+" ");
                prev = cur;
                cur = null;
            }else{
                cur = cur.right;
            }
        }
    }

    //二叉树的后序遍历，非递归迭代实现
    public List<Integer> postorderTraversalNor(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev){
                stack.pop();
                System.out.println(cur.val+" ");
                list.add((int) cur.val);
                prev = cur;
                cur = null;
            }else{
                cur = cur.right;
            }
        }
    }

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


    //层序
    public void binaryTreeLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(root.val+" ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

    public List<List<Character>> binaryTreeLevelOrder2(TreeNode root){
        List<List<Character>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root !=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while(size>0){
                TreeNode cur = queue.poll();
                System.out.println(cur.val+" ");
                list.add(cur.val);
                if(cur.left !=null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }


    // 遍历思路-求结点个数,以前序遍历的方式
    static int size = 0;
    void getSize1(TreeNode root){
        if(root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    // 子问题思路-求结点个数
    int getSize2(TreeNode root){
        if(root==null){
            return 0 ;
        }
        //左子树结点个数+右子树节点个数+1
        int size = getSize2(root.left)+getSize2(root.right)+1;
        return size;
    }


    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(TreeNode root){
        if(root == null){
            return;
        }else if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(TreeNode root){
        if(root == null){
            return 0;
        }
        else if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int  getKLevelSize(TreeNode root,int k){
        if(root == null) {
            return 0;
        }
        if(k== 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    TreeNode find(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode ret = find(root.left,val);
        if(ret != null){
            return ret;
        }
        ret = find(root.right,val);
        if(ret!=null){
            return ret;
        }
        return null;
    }




}
