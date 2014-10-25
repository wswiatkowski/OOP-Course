package com.company;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static class Queue<T> implements Collection<T> {
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

        @Override
        public int size() {
            return index;
        }

        @Override
        public boolean isEmpty() {
            return index==0;
        }

        @Override
        public boolean contains(Object x) {
            return ((myList.contains(x)));
        }

        @Override
        public Iterator<T> iterator() {
            return myList.iterator();
        }

        @Override
        public Object[] toArray() {
            return myList.toArray();
        }

        @Override
        public <T1> T1[] toArray(T1[] a) {
            return myList.toArray(a);
        }

        @Override
        public boolean add(T t) {
            index ++;
            return myList.add(t);
        }

        @Override
        public boolean remove(Object o) {
            index--;
            return myList.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return myList.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            index += c.size();
            return myList.addAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            index -= c.size();
            return myList.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            index = c.size();
            return myList.retainAll(c);
        }

        public void clear(){
            myList.clear();
        }

    }

    public static void main(String[] args) {

    }
}
