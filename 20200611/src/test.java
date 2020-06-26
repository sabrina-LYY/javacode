import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}

public class test {

    //二叉树前序遍历,注意返回值
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        list.add(root.val);
        List<Integer> leftlist = preorderTraversal(root.left);
        list.addAll(leftlist);
        List<Integer> rightList = preorderTraversal(root.right);
        list.addAll(rightList);
        return list;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        List<Integer> list1=postorderTraversal(root.left);
        list.addAll(list1);
        List<Integer> list2 = postorderTraversal(root.right);
        list.addAll(list2);
        list.add(root.val);

        return list;
    }

    //判断两棵树是否相同
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&& q!=null||p!=null && q==null){
            return false;
        }
        if(p==null && q==null){
            return true;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSubTree(TreeNode s,TreeNode t){
        if(s==null || t==null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        if(isSubTree(s.left,t)){
            return true;
        }
        if(isSubTree(s.right,t)){
            return true;
        }
        return false;
    }


    //判断是不是平衡二叉树
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHight=maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHight>rightHeight?leftHight+1:rightHeight+1;
    }
    public boolean isBalance(TreeNode root){
        if(root==null){
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

       return Math.abs(leftHeight-rightHeight)<2 &&isBalance(root.left) && isBalance(root.right);
    }
}
