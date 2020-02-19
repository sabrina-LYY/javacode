public class TestBinaryTree {
    class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public Node root = null;
    public void insert(int key){
        Node cur = root;
        Node parent = root;
        Node node = new Node(key);
        if(root == null){
            root = node;
        }

        while(cur!=null){
            if(cur.left.data<key){//在右树
                parent = cur;
                cur = cur.right;
            }else if(cur.left.data>key){
                parent = cur;
                cur = cur.left;
            }else{
                return;
            }
        }
        if(parent.data<key){
            parent.right = node;
        }else{
            parent.left = node;
        }
        return;
    }

    //查找key
    public Node search(int key){
        Node cur = root;
        while(cur!=null){
            if(cur.left.data>key){
                cur = cur.right;
            }else if(cur.left.data <key){
                cur = cur.right;
            } else{
            return cur;
        }
    }
    return null;
    }

    public void InOrder(Node root){
        if(root !=null){
            InOrder(root.left);
            System.out.println(root.data);
            InOrder(root.right);
        }
    }

    public void PreOrder(Node root){
        if(root !=null){
            System.out.println(root.data);
            InOrder(root.left);
            InOrder(root.right);
        }
    }

    //删除关键字为KEY的节点
    public void remove(int key){
        Node cur = root;
        Node parent = null;

        while(cur !=null){
            if(cur.data == key){
                //找到要删除的节点
                RemoveNode(parent,cur);
                return;
            }else if(cur.data<key){
                parent = cur;
                cur = cur.right;
            }else{
                parent = cur;
                cur = cur.left;
            }
        }
    }

    public void RemoveNode(Node parent,Node cur){
        if(cur.left == null){//只有右树
            if(cur==root){
                root = cur.right;

            }else if(cur == parent.left){//删除左树中间结点
                parent.left = cur.right;
            }else{//删除右树中间结点
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur==root){
                root = cur.left;
            }else if(cur == parent.right){
                parent.right = cur.left;
            }else{
                parent.left = cur.left;
            }

        }else{//左右都不为空
            Node targetParent = cur;//要删除的节点的父亲节点--》替罪羊的父亲
            //从右边找最小值
            Node target = cur.right;
            while(target.left!=null){
                targetParent = target;
                target = target.left;
            }
            cur.data = target.data;

            //target左为空
            //target只有右
            if(target == targetParent.left){
                targetParent.left = target.right;
            }else{
                targetParent.right = target.right;
            }

        }
    }
}
