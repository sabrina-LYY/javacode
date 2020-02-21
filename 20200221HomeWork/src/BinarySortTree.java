public class BinarySortTree {
    static class Node {
        private int data;
        private Node left;
        private Node right;


        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node root = null;

        public boolean insert(int key) {
            Node node = new Node(key);
            if (root == null) {
                root = node;
                return true;
            }
            Node cur = root;
            Node parent = null;
            while (cur != null) {
                if (cur.data == key) {
                    return false;
                } else if (cur.data > key) {
                    parent = cur;
                    cur = cur.left;
                } else {
                    parent = cur;
                    cur = cur.right;
                }
            }
            //cur就是要插入的位置
            if (parent.data > key) {
                parent.left = node;
            } else if (parent.data < key) {
                parent.right = node;
            }
            return true;
        }

        public Node Research(int key) {
            Node cur = root;
            while (cur != null) {
                if (cur.data == key) {
                    return cur;
                } else if (cur.data > key) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            return null;
        }

        public void Remove(int key) {
            Node cur = root;
            Node parent = null;
            while (cur != null) {
                if (cur.data == key) {
                    //找到要删除的结点
                    RemoveNode(parent, cur);
                    return;
                } else if (cur.data > key) {
                    parent = cur;
                    cur = cur.left;
                } else {
                    parent = cur;
                    cur = cur.right;
                }
            }
        }

        //进行删除
        public void RemoveNode(Node parent, Node cur) {
            if (cur.left == null) {
                if (cur == root) {
                    root = cur.right;
                } else if (cur == parent.left) {
                    parent.left = cur.right;
                } else {
                    parent.right = cur.left;
                }
            } else if (cur.right == null) {
                if (cur == root) {
                    root = cur.left;
                } else if (cur == parent.left) {
                    parent.left = cur.left;
                } else {
                    parent.right = cur.left;
                }
            } else {
                Node targetParent = cur;
                Node target = cur.right;
                //右边找最小值
                while (target.left != null) {
                    targetParent = target;
                    target = target.left;
                }
                cur.data = target.data;

                if (target == targetParent.left) {
                    targetParent.left = target.right;
                } else {
                    targetParent.right = target.left;
                }
            }

        }
    }

}

