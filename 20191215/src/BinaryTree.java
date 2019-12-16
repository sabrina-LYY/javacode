
class TreeNode{
    char value;
    TreeNode left;
    TreeNode right;
    public TreeNode(char value){
        this.value = value;
    }
}
public class BinaryTree {
    public BinaryTree(){

    }
    public TreeNode buildTree(){
        TreeNode root = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H= new TreeNode('H');
        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return root;
    }

    // 前序遍历
    void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }

    //后序遍历
    void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }


    /*//OJ中序遍历
    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> list1 = inOrderTraversal(root.left);
        list.addAll(list1);
        System.out.print(root.val+" ");
        list.add(root.val);
        List<Integer> list2 = inOrderTraversal(root.right);
        list.addAll(list2);
        return list;
    }

    //OJ后序遍历
    public void postOrderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> list1 = inOrderTraversal(root.left);
        list.addAll(list1);
        List<Integer> list2 = inOrderTraversal(root.right);
        list.addAll(list2);
        System.out.print(root.val+" ");
        list.add(root.val);
        return list;
    }*/

    // 遍历思路-求结点个数(左子树的结点个数加上右子树的结点个数和自己本身)
    static int size = 0;
    public void getSize1(TreeNode root){
        if(root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    public int getSize2(TreeNode root){
        if(root ==null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;//后序遍历法
    }


    // 子问题思路-求叶子结点个数
    public int getLeafSize2(TreeNode root){
        if(root ==null){
            return 0;
        }else if(root.left==null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    public void getLeafSize1(TreeNode root){
        if(root ==null){
            return;
        }else if(root.left==null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }


    // 子问题思路-求第 k 层结点个数(如果求A得第K层，相当于左的K-1层+右的K-1层)
    public int getKLevelSize(TreeNode root,int k){
        if(root == null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    TreeNode find(TreeNode root, int val){
        //前序遍历的形式查找
        if(root==null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        TreeNode ret = find(root.left,val);
        if(ret!=null){
            return ret;
        }
        ret = find(root.right,val);
        if(ret!=null){
            return ret;

        }
        return null;
    }

    //4. 检查两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q !=null || p!=null && q == null){
            return false;
        }
        if(p==null && q == null){
            return true;
        }
        if(p.value!=q.value){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //5. 另一颗树的子树。OJ链接
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null || t == null){
            return false;
        }

        if(isSameTree (s,t)){
            return true;
        }
        if(isSubtree(s.left,t) ){
            return true;
        }
        if(isSubtree(s.right,t)){
            return true;
        }
        return false;
    }
}
