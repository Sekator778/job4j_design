package tree.simple;

/**
 * @author Sekator  : mail sekator778@gmail.com
 * Класс представляющий узел дерева
 */
public class Node {
    public int key;
    public int value;
    Node leftChild;
    Node rightChild;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    void displayNode() {
        System.out.println(String.format("{%s,%s}", key, value));
    }
}