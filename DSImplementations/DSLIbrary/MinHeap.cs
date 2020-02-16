using System;

namespace DSLIbrary
{
    public class MinHeap
    {
        int[] Elements = new int[20];

        int EndPointer = 0;

        public void MinHeapPush(int item)
        {
            if (EndPointer == 0)
            {
                Elements[EndPointer] = item;
                EndPointer++;
                return;
            }

            Elements[EndPointer] = item;
            int currentPointer = EndPointer;
            int parentPointer = (currentPointer - 1) / 2;
            while (Elements[currentPointer] < Elements[parentPointer])
            {
                int temp = Elements[parentPointer];
                Elements[parentPointer] = Elements[currentPointer];
                Elements[currentPointer] = temp;
                currentPointer = parentPointer;
                parentPointer = (parentPointer - 1) / 2;
            }
            EndPointer++;
        }


        public int? MinHeapPop()
        {
            if (EndPointer == 0)
            {
                return null;
            }
            var returnValue = Elements[0];
            Elements[0] = Elements[EndPointer];
            EndPointer--;
            int parentpointer = 0;
            int child1 = 1;
            int child2 = 2;

            while (Elements[parentpointer] > Elements[child1] || Elements[parentpointer] > Elements[child2])
            {
                int temp = Elements[parentpointer];
                if (Elements[child1] < Elements[child2])
                {
                    Elements[parentpointer] = Elements[child1];
                    Elements[child1] = temp;
                    parentpointer = child1;
                }
                else
                {
                    Elements[parentpointer] = Elements[child2];
                    Elements[child2] = temp;
                    parentpointer = child2;
                }

                child1 = (2 * parentpointer) + 1;
                child1 = (2 * parentpointer) + 2;
            }
            return returnValue;
        }


        public void heapify(int[] input)
        {
            int parentpointer;
            int child1;
            int child2;
            for (int i = input.Length - 1; i >= 0; i--)
            {
                parentpointer = i;
                child1 = (2 * parentpointer) + 1;
                child2 = (2 * parentpointer) + 2;
                while (isValid(child1, child2, input.Length) && (input[parentpointer] < input[child1] || input[parentpointer] < input[child2]))
                {
                    int temp = input[parentpointer];
                    if (input[child1] > input[child2])
                    {
                        input[parentpointer] = input[child1];
                        input[child1] = temp;
                        parentpointer = child1;
                    }
                    else
                    {
                        input[parentpointer] = input[child2];
                        input[child2] = temp;
                        parentpointer = child2;
                    }

                    child1 = (2 * parentpointer) + 1;
                    child2 = (2 * parentpointer) + 2;
                }
            }
        }

        private bool isValid(int child1, int child2, int total)
        {
            if (child1 <= (total - 1) && child2 <= (total - 1))
                return true;
            return false;
        }
    }
}
