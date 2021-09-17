import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree<Integer> b = new BinaryTree<>(1, new BinaryTree<>(2, new BinaryTree<>(4, null, null), new BinaryTree<>(5, null, null)),
            new BinaryTree<>(3, new BinaryTree<>(6, null, null), new BinaryTree<>(7, null, null)));
    BinaryTree<Integer> a = new BinaryTree<>();

    @Test
    void isEmpty() {
        assertEquals(false, b.isEmpty());
        assertEquals(true, a.isEmpty());
    }

    @Test
    void hoehe() {
        assertEquals(3, b.hoehe());
        assertEquals(1, a.hoehe());

    }

    @Test
    void size() {
        assertEquals(7, b.size());
        assertEquals(1, a.size());
    }

    @Test
    void testToString() {

    }

}