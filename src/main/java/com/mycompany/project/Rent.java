package com.mycompany.project;

public abstract class Rent {

    int House_rent;
    int Service_charge;
    int Gas_bill;
    int Water_bill;
    int Electricity_bill;
    int cook;
    double Other_costs;
    double meal;

    abstract double Cost();

    abstract double MealCount();
}
