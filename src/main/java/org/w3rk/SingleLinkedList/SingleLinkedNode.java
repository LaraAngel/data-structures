package org.w3rk.SingleLinkedList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SingleLinkedNode {
    private int id = 0;
    private SingleLinkedNode next = null;
    private Object value = null;

    @Override
    public String toString() {
        return "SingleListNode [id=" + id + ", value=" + value + "]";
    }
}
