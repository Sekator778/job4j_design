package tree;

import java.util.*;

/**
 * простое дерево
 * тут интерес в классе Optional и его методах
 *
 * @param <E>
 */
public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * добавляем елемент если нету
     * В этом методе нужно проверить,
     * что значений parent и child еще нет в дереве.
     * Если они есть, то метод должен вернуть false.
     *
     * @param parent parent
     * @param child  child
     * @return result
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parents = findBy(parent);
        if (parents.isEmpty()) {   // if a value is  not present, returns TRUE если есть парент то фолс некуда прилепить чайлда
            return false;
        }
        Optional<Node<E>> childrens = findBy(child);
        if (childrens.isPresent()) {  // If a value is present, returns true  если есть уже чайлд то наш код дубль не принимает
            return false;
        }
        parents.get().add(new Node<>(child));  // прикольно даем чтобы добавить)
        return true;
    }

    /**
     * поиск в ширину BFS
     * в очередь добавляем весь лист rootA и так далее
     * не совсем понимаю почему тут возвращать надо опшионал
     * наверно для удобства работы с ним в методе адд
     *
     * @param value - искомый елемент
     * @return object optional
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.add(this.root);            // добавили корень
        while (!data.isEmpty()) {       // если чтото есть внем то го
            Node<E> el = data.poll();    // извлекаем из очереди по 1му
            if (el.getValue().equals(value)) {  // проверяем или подходит нам его значение
                rsl = Optional.of(el); // create optional
                break;
            }
            data.addAll(el.getChildren());  // добавляем всех деток текущего узла
        }
        return rsl;
    }

    /**
     * @return result true if every nod our tree have 0 or 2 child
     */
    public boolean isBinary() {
        NodeIterator iterator = new NodeIterator();
        while (iterator.hasNext()) {
            int countChild = iterator.next().getChildren().size();
            if (countChild != 2 && countChild != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * итератор для дерева
     * @return елемент узла
     */
    @Override
    public Iterator<E> iterator() {
        return new ValueIterator();
    }

    /**
     * итератор по узлам дерева
     * создаем итератор сразу с очередью из рутовского нода
     * если берем узлы то и возвращаем узлы
     */
    private class NodeIterator implements Iterator<Node<E>> {
        private final Queue<Node<E>> nodes = new LinkedList<>();

        public NodeIterator() {
            this.nodes.add(root);
        }

        @Override
        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        /**
         * принцып похож на метод файнд
         * токо вытаскиваем нода remove так как там может уже и не быть ничего
         * то remove не прервет ход выполнения если будет емпи то вернет нулл
         * @return next node if this present
         */
        @Override
        public Node<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> temp = nodes.remove();
            nodes.addAll(temp.getChildren());
            return temp;
        }
    }

    /**
     * класс обертка над нодовским итератором
     * дает значение узла
     */
    private class ValueIterator implements Iterator<E> {
        private final NodeIterator nodeIterator = new NodeIterator();

        @Override
        public boolean hasNext() {
            return nodeIterator.hasNext();
        }

        @Override
        public E next() {
            return nodeIterator.next().getValue();
        }
    }
}