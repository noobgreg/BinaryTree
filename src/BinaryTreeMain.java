public class BinaryTreeMain {


        //BinaryTree<Integer> binBaum = new BinaryTree<>(1);
        public static void main(String[] args) {
            BinaryTree<Integer> a = new BinaryTree<>();

            BinaryTree<Integer> b = new BinaryTree<>(1, new BinaryTree<>(2, new BinaryTree<>(4, null, null), new BinaryTree<>(5, null, null)),
                    new BinaryTree<>(3, new BinaryTree<>(6, null, null), new BinaryTree<>(7, null, null)));

            System.out.println(b);
            b.preorder();
            System.out.println();
            b.inorder();
            System.out.println();
            b.postorder();
            System.out.println();

            System.out.println(b.myToString());
            System.out.println(b.isEmpty());
            System.out.println(a.myToString());
        }

    }