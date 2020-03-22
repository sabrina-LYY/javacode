public class BinaryTree {
    //左树为空，右边不为空，右边的第一个结点就是祖先
    //右边为空，左边不为空，左边的第一个结点就是祖先
    //代码根据前序遍历来写

    //左树为空，右边不为空，右边的第一个结点就是祖先
    //右边为空，左边不为空，左边的第一个结点就是祖先
    //代码根据前序遍历来写

    /*class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        //开始以前序遍历查找
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);
        //三种情况：1.都在左树，2.都在右树，3.一个在左树一个在右sh
        if(leftTree !=null && rightTree!=null){
            return root;
        }
        if(leftTree !=null){
            return leftTree;
        }
        if(rightTree != null){
            return rightTree;
        }
        return null;
    }*/

    //5. 根据一棵树的前序遍历与中序遍历构造二叉树。
    //没有中序遍历是不能构造二叉树的
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    int preIndex = 0;
    public TreeNode buildTreeChild(int[] preorder,int[] inorder,int inbegin,int inend){
        if(inbegin >inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找ROOT在中序遍历的下标
        int rootIndex = findIndexOfInorder(inorder,inbegin,inend,preorder[preIndex]);
        preIndex++;

        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);
        return root;
    }

    public int findIndexOfInorder(int[] inorder,int inbegin,int inend,int val) {
        for(int i = inbegin;i<=inend;i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder==null){
            return null;
        }
        if(preorder.length ==0 || inorder.length == 0){
            return null;
        }
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }


    //5. 根据一棵树的后序遍历与中序遍历构造二叉树。
    public int postIndex = 0;
    public TreeNode buildTreeChild1(int[] inorder,int[] postorder,int inbegin,int inend){
        if(inbegin>inend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        //找root在中序的下标
        int rootIndex = findIndexOfInorder2(inorder,inbegin,inend,postorder[postIndex]);
        postIndex--;

        root.right = buildTreeChild1(inorder,postorder,rootIndex+1,inend);
        root.left = buildTreeChild1(inorder,postorder,inbegin,rootIndex-1);
        return root;
    }

    public int findIndexOfInorder2(int[] inorder,int inbegin,int inend,int val){
        for(int i = inbegin;i<=inend;i++ ){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
    public TreeNode build2Tree(int[] inorder,int[] postorder){
        if(postorder == null || inorder == null){
            return null;
        }
        if(postorder.length == 0 || inorder.length == 0){
            return null;
        }

        postIndex = postorder.length-1;
        return buildTreeChild1(inorder,postorder,0,inorder.length-1);
    }


    //二叉树创建字符串
    public void tree2strChild(TreeNode t , StringBuilder str){
        if(t == null){
            return;
        }
        while(t != null){
            str.append(t.val);
            if(t.left == null){
                if(t.right == null){
                    return;
                }else{
                    str.append("()");
                }
            }else{
                str.append("(");
                tree2strChild(t.left,str);
                str.append(")");
            }
            //以上递归前t的位置
            if(t.right == null){
                return;
            }else{
                str.append("(");
                tree2strChild(t.right,str);
                str.append(")");
            }
        }
    }
    public String tree2str(TreeNode t) {
        StringBuilder str = new StringBuilder();
        tree2strChild(t,str);
        return str.toString();
    }


    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
    }
	
	
}