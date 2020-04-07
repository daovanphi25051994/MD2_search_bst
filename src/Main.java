public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(3);
        tree.insert(5);
        tree.insert(8);
        tree.insert(2);
        tree.insert(0);
//        System.out.println("Inorder (sorted): ");
//        tree.inOrder();
//        System.out.println();
//        System.out.println("PreOrder (sorted): ");
//        tree.preOrder();
//        System.out.println();
//        System.out.println("PostOrder (sorted): ");
//        tree.posOrder();
//        System.out.println();
//        System.out.println("The number of nodes is: " + tree.getSize());
//        System.out.println(tree.find(tree.root, "George"));
     //   System.out.println(tree.remove(tree.root, "Tom"));
        tree.remove(tree.root, 2);
        System.out.println("Inorder (sorted): ");
        tree.inOrder();
    }
}

