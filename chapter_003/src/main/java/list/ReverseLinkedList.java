package list;

/**
 * @author Sekator  : mail sekator778@gmail.com
 */

public class ReverseLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (char c = 'A'; c <= 'B'; c++) {
            list.append(c);
        }

        System.out.println(list.toString());
        list.reverse();
        System.out.println(list.toString());
    }

    static class Node {
        Node next;
        char value;

        Node(char value) {
            this.value = value;
        }
    }

    static class MyLinkedList {
        Node head = new Node('0');

        public void append(char value) {
            Node n = new Node(value);
            Node tmp = head;
            if (head == null) {
                head = n;
            } else {
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = n;
            }
        }

        public void reverse() {
            if (head.next == null) {
                return;
            }
            Node temp = head.next;
            head.next = null;
            while (temp != null) {
                Node next = temp.next;
                temp.next = head.next;
                head.next = temp;
                temp = next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("MyLinkedList[");
            for (Node i = head.next; i != null; i = i.next) {
                sb.append("'").append(i.value).append("'");
                if (i.next != null) {
                    sb.append(" -> ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
