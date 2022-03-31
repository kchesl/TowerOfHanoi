// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kirsten Chesley (kchesley888)
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;



/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-25)
 * 
 * @param <T> the data
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode = null;

    private int size = 0;

    /**
     * constructor
     */
    public LinkedStack() {
        // left intentionally empty
    }


    @Override
    public void clear() {
        topNode = null;
        size = 0;

    }


    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }


    @Override
    public T peek() {
        if (this.size <= 0) {
            throw new EmptyStackException();
        }
        return this.topNode.getData();
    }


    @Override
    public T pop() {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        Node<T> t = topNode;
        topNode = t.getNextNode();
        size--;
        return t.getData();
    }


    @Override
    public void push(T disk) {
        Node<T> newNode = new Node<T>(disk);
        newNode.setNextNode(topNode);
        topNode = newNode;

        size++;
    }

    /**
     * converts it to a string
     * @return returns a string
     */
    public String toString() {
        Node<T> t = this.topNode;
        StringBuilder string = new StringBuilder();
        string.append("[");
        while (t != null) {
            string.append(t.getData());
            if (t.getNextNode() != null) {
                string.append(", ");
            }
            t = t.nextNode;
        }
        string.append("]");
        return string.toString();
    }

    /**
     * returns the size
     * 
     * @return returns the size
     */
    public int size() {
        return size;
    }

    /**
     * node class
     * 
     * @param <T> the data
     */
    private class Node<T> {
        private Node<T> nextNode;
        private T data;

        /**
         * constructor
         * @param data
         */
        public Node(T data) {
            nextNode = null;
            this.data = data;
        }

        /**
         * constructor
         * @param nextNode
         * @param data
         */
        public Node(Node<T> nextNode, T data) {
            this.nextNode = nextNode;
            this.data = data;
        }

        /**
         * gets the next node
         * @return returns the next node
         */
        public Node<T> getNextNode() {
            return nextNode;
        }

        /**
         * gets the data
         * @return returns the data
         */
        public T getData() {
            return data;
        }

        /**
         * sets the next node
         */
        public void setNextNode(Node<T> newn) {
            nextNode = newn;
        }

    }

}


