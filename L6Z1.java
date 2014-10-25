package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Queue<T> implements Serializable{
        List<T> myList = new ArrayList<T>();
        int index = 0;
        public void Add(T x){
            myList.add(index, x);
            index++;
        }
        public T Pop(){
            if(index>0){
            T ret = myList.get(0);
            for (int i=0; i<(index)-1; i++){
                myList.set(i,myList.get(i+1));
            }
            myList.remove(index-1);
            index--;
            return ret;
            }
            else{
                return null;
            }
        }
        public void Flush(){
            myList.clear();
        }

    }

    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<Integer>();
        myQueue.Add(3);
        myQueue.Add(2);
        myQueue.Add(1);
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/queue.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myQueue);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            i.printStackTrace();
        }
        Queue<Integer> myQueueFromFile = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("/tmp/queue.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myQueueFromFile = (Queue<Integer>) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Queue<Integer> class not found");
            c.printStackTrace();
            return;
        }


        System.out.println(myQueueFromFile.Pop());
    }
}
