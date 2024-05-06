package org.w3rk.DoubleLinkedList;

import lombok.Getter;
import lombok.Setter;

import java.util.EmptyStackException;
import java.util.Random;

@Setter
@Getter
public class DoubleLinkedListStack implements IDoubleLinkedListStack {
    private DoubleLinkedNode firstNode = null;
    private DoubleLinkedNode lastNode = null;
    private int size = 0;

    @Override
    public void push(DoubleLinkedNode node) {
        if (node == null || node.getValue() == null) {
            throw new IllegalArgumentException("Cant add null element");
        }
        if (size == 0 && firstNode == null) {
            node.setId(this.size);
            this.firstNode = node;
            this.lastNode = node;
        } else {
            if (!(this.getFirstNode().getValue().getClass().equals(node.getValue().getClass()))) {
                throw new IllegalArgumentException("Cant add different type");
            }
            node.setPrevious(this.lastNode);
            this.lastNode.setNext(node);
            this.lastNode = node;
        }
        this.size++;
    }

    @Override
    public void pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        if (size == 1) {
            this.firstNode = null;
            this.lastNode = null;
        } else {
            this.lastNode = this.lastNode.getPrevious();
            this.lastNode.setNext(null);
        }
        this.size--;
    }

    @Override
    public DoubleLinkedNode peek() {
        return this.lastNode;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void fillList(int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            DoubleLinkedNode node = new DoubleLinkedNode();
            node.setValue(rand.nextInt(100));
            this.push(node);
        }
    }

    @Override
    public void printList() {
        String nodeList = "";
        DoubleLinkedNode current = this.getFirstNode();
        for (int i = 0; i < this.getSize(); i++) {
            nodeList = nodeList.concat(current.toString());
            current = current.getNext();
        }
        System.out.println(nodeList);
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "firstNode=" + firstNode +
                ", lastNode=" + lastNode +
                ", size=" + size +
                '}';
    }
}
