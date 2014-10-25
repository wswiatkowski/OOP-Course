package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class Coll<T extends Comparable<T>>{
        List<T> myList = new ArrayList<T>();

        public void Add(T x){
            int i=0;
            while(i<myList.size() && x.compareTo(myList.get(i))==1){
                i++;
            }
            myList.add(i,x);
        }
        public T Pop(){
            T tmp = myList.get(0);
            myList.remove(0);
            return tmp;
        }
        public void Print(){
            for (int i = 0; i<=myList.size()-1; i++){
                System.out.println(myList.get(i));
            }
        }


    }
    public static class Private implements Comparable<Private>{
        private String imie;
        private String nazwisko;
        public Private(String imie, String nazwisko){
            this.imie = imie;
            this.nazwisko = nazwisko;
        }
        @Override
        public int compareTo(Private x){
            if (this.getClass().isAssignableFrom(x.getClass())){
                return 0;
            }
            else
                return -1;
        }
    }
    public static class Corporal extends Private {
        public Corporal(String imie, String nazwisko){
            super(imie, nazwisko);
        }
    }
    public static class Lieutenant extends Corporal {
        public Lieutenant(String imie, String nazwisko){
            super(imie, nazwisko);
        }
    }
    public static class General extends Lieutenant {
        public General(String imie, String nazwisko){
            super(imie,nazwisko);
        }
    }
    public static class Private_First_Class extends Private {
        public Private_First_Class(String imie, String nazwisko) {
            super(imie, nazwisko);
        }
    }

    public static void main(String[] args) {
        Private mySzerzegowy = new Private("Tom", "Hammer");
        Corporal myCorporal = new Corporal("Woods", "Jerry");
        Lieutenant myLieutenant = new Lieutenant("Mark", "Spencer");
        General myGeneral = new General("Napoleon", "Bonaparte");
        Private_First_Class myPrivate_First_Class = new Private_First_Class("Michael","Poverty");
	    Coll<Integer> myColl = new Coll<Integer>();
        myColl.Add(99);
        myColl.Add(13);
        myColl.Add(78);
        myColl.Add(128);
        System.out.println(myColl.Pop());
        System.out.println(myColl.Pop());
        myColl.Print();
    }
}
