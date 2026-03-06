
package list;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(T data) {
            this(data, null);
        }

        @Override
        public String toString() {
            if (data == null) {
                return "null";
            } else {
                return data.toString();
            }
        }
    }

    private int size;

    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        this.size = 0;
        head = new Node<T>(); // dummy head node
        tail = head;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void addLast(T element) {

        // step 1
        Node<T> newNode = new Node<>(element);

        // step 2
        tail.next = newNode;

        // step 3
        tail = newNode;

        // step 4
        size++;

    }

    public void swapPairs() {

        if (size <= 1) {
            return;
        }

        Node<T> cur = head;

        while (cur.next != null && cur.next.next != null) {
            Node<T> temp1 = cur.next;
            Node<T> temp2 = cur.next.next;
            cur.next = temp2;
            temp1.next = temp2.next;
            temp2.next = temp1;

            if (temp2 == tail) {
                tail = temp1;
            }

            cur = cur.next.next;
        }

    }

    @Override
    public void addFirst(T element) {
        if (size == 0) {
            addLast(element);
        } else {

            // step 1: create node
            Node<T> newNode = new Node<>(element);

            // step 2: link the rest of list to newNode
            newNode.next = head.next;

            // step 3: link head
            head.next = newNode;

            // step 4: size increase
            size++;

        }

    }

    @Override
    public String toString() {
        String s = "[";
        Node<T> cur = head.next;

        while (cur != null) {
            s += cur.data.toString();
            if (cur.next != null) {
                s += ", ";
            }
            cur = cur.next;
        }

        s += "] ";
        s += "size = " + size;
        s += ", head: " + head.toString();
        s += ", tail: " + tail.toString();
        return s;
    }

    @Override
    public T get(int index) {

        if (index >= size) {
            // System.out.println("Index out of bounds");
            // return null;
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index < 0) {
            return null;
        }

        Node<T> cur = head;
        for (int i = 0; i <= index; i++) {
            if (cur.next != null) {
                cur = cur.next;
            }
        }
        return cur.data;
    }

    @Override
    public void addAtIndex(int index, T element) {

        if (index < 0 || index > size) {
            System.out.println("Index out of bounds.");
            // throw new IndexOutOfBoundsException();
        } else {

            if (index == 0) {
                addFirst(element);
            } else if (index == size) {
                addLast(element);
            } else {
                // the hard part

                // step 1: create node
                Node<T> newNode = new Node<>(element);

                // step 2: get node before
                Node<T> cur = head.next;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }

                // step 3: temp reference to rest of list
                Node<T> temp = cur.next;

                // step 4: add the new noe after cur
                cur.next = newNode;

                // step 5: add the rest of the list back to new node
                newNode.next = temp;

                // step 6: increase size
                size++;

            }

        }

    }

    @Override
    public int nodesAfter(T target) {
        return nodesAfter(head.next, target);
    }

    private int nodesAfter(Node<T> node, T target) {

        // base case: not found
        if (node == null) {
            return -1;
        }

        // found target
        if (node.data.equals(target)) {
            return countNodes(node.next);
        }

        // recursive case
        return nodesAfter(node.next, target);
    }

    private int countNodes(Node<T> node) {

        // base case
        if (node == null) {
            return 0;
        }

        // recursive case
        return 1 + countNodes(node.next);
    }

    public void sort() {

        head.next = mergeSort(head.next);
        
        // update tail?

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }
        tail = current;
    }

    private Node<T> mergeSort(Node<T> node) {

        // base case
        if (node == null || node.next == null) {
            return node;
        }

        // Recursive case
        Node<T> middle = findMiddle(node);
        Node<T> rightStart = middle.next;
        middle.next = null;

        Node<T> l = mergeSort(node);
        Node<T> r = mergeSort(rightStart);

        return merge(l, r);
    }

    private Node<T> merge(Node<T> l, Node<T> r) {
        Node<T> dummy = new Node<T>();
        Node<T> tailMerge = dummy;

        while (l != null && r != null) {
            if (l.data.compareTo(r.data) <= 0) {
                tailMerge.next = l;
                l = l.next;
            } else {
                tailMerge.next = r;
                r = r.next;
            }

            tailMerge = tailMerge.next;
        }

        if (l != null) {
            tailMerge.next = l;
        } else if (r != null) {
            tailMerge.next = r;
        }
        return dummy.next;
    }

    private Node<T> findMiddle(Node<T> start) {
        Node<T> slow = start;
        Node<T> fast = start;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }

    public void sort() {

        head.next = mergeSort(head.next);

        // update the tail?

        Node<T> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        tail = cur;

    }

    private Node<T> mergeSort(Node<T> node) {

        // base case
        if (node == null || node.next == null) {
            return node;
        }

        // recursive case

        Node<T> middle = findMiddle(node);
        Node<T> rightStart = middle.next;
        middle.next = null;

        Node<T> l = mergeSort(node);
        Node<T> r = mergeSort(rightStart);

        return merge(l, r);
        

    }

    private Node<T> merge(Node<T> l, Node<T> r) {
        Node<T> dummy = new Node<>();
        Node<T> tailMerge = dummy;

        while (l != null && r != null) {
            if (l.data.compareTo(r.data) <= 0) {
                tailMerge.next = l;
                l = l.next;
            } else {
                tailMerge.next = r;
                r = r.next;
            }
            tailMerge = tailMerge.next;
        }
        if (l != null) {
            tailMerge.next = l;
        } else if (r != null) {
            tailMerge.next = r;
        }

        return dummy.next;
    }

    private Node<T> findMiddle(Node<T> start) {
        Node<T> slow = start;
        Node<T> fast = start;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
