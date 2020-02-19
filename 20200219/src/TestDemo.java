public class TestDemo {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        testBinaryTree.insert(15);
        testBinaryTree.insert(4);
        testBinaryTree.insert(18);
        testBinaryTree.insert(22);
        testBinaryTree.insert(6);

        testBinaryTree.InOrder(testBinaryTree.root);
    }
}
