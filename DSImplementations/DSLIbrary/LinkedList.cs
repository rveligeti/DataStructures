using System;
using System.Collections.Generic;
using System.Text;

namespace Files
{
    public class LinkedList
    {
        public int? Data;
        public LinkedList Pointer;

        public LinkedList()
        {
            Data = null;
            Pointer = null;
        }


        public LinkedList(int? data,LinkedList pointer)
        {
            Data = data;
            Pointer = pointer;
        }

        public void PushFront(int data)
        {
            if (this.Pointer == null && this.Data==null)
            {
                this.Data = data;
            }
            else
            {
                LinkedList temp = new LinkedList(this.Data, this.Pointer);
                this.Data = data;
                this.Pointer = temp;
            }
        }



        public void PushBack(LinkedList pointer,int data)
        {
            if(pointer.Data==null && pointer.Pointer == null)
            {
                this.Data = data;
            }
            else if(pointer.Pointer == null)
            {
                LinkedList temp = new LinkedList(data, null);
                pointer.Pointer = temp;
            }
            else
            {
                PushBack(pointer.Pointer, data);
            }

        }

        public void PushBackIterative(int data)
        {

            if (Pointer.Data == null && Pointer.Pointer == null)
            {
                this.Data = data;
            }
            else
            {
                var last = Pointer;
                while(last.Pointer != null)
                {
                    last = last.Pointer;
                }
                var newnode = new LinkedList(data, null);
                last.Pointer = newnode;
            }
        }






    }
}
