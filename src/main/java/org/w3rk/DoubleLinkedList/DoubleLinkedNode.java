package org.w3rk.DoubleLinkedList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoubleLinkedNode {
    private int id = 0;
    private DoubleLinkedNode next = null;
    private DoubleLinkedNode previous = null;
    private Object value = null;

    @Override
    public String toString() {
        return "DoubleListNode{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
