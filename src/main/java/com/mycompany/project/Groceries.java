package com.mycompany.project;

import java.util.ArrayList;

public interface Groceries {

    public ArrayList<String> Item_Name = new ArrayList<String>();
    public ArrayList<Double> Item_Price = new ArrayList<Double>();

    abstract double Total_Price();

    abstract void Item_Price();
}
