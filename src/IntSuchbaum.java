import java.util.NoSuchElementException;

public class IntSuchbaum extends BinaryTree<Integer> {
    public IntSuchbaum() {
        super();
    }

    public IntSuchbaum(int value) {
        super(value);
    }

    public void insert(int i) {
        if (root.data == null) {
            root.data = i;
            return;
        }
        if (contains(i)) {
            throw new IllegalArgumentException();
        }
        insert(root, i);
    }

    private Node insert(Node node, int i) {
        if (node == null) {
            return newNode(i);
        }
        if (i < node.data) {
            node.left = insert(node.left, i);
        }
        if (i > node.data) {
            node.right = insert(node.right, i);
        }
        return node;
    }

    public boolean contains(int i) {
        if (root == null) {
            return false;
        }
        if (root.data == i) {
            return true;
        }
        return contains(root, i);
    }

    private boolean contains(Node node, int i) {
        if (node == null) {
            return false;
        }
        if (i > node.data) {
            return contains(node.right, i);
        } else if (i < node.data) {
            return contains(node.left, i);
        } else {
            return true;
        }
    }

    public void remove(int i) {
        if (!contains(i)) {
            throw new NoSuchElementException();
        }
        root = remove(root, i);
    }

    private Node remove(Node node, int i) {
        if (root == null) {
            return node;
        }
        if (i < node.data) {
            node.left = remove(node.left, i);
        } else if (i > node.data) {
            node.right = remove(node.right, i);
        }

        else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node temp = node.left;
            node = node.right;
            smallestNode(node).left = temp;
        }
        return node;

    }

    private Node smallestNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public String toString() {
        return super.toString();
    }
}