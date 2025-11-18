public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void addLast(E element) {
        Node<E> nodeToAdd = new Node<>(element);

        if (size == 0){
            head = nodeToAdd;
        }else {
            tail.setNext(nodeToAdd);
        }

        tail = nodeToAdd;
        size++;
    }

    public void add(int idnex, E element) {
        if (idnex < 0 || idnex > size) {
            throw new IndexOutOfBoundsException("Index: " + idnex + ", Size: " + size);
        }

        Node<E> nodeToAdd = new Node<>(element);

        if (idnex == 0) {
            nodeToAdd.setNext(head);
            head = nodeToAdd;
            if (size == 0) {
                tail = nodeToAdd;
            }
        } else {
            Node<E> current = head;
            for (int i = 0; i < idnex - 1; i++) {
                current = current.getNext();
            }
            nodeToAdd.setNext(current.getNext());
            current.setNext(nodeToAdd);
            if (nodeToAdd.getNext() == null) {
                tail = nodeToAdd;
            }
        }
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }
}
