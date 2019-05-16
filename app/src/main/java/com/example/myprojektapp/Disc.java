package com.example.myprojektapp;

public class Disc {
    private String name;
    private String stable;
    private int size;
    private int cost;
    private String company;
    private String dtype;
    private String value;

    public Disc (String mName, String mStable, int mTom, int mpris, String mTillverkare, String mtyp, String mValue){
        name=mName;
        stable=mStable;
        size=mTom;
        cost=mpris;
        company=mTillverkare;
        dtype=mtyp;
        value=mValue;
    }
    public Disc(String mName){
        name=mName;
        stable="";
        size=-1;
        cost=-1;
        company="";
        dtype="";
        value="";
    }

    public void setStable(String stable) {
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

    public void setType(String typ){
        this.dtype=typ;
    }

    public String getType() {
        String typ = dtype;
        return dtype;
    }

    public void setValue(String value){
        this.value=value;
    }

    public String getValue() {
        String mvalue = ""+value;
        return mvalue;
    }

    @Override
    public String toString() {
        return name;
    }
}
