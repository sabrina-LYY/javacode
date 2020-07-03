import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;
}
public class BinaryTree {

    //判断对称二叉树
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        if(leftTree==null && rightTree==null){
            return true;
        }
        if(leftTree==null && rightTree!=null || leftTree!=null && rightTree==null){
            return false;
        }
        if(leftTree.val !=rightTree.val){
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right) &&
                isSymmetricChild(leftTree.right,rightTree.left);
    }

    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }



    //层序遍历
    //使用队列
    public void levelOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur!=null){
                System.out.print(cur.val+"　");
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
        }
    }


    //层序遍历
    public List<List<Character>> levelOrder(TreeNode root){
        List<List<Character>> ret = new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while(size>0){
                TreeNode cur = queue.poll();
                size--;
                if(cur!=null){
                    list.add(cur.val);
                    if(cur.left!=null){
                        queue.offer(cur.left);
                    }
                    if(cur.right!=null){
                        queue.offer(cur.right);
                    }
                }
            }
         ret.add(list);
        }
        return ret;
    }

    //判断一棵树是否是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode>queue = new LinkedList<>();
        if(root==null){
            return true;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.peek();
            if(cur!=null){
                return false;
            }else{
                queue.poll();
            }
        }
        return true;
    }


    //二叉树最近公共祖先问题
    public TreeNode lowestCommonAncester(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncester(root.left,p,q);
        TreeNode right = lowestCommonAncester(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }
        return null;
    }


    //输入一颗二叉搜索树，将其转换成一个排序的双向链表
    TreeNode prev = null;
    public void ConvertChild(TreeNode pCur){
        if(pCur==null){
            return;
        }
        ConvertChild(pCur.left);
        prev.right = pCur;
        while(prev!=null){
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree){
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while(head!=null && head.left!=null){
            head=head.left;
        }
        return head;
    }

}

