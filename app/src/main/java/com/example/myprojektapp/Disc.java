package com.example.myprojektapp;

public class Disc {
    private String name;
    private String stable;
    private int size;
    private int cost;
    private String company;
    private String category;

    public Disc (String mName, String mStable, int mTom, int mpris, String mTillverkare, String mtyp ){
        name=mName;
        stable=mStable;
        size=mTom;
        cost=mpris;
        company=mTillverkare;
        category=mtyp;
    }
    public Disc(String mName){
        name=mName;
        stable="";
        size=-1;
        cost=-1;
        company="";
        category="";
    }

    public void setLocation(String stable) {
        this.stable = stable;
    }

    public String getStable() {
        String mstable = stable;
        return stable;
    }

    public void setCost(int c) {
        this.cost = c;
    }

    public String getCost() {
        String pris = "" + cost;
        return pris;
    }

    public void setCompany (String tillverkare){
        this.company=tillverkare;
    }

    public String getCompany() {
        String tillverkare = company;
        return tillverkare;
    }

    public void setCategory(String typ){
        this.category=typ;
    }

    public String getCategory() {
        String typ = category;
        return category;
    }
    @Override
    public String toString() {
        return name;
    }
}
