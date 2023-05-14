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
    public Node insert(int id) {
        Node node = new Node(id);

        if (root == null) { // when there is no root
            root = node;
            return root;
        } else {  // when root exists
            Node current = root;

            while (true) {
                if (id < current.iData) { // left child
                    if (current.left == null) {
                        current.left = node;
                        return root;
                    } else {
                        current = current.left;
                    }
                } else if (id > current.iData) { // right child
                    if (current.right == null) {
                        current.right = node;
                        return root;
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

    /**
     * Traverse to the right child until find a right child node
     * with no right child.
     *
     * @param root - root of the binary search tree
     * @return node whose does not have any right child.
     */
    Node findMaximumNode(Node root) {
        Node current, last = null;
        current = root;

        while (current != null) {
            last = current;
            current = current.right;
        }
        return last;
    }

    /**
     * Traverse to the left child until find a left child node
     * with no left child.
     *
     * @param root - root of the binary search tree
     * @return node whose does not have any left child.
     */
    Node findMinimumNode(Node root) {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.left;
        }

        return last;
    }

    /**
     * In case of deletion of a node from a BST, the following three cases to consider:
     * 1. The node to be deleted is a leaf (has no children).
     * 2. The node to be deleted has one child.
     * 3. The node to be deleted has two child.
     *
     * @param key - the node value which need to be deleted.
     * @return true - when delete is successful
     * false - when delete is unsuccessful
     */
    boolean deleteNode(int key) { // delete node with given key

        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;

            if (key < current.iData) { // go left side of the BST
                isLeftChild = true;
                current = current.left;
            } else {                      // go right side of the BST
                isLeftChild = false;
                current = current.right;
            }

            if (current == null) { // did not find the node with the given key
                return false;
            }
        }

        // when node does not have any leaf node (no children)
        if (current.left == null && current.right == null) {

            if (current == root) { // if the node is root
                root = null; // tree is empty
            } else if (isLeftChild) { // disconnect this left child from parent.
                parent.left = null;
            } else {                  // disconnect this right child from parent.
                parent.right = null;
            }
        } else if (current.right == null) { // left subtree exits of deleted node
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) { // right subtree exist of deleted node
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else { // when deleted node has both children. (left subtree & right subtree)
            Node successorNode = getSuccessor(current);

            if (current == root) {
                root = successorNode;
            } else if (isLeftChild) {
                parent.left = successorNode;
            } else {
                parent.right = successorNode;
            }

            successorNode.left = current.left;
        }
        return true;
    }

    /**
     * When one node has both children then the successor of the node will be
     * the most left node of the right subtree of the node.
     *
     * @param delNode - the node whose successor will be found
     * @return return the successor node
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode; // reference of parent of successor
        Node successor = delNode; // reference of successor

        // right child of deleted node when deleted node has both children
        Node current = delNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        // when successor of delete node does not equal to the right node of delete node.
        //   o -- deleted node
        //  / \
        // o   o -- right child of deleted node
        //    / \
        //   o   o

        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }

        return successor;
    }

}
