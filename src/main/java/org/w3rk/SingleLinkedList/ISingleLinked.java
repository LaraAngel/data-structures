package org.w3rk.SingleLinkedList;

public interface ISingleLinked {
    SingleLinkedNode getNodeById(final int id);
    void replaceNodeById(final int id, final SingleLinkedNode node);
    void deleteNodeById(final int id);
    void printList();
    void fillList(final int size);
    SingleLinkedNode peek();
    boolean isEmpty();
}
