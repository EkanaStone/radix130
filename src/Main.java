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

        int max = Radix.getMax(arr, arr.length);

        arr = carbon;

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
}

class Queue 
{

}
