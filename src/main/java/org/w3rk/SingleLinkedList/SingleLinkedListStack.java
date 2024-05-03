package org.w3rk.SingleLinkedList;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;


@Getter
@Setter
public class SingleLinkedListStack implements ISingleLinkedListStack {
    private int size = 0;
    private SingleLinkedNode firstNode = null;
    private SingleLinkedNode lastNode = null;

    @Override
    public void push(final SingleLinkedNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cant be null no mames");
        }
        if (node.getValue() == null) {
            throw new IllegalArgumentException("Node value cant be null");
        }
        node.setId(this.getSize());
        if (this.getFirstNode() == null) {
            size++;
            this.setFirstNode(node);
            this.setLastNode(node);
            return;
        }
        if (node.getValue().getClass().equals(this.firstNode.getValue().getClass())) {
            size++;
            this.lastNode.setNext(node);
            this.setLastNode(node);
        } else {
            throw new IllegalArgumentException("Given type don't match list type. Given/Expected" + node.getValue().getClass() + this.firstNode.getValue().getClass());
        }
    }

    @Override
    public void pop() throws IllegalArgumentException {
        this.getNodeById(this.getSize() - 1).setNext(null);
        this.size--;
    }

    @Override
    public SingleLinkedNode getNodeById(final int id) {
        if (id >= this.size || id < 0) {
            throw new IndexOutOfBoundsException("Id out of bounds");
        }
        SingleLinkedNode current = this.getFirstNode();
        for (int i = 0; i < id; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void replaceNodeById(final int id, final SingleLinkedNode node) {
        if (node == null || node.getValue() == null) {
            throw new IllegalArgumentException("new node or value cant be null");
        }
        SingleLinkedNode replacedNode = getNodeById(id);
        replacedNode.setValue(node.getValue());
    }

    @Override
    public void deleteNodeById(int id) {
        if (id >= this.size) {
            throw new IndexOutOfBoundsException("id is greater than list size");
        }
        if (id == 0) {
            this.setFirstNode(this.getFirstNode().getNext());
        } else {
            SingleLinkedNode previousToDelete = this.getNodeById(id - 1);
            SingleLinkedNode toDelete = this.getNodeById(id);
            previousToDelete.setNext(toDelete.getNext());
        }
        this.setSize(this.getSize() - 1);
        SingleLinkedNode current = this.getFirstNode();
        for (int i = 0; i < this.size; i++) {
            current.setId(i);
            current = current.getNext();
            if (current == null) {
                return;
            }
        }
    }

    @Override
    public void printList() {
        String nodeList = "";
        SingleLinkedNode current = this.getFirstNode();
        for (int i = 0; i < this.getSize(); i++) {
            nodeList = nodeList.concat(current.toString());
            current = current.getNext();
        }
        System.out.println(nodeList);
    }

    @Override
    public void fillList(final int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            SingleLinkedNode node = new SingleLinkedNode();
            node.setValue(rand.nextInt(100));
            this.push(node);
        }
    }

    @Override
    public SingleLinkedNode peek() {
        return this.lastNode;
    }

    @Override
    public boolean isEmpty() {
        return this.getFirstNode() == null;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", firstNode=" + firstNode +
                ", lastNode=" + lastNode +
                '}';
    }
}