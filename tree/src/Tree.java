public class Tree {

    private Node root;

    /**
     * @return - return the tree else return null if it is empty.
     */
    public Node getTree() {
        if (!isTreeEmpty()) {
            return root;
        }

        System.out.println("Tree is empty");
        return null;
    }

    private boolean isTreeEmpty() {
        return root == null;
    }

    /**
     * Find the key from a given binary tree
     * by using binary search algorithm
     *
     * @param key - the key which needs to search
     * @return return the node when it will find else
     * return null
     */
    public Node find(int key) {
        Node current = root;

        while (current != null) { // when root exists
            if (current.iData == key) {
                return current;
            }

            if (key < current.iData) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    /**
     * Insert the element/node in right place by traversing the binary tree
     * and using binary search algorithm
     *
     * @param id the element which needs to insert in the binary tree
     */
    public void insert(int id) {
        Node node = new Node(id);

        if (root == null) { // when there is no root
            root = node;
        } else {  // when root exists
            Node current = root;

            while (true) {
                if (id < current.iData) {
                    if (current.left == null) {
                        current.left = node;
                        return;
                    } else {
                        current = current.left;
                    }
                } else if (id > current.iData) {
                    if (current.right == null) {
                        current.right = node;
                        return;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    /**
     * Delete the element/node from the binary tree by implementing
     * binary search algorithm
     *
     * @param id - the element which is needed to delete from the binary tree
     */
    public void delete(int id) {

    }

    /**
     * An inorder traversal of a binary search tree
     * causes all the nodes to be visited in ascending order
     *
     * @param tree - the binary which will be traversed as inorder approach.
     */
    public void inOrderTraversal(Node tree) {

        if (tree != null) {
            inOrderTraversal(tree.left);
            System.out.print(tree.iData + " ");
            inOrderTraversal(tree.right);
        }
    }

    /**
     * The following is the step to obey preorder traversal rule while using recursion
     * <p>
     * 1. visit the node (print it)
     * 2. call itself to traverse the node's left subtree
     * 3. call itself to traverse the node's right subtree
     *
     * @param tree - the tree on which preorder traversal will be done.
     */
    public void preOrderTraversal(Node tree) {
        if (tree != null) {
            System.out.print(tree.iData + " ");
            preOrderTraversal(tree.left);
            preOrderTraversal(tree.right);
        }
    }

    /**
     * The following is the steps to obey for postorder traversal rule while using recursion
     * <p>
     * 1. call itself to traverse the node's left subtree
     * 2. call itself to traverse the node's right subtree
     * 3. visit the node (print the node)
     *
     * @param tree - the binary search tree on which postorder traversal will be done.
     */
    public void postOrderTraversal(Node tree) {
        if (tree != null) {
            postOrderTraversal(tree.left);
            postOrderTraversal(tree.right);
            System.out.print(tree.iData + " ");
        }
    }

}
