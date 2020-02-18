using System;
using System.Collections.Generic;
using System.Text;

namespace Files
{
    public class Node
    {
        public int val;
        public Node next;
        public Node previous;

        public Node()
        {

        }

        public Node(int data)
        {
            this.val = data;
        }

    }


    public class Dequeue
    {
        private Node head;
        private Node tail;

        public Dequeue()
        {
            this.head = new Node(-1);
            this.tail = new Node(-1);

            this.head.next = this.tail;
            this.tail.previous = this.head;

        }

        public void insertLeft(int data)
        {
            var temp = new Node(data);
            temp.next = this.head.next;
            temp.previous = this.head;
            this.head.next.previous = temp;
            this.head.next = temp;
        }


        public int getLeft()
        {

            if (this.head == this.tail.previous)
                return -1;
            return this.head.next.val;

        }

        public void removeLeft()
        {

            if (this.head != this.tail.previous)
            {
                this.head.next = this.head.next.next;
                this.head.next.previous = this.head;
            }
        }

        public int getRight()
        {
            if (this.head == this.tail.previous)
                return -1;

            return this.tail.previous.val;

        }


        public void removeRight()
        {

            if (this.head != this.tail.previous)
            {
                this.tail.previous = this.tail.previous.previous;
                this.tail.previous.next = this.tail ;
            }
        }



        //public insertRight(int data)
        //{

        //}

        //public deleteLeft(int data)
        //{

        //}

        //public deleteRight(int data)
        //{

        //}


    }
}
