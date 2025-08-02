package com.mycompany.project;

import java.util.Scanner;

public class Calculation extends Rent implements Groceries {

    double Total_rent;
    double Total_price;

    Scanner intInp = new Scanner(System.in);
    Scanner dblInp = new Scanner(System.in);

    @Override
    double Cost() {
        System.out.print("\nEnter house rent: ");
        House_rent = intInp.nextInt();

        System.out.print("Enter service charge: ");
        Service_charge = intInp.nextInt();

        System.out.print("Enter gas bill: ");
        Gas_bill = intInp.nextInt();

        System.out.print("Enter water bill: ");
        Water_bill = intInp.nextInt();

        System.out.print("Enter electricity bill: ");
        Electricity_bill = intInp.nextInt();

        System.out.print("Enter cook cost: ");
        cook = intInp.nextInt();

        System.out.print("Enter other cost: ");
        Other_costs = dblInp.nextDouble();
        System.out.println();

        Total_rent = House_rent + Service_charge + Gas_bill + Water_bill + Electricity_bill + cook + Other_costs;
        return Total_rent;
    }

    @Override
    double MealCount() {
        meal = dblInp.nextDouble();
        return meal;
    }

    @Override
    public void Item_Price() {
        Item_Name.clear();
        Item_Price.clear();
        Scanner strInp = new Scanner(System.in);
        int n = intInp.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter item " + (i + 1) + " name: ");
            String iName = strInp.nextLine();
            Item_Name.add(iName);
            System.out.print("Enter item " + (i + 1) + " price: ");
            double iPrice = dblInp.nextDouble();
            Item_Price.add(iPrice);
        }
    }

    @Override
    public double Total_Price() {
        double sum = 0;
        for (double p : Item_Price) {
            sum += p;
        }
        Total_price = sum;
        return Total_price;
    }

}
