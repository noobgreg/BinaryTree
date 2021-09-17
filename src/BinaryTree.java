import java.util.function.Consumer;

public class BinaryTree<T> {

    Node root; // Startknoten des Baumes

    class Node { // Unterklasse Knoten, welches data und zeiger auf die Kinder enthält
        T data; // data
        Node left, right; // Kinder links und rechts

        Node(T data) { // Konstruktor, mit dem ein Knotenelement erzeugt wird, welches data enthält
            this.data = data;
            left = null;
            right = null;
        }
    }

    public BinaryTree() { // Konstruktor, der einen leeren Baum erzeugt(wurzel==null)
        root = new Node(null);
    }
    // Konstruktor, der einen Knoten mit zwei Kindern erzeugt
    public BinaryTree(T e, BinaryTree left, BinaryTree right) {
        root = new Node(e);
        this.root.left = left != null ? left.root : null; // wenn left nicht null dann ists left.root
        this.root.right = right != null ? right.root : null;
    }

    public BinaryTree(T wurzel) { // Konstruktor, der der Wurzel data übergibt
        this.root.data = wurzel;
    }

    public boolean isEmpty() { // Methode, die einen boolean Wert liefert, ob der Baum leer ist oder nicht
        return root.data == null;
    }

    public int hoehe() { // Methode, die die Höhe des Baumes liefert
        return hoehe(root);
    }

    private int hoehe(Node node) { // Hilfsmethode zu Höhe()
        return node == null ? 0 : Math.max(hoehe(node.right), hoehe(node.left)) + 1;
    }

    public int size() { // Methode, die die Größe des Baumes liefert
        return size(root);
    }

    private int size(Node k) { // Hilfsmethode zu size()
        return k == null ? 0 : size(k.left) + size(k.right) + 1;
    }

    private void add(Node node, T value) { // Methode die einem Knoten einen Inhalt hinzufügt
        if (node.left == null) {
            node.left = new Node(value);
            return;
        } else if (node.right == null) {
            node.right = new Node(value);
            return;
        }

    }

    private void traverse(Node node, Consumer<T> preorder, Consumer<T> inorder, Consumer<T> postorder) {
        if(node == null) return;

        if(preorder != null) preorder.accept(node.data);
        traverse(node.left, preorder, inorder, postorder);
        if(inorder != null) inorder.accept(node.data);
        traverse(node.right, preorder, inorder, postorder);
        if(postorder != null) postorder.accept(node.data);
    }

    public void preorder(Consumer<T> cons) {
        traverse(root, cons, null, null);
    }

    public void inorder(Consumer<T> cons) {
        traverse(root, null, cons, null);
    }

    public void postorder(Consumer<T> cons) {
        traverse(root, null, null, cons);
    }

    public void preorder() {
        preorder(t -> System.out.print(t + " "));
    }

    public void inorder() {
        inorder(t -> System.out.print(t + " "));
    }

    public void postorder() {
        postorder(t -> System.out.print(t + " "));
    }

    public String myToString() {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        myToString(sb, root.right, false, "");
        sb.append(root.data).append('\n');
        myToString(sb, root.left, true, "");

        return sb.toString();
    }

    private void myToString(StringBuilder sb, Node n, boolean left, String indent) {
        if(n == null) return;

        myToString(sb, n.right, false, indent + (left ? "│   " : "    "));

        sb.append(indent).append(left ? "└── " : "┌── ");
        sb.append(n.data).append('\n');

        myToString(sb, n.left, true, indent + (left ? "    " : "│   "));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        traverse(root, t -> sb.append('('), sb::append, t -> sb.append(')'));

        return sb.toString();
    }
    public Node newNode(T data) {
        return new Node(data);
    }

}
