package tree.simple;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Класс представляющий дерево
 */
public class Tree {
    private Node root;

    /**
     * @return корневой элемент дерева
     */
    Node getRoot() {
        return root;
    }

    public Tree() {
        root = null;
    }

    public Tree(Node root) {
        this.root = root;
    }

    /**
     * Поиск элемента по {@param key}
     *
     * @param key ключ
     * @return найденный узелп
     */
    public Node find(int key) {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.key != key) {
            if (key < current.key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * Вставка пары {@param key} {@param value} в дерево
     *
     * @param key   ключ
     * @param value значение
     */
    public void insert(int key, int value) {
        insert(new Node(key, value));
    }

    /**
     * Вставка ноды в дерево
     *
     * @param newNode нода
     */
    public void insert(Node newNode) {
        //Корневого узла нет
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (newNode.key < current.key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Удаление элемента по {@param key}
     *
     * @param key ключ
     * @return признак успешности удаления
     */
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        //поиск удаляемого узла
        while (current.key != key) {
            parent = current;

            if (key < current.key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }

        //удаление узла не имеющего потомков
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        //если нет правого потомка, узел заменяется левым поддеревом
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        //если нет левого потомка, узел заменяется правым поддеревом
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        //удаляемый узел имеет двух потомков
        else {
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }

            //приемник связывается с левым потомком current
            successor.leftChild = current.leftChild;
        }

        return true;
    }

    /**
     * Выполнить обход дерева
     *
     * @param traverseType тип выполняемого обхода
     */
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
    }

    /**
     * Поиск приемника для удаляемого узла
     *
     * @param delNode удаляемый узел
     * @return узел приемник
     */
    Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; //переход к правому потомку
        //пока есть левые потомки
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild; //переход к левому потомку
        }

        //если приемник не является правым потомком
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    /**
     * Прямой обход дерева
     *
     * @param localRoot корневой элемент
     */
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.key + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    /**
     * Симметричный обход дерева
     *
     * @param localRoot корневой элемент
     */
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.key + " ");
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * Обратный обход дерева
     *
     * @param localRoot корневой элемент
     */
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.key + " ");
        }
    }

    /**
     * Вывод содержимого дерева
     */
    public String displayTree() {
        return displayTree(false);
    }

    /**
     * Вывод содержимого дерева
     *
     * @param needCharOutput признак вывода элементов дерева в виде символов
     */
    public String displayTree(boolean needCharOutput) {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("................................................................\n");
        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++) {
                stringBuilder.append(" ");
            }

            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    stringBuilder.append(needCharOutput ? Character.toString((char) temp.key) : temp.key);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    stringBuilder.append("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int i = 0; i < nBlanks * 2 - 2; i++) {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
            nBlanks /= 2;

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Программный проект 8.1 - Program project 8.1
     * Программный проект 8.2 - Program project 8.2
     * <p>
     * Создать двоичное дерево из символов введенных пользователем
     *
     * @param inputChars строка содержащая символы
     * @return созданное двоичное дерево
     */
    static Tree makeTreeFromUserChars(String inputChars) {
        java.util.Deque<Tree> treeDeque = new ArrayDeque<>();

        //создание ДЭКа содержащего лес трехузловых деревьев
        char[] chars = inputChars.toCharArray();
        Node tempNode = new Node('+', '+');
        int counter = 0;
        while (counter < chars.length) {
            if (tempNode.leftChild == null) {
                tempNode.leftChild = new Node(chars[counter], chars[counter]);

                if (++counter >= chars.length) {
                    Tree smallTree = new Tree();
                    smallTree.insert(tempNode);
                    treeDeque.add(smallTree);
                }
            } else if (tempNode.rightChild == null) {
                tempNode.rightChild = new Node(chars[counter], chars[counter]);
                if (++counter >= chars.length) {
                    Tree smallTree = new Tree();
                    smallTree.insert(tempNode);
                    treeDeque.add(smallTree);
                }
            } else {
                Tree smallTree = new Tree();
                smallTree.insert(tempNode);
                treeDeque.add(smallTree);

                tempNode = new Node('+', '+');
            }
        }

        return makeTree(treeDeque);
    }

    /**
     * Программный проект 8.2 - Program project 8.2
     * <p>
     * Создать полное двоичное дерево из символов введенных пользователем
     *
     * @param inputChars строка содержащая символы
     * @return созданное двоичное дерево
     */
    static Tree makeFullTreeFromUserChars(String inputChars) {
        return makeFullTree(inputChars.toCharArray(), null, 0);
    }

    /**
     * Рекурсивное построение полного дерева
     *
     * @param chars            массив символов
     * @param rootNode         ссылка на корневую ноду
     * @param rootNodePosition позиция корневой ноды в массива
     * @return построенное дерево
     */
    private static Tree makeFullTree(char[] chars, Node rootNode, int rootNodePosition) {
        if (chars.length == 0) {
            return null;
        }

        Node node;
        Character character;
        Tree tree;
        if (rootNode == null) {
            character = chars[rootNodePosition];
            node = new Node(character, character);
        } else {
            node = rootNode;
        }

        //создание левой ноды
        int leftNodePosition = rootNodePosition * 2 + 1;
        if (chars.length <= leftNodePosition) {
            return new Tree(node);
        } else {
            node.leftChild = new Node(chars[leftNodePosition], chars[leftNodePosition]);
        }

        //создание правой ноды
        int rightNodePosition = rootNodePosition * 2 + 2;
        if (chars.length <= rightNodePosition) {
            return new Tree(node);
        } else {
            node.rightChild = new Node(chars[rightNodePosition], chars[rightNodePosition]);
        }

        tree = new Tree(node);

        //создание потомков для левой ноды
        Tree leftSubTree = makeFullTree(chars, tree.root.leftChild, leftNodePosition);
        if (leftSubTree == null) {
            return new Tree(node);
        }
        node.leftChild = leftSubTree.root;

        //создание потомков для правой ноды
        Tree rightSubTree = makeFullTree(chars, tree.root.rightChild, rightNodePosition);
        if (rightSubTree == null) {
            return new Tree(node);
        }
        node.rightChild = rightSubTree.root;

        return tree;
    }

    /**
     * Объединение леса трехуровневых деревьев в одно дерево
     *
     * @param treeDeque ДЭК содержащий лес трехуровневых деревьев
     * @return построенное дерево
     */
    private static Tree makeTree(java.util.Deque<Tree> treeDeque) {
        if (treeDeque.size() == 1) {
            return treeDeque.poll();
        }

        Node tempNode = new Node('+', '+');
        while (treeDeque.size() != 0) {
            if (tempNode.leftChild == null) {
                tempNode.leftChild = treeDeque.poll().root;
                if (treeDeque.size() == 0) {
                    Tree mediumTree = new Tree();
                    mediumTree.insert(tempNode);
                    treeDeque.addLast(mediumTree);
                    break;
                }
            } else if (tempNode.rightChild == null) {
                tempNode.rightChild = treeDeque.poll().root;
                if (treeDeque.size() == 0) {
                    Tree mediumTree = new Tree();
                    mediumTree.insert(tempNode);
                    treeDeque.addLast(mediumTree);
                    break;
                }
            } else {
                Tree mediumTree = new Tree();
                mediumTree.insert(tempNode);
                treeDeque.addLast(mediumTree);

                tempNode = new Node('+', '+');
            }
        }
        return treeDeque.poll();
    }
}