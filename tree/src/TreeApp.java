public class TreeApp {

    public static void main(String[] args) {
        Tree tree = new Tree(); // create a tree

        tree.insert(50);    // insert 3 nodes in the tree
        tree.insert(25);
        tree.insert(75);
        tree.insert(70);
        tree.insert(100);
        tree.insert(80);
        tree.insert(65);
        tree.insert(110);
        tree.insert(85);

        Node findResult = tree.find(25);

        if (findResult != null) {
            System.out.println("Found the node with key 25");
        } else {
            System.out.println("Could not find node with key 25");
        }

        // inorder traversal
        System.out.println("\nInorder traversal:");
        Node t = tree.getTree();
        tree.inOrderTraversal(t);

        System.out.println("\nPreorder traversal");
        // preorder traversal
        tree.preOrderTraversal(t);

        System.out.println("\nPostorder traversal");
        // postorder traversal
        tree.postOrderTraversal(t);

        System.out.println("\nMaximum Node from the BST: " + tree.findMaximumNode(t).iData);
        System.out.println("Minimum Node from the BST: " + tree.findMinimumNode(t).iData);

        tree.deleteNode(80);

        tree.inOrderTraversal(tree.getTree());
    }
}
