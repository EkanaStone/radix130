// Ethan. T. Jordan
// Radix Search
import java.util.*;
import java.io.*;


public class Main 
{
    public static void main(String[] args) throws Exception
    {
        int[] arr = {99, 34, 777, 420, 360, 720, 808, 10, 1, 21};

        //copy array
        int[] carbon = Radix.carbon(arr, arr.length);

        int max = Radix.getMax(arr, arr.length);

        Radix.sortUp(arr, max);
        
        arr = carbon;

        Radix.sortDown(arr, max);


    }
}

class Node
{
    public int data;
    public Node next;

    public Node(int data)
    {
        this.data=data;
    }
}

class Radix
{
    public static void toString(int[] arr)
    {
        for(int i=0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] carbon(int[] arr, int length)
    {
        int[] temp = new int[length];

        for (int i = 0; i<length; i++)
        {
            temp[i] = arr[i];
        }
        return temp;
    }

    public static int getMax(int[] arr, int length)
    {
        int max = arr[0];

        for (int i = 1; i < length; i++)
        {
            if (max < arr[i])
            {
                max = arr[i];
            }
        }
        int maxB = 1;

        for (int i = max; i > 1; i/=10)
        {
            maxB = maxB * 10;
        }
        maxB = maxB / 10;

        return maxB;
    }

    //sort ascended
    public static void sortUp(int[] arr, int maxB)
    {
        System.out.println("Ascended Sort:");

        Queue[] qArr = new Queue[10];

        for (int i = 0; i < 10; i++)
        {
            qArr[i] = new Queue();
        }

        //fill buckets
        for (int powers = 1; powers <= maxB; powers*=10)
        {
            for(int x = 0; x < arr.length; x++)
            {
                int digit = getDigit(arr[x], powers);
                
                qArr[digit].enqueue(arr[x]);
            }

            int m = 0;

            //increment
            for (int qNum = 0; qNum < 10; qNum++)
            {
                for(; !qArr[qNum].isEmpty(); m++)
                {
                    arr[m] = qArr[qNum].dequeue();
                }
            }
        }
        toString(arr);
    }

    //sort descended
    public static void sortDown(int[] arr, int maxB)
    {
        System.out.println("Descended Sort:");

        Queue[] qArr = new Queue[10];

        for (int i = 0; i < 10; i++)
        {
            qArr[i] = new Queue();
        }

        //fill buckets
        for (int powers = 1; powers <= maxB; powers*=10)
        {
            for(int x = 0; x < arr.length; x++)
            {
                int digit = getDigit(arr[x], powers);
                
                qArr[digit].enqueue(arr[x]);
            }

            int m = 0;

            //decrement
            for (int qNum = 9; qNum >= 0; qNum--)
            {
                for(; !qArr[qNum].isEmpty(); m++)
                {
                    arr[m] = qArr[qNum].dequeue();
                }
            }
        }
        toString(arr);
    }

    private static int getDigit(int num, int powers)
    {
        return (num / powers) % 10;
    }

}

class Queue 
{
    private Node head;
    private Node tail;

    public boolean isEmpty()
    {
        return head == null;
    }

    public void enqueue(int data)
    {
        Node node = new Node(data);

        if(head == null)
        {
            head = node;
        }
        else if(tail != null)
        {
            tail.next = node;
        }

        tail = node;
    }

    public int dequeue()
    {
        int data = head.data;

        head = head.next;

        if(head == null)
        {
            tail = null;
        }

        return data;
    }
}
