package com.jcoders.www.CustomUtil;

public class LinkedList <E> implements List{

    private Node<E> node;

    private int size;
    private static class Node<E>{
        E data;
        Node<E> next;
        public Node(E data, Node<E> next ) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList(){
    }

    public LinkedList(Node<E> node) {
        this.node = node;
        this.size =1;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return false;
    }

    public void add(E data){
        if (this.size == 0){
            this.node = new Node<>(data,null);
        }
        else{
            Node<E> iterator= this.node;
            while ( iterator.next != null ){
                iterator=iterator.next;
            }
            iterator.next = new Node<>(data,null);
        }
        size +=1;
    }

    public E get(int index) throws IndexOutOfBoundsException{

        if (this.size < 0 || this.size < index -1 ){
            throw new IndexOutOfBoundsException(String.format("Index {} exceeds array length.",this.size));
        }
        Node<E> iterator = this.node;
        int currentIndex = 0;
        while ( index != currentIndex  ){
            iterator = iterator.next;
            currentIndex ++;
        }

        return iterator.data;
    }
}
