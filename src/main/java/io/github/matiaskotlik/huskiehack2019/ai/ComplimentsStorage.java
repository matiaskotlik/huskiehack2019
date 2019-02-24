package io.github.matiaskotlik.huskiehack2019.ai;

import io.github.matiaskotlik.huskiehack2019.Storage;

import java.util.ArrayList;
import java.util.Scanner;

public class ComplimentsStorage implements Storage<String> {

    ArrayList<String> allCompliments = new ArrayList<>();


    public void StoreCompliments() {
        //ArrayList<String> allCompliments = new ArrayList<>();
        //System.out.println("hi");

    }

    /**
     * returns random compliment from the global arrayList
     */
//    public String ReceiveCompliments() {
//        return allCompliments.get((int)Math.random()*allCompliments.size());
//    }

    @Override
    public String get(String key) {
        return allCompliments.get((int)Math.random()*allCompliments.size());
        //return null;
    }

    @Override
    public boolean store(String key, String data) {
        Scanner reader = new Scanner (System.in);
        String compliment = reader.nextLine();
        allCompliments.add(compliment);
        return false;
    }
}
