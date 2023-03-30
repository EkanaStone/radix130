// Ethan. T. Jordan
// Radix Search
import java.util.*;
import java.io.*;


public class Main 
{
    public static void main(String[] args) throws Exception
    {
        //chang numbers
        int[] arr = {420, 96, 69, 42960, 94206, 69420, 5, 88, 65, 234};

        //copy array
        int[] carbon = Radix.carbon(arr, arr.length);

    }
}

class Node
{

}

class Radix
{
    public static int[] carbon(int[] arr, int length)
    {
        int[] temp = new int[length];

        for (int i = 0; i<length; i++)
        {
            temp[i] = arr[i];
        }
        return temp;
    }
}

class Queue 
{

}
