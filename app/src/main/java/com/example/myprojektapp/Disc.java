package com.example.myprojektapp;

public class Disc {
    private String name;
    private String location;
    private int size;
    private int cost;
    private String company;
    private String category;

    public Disc (String mName, String mStable, int mTom, int mpris, String mTillverkare, String mtyp ){
        name=mName;
        location=mStable;
        size=mTom;
        cost=mpris;
        company=mTillverkare;
        category=mtyp;
    }
    public Disc(String mName){
        name=mName;
        location="";
        size=-1;
        cost=-1;
        company="";
        category="";
    }

    public void setLocation(String stable) {
        this.location = stable;
    }

    public String getLocation() {
        String stable = "Stabilitet: "+location;
        return stable;
    }

    public void setCost(int c) {
        this.cost = c;
    }

    public String getCost() {
        String pris = "Pris: " + cost +"kr";
        return pris;
    }

    public void setCompany (String tillverkare){
        this.company=tillverkare;
    }

    public String getCompany() {
        String tillverkare = "Företag: "+company;
        return tillverkare;
    }

    public void setCategory(String typ){
        this.category=typ;
    }

    public String getCategory() {
        String typ = "Typ av disc: "+category;
        return typ;
    }
    @Override
    public String toString() {
        return name;
    }
}
