package com.mycompany.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

public class Project extends Calculation {

    public static void main(String[] args) {

        
        ArrayList<Double> All_Total_price = new ArrayList<>();
        ArrayList<Double> All_Meal = new ArrayList<>();
        double All_Rent_cost;

        Scanner intInp = new Scanner(System.in);
        Scanner strInp = new Scanner(System.in);

        System.out.println("\n\t\tWelcome to Mess Management System\n");
        System.out.print("Enter the number of person: ");
        int per = intInp.nextInt();

        Person person[] = new Person[per];

        File projectFileObj = new File("ProjectFile.txt");

        try {
            FileWriter writerObj = new FileWriter("ProjectFile.txt");
            for (int i = 0; i < per; i++) {
                person[i] = new Person();

                System.out.print("\nEnter person " + (i + 1) + " name: ");
                String pName = strInp.nextLine();
                person[i].setName(pName);
                writerObj.write("\nPerson " + (i + 1) + " name: " + pName);

                System.out.print("Enter person " + (i + 1) + " NID no.: ");
                int pNID = intInp.nextInt();
                person[i].setNID(pNID);
                writerObj.write("\nPerson " + (i + 1) + " NID: " + pNID);

                System.out.print("Enter person " + (i + 1) + " contact no.: ");
                String pContact = strInp.nextLine();
                person[i].setContact(pContact);
                writerObj.write("\nPerson " + (i + 1) + " contact no: " + pContact);

                System.out.print("Enter person " + (i + 1) + " Date of Birth: ");
                String pDOB = strInp.nextLine();
                person[i].setDOB(pDOB);
                writerObj.write("\nPerson " + (i + 1) + " Date of Birth: " + pDOB);

                System.out.print("Enter person " + (i + 1) + " permanent address: ");
                String pAddress = strInp.nextLine();
                person[i].setPAdrs(pAddress);
                writerObj.write("\nPerson " + (i + 1) + " permanent address: " + pAddress);
            }
            System.out.println("\nBasic Information successfully written in ProjectFile!");
            writerObj.close();

        } catch (IOException ie) {
            System.out.println(ie);
            System.out.println("Error");
        }

        try {
            Scanner readerObj = new Scanner(projectFileObj);
            System.out.println("\nReading from project file...");
            while (readerObj.hasNextLine()) {
                String data = readerObj.nextLine();
                System.out.println(data);
            }
            readerObj.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

        System.out.println("\n");

        Calculation calc_rent = new Project();
        All_Rent_cost = calc_rent.Cost();

        Project personGroceries[] = new Project[per];
        for (int i = 0; i < per; i++) {
            personGroceries[i] = new Project();
           
            try {
                System.out.print("\nEnter the bought groceries number of " + person[i].getName() + ": ");
                personGroceries[i].Item_Price();
            } catch (InputMismatchException ex) {
                System.out.println(ex);
            } finally {
               // System.out.println("The 'try catch' block is finished.");
            }
       
            All_Total_price.add(personGroceries[i].Total_Price());
            
            try {
                System.out.print("\nEnter the meal number of " + person[i].getName() + ": ");
                All_Meal.add(personGroceries[i].MealCount());
            } catch (InputMismatchException ex) {
                System.out.println(ex);
            } finally {
                //System.out.println("The 'try catch' block is finished.");
            }          
        }
        System.out.println("\n");
        double Total_price_sum = 0;
        for (double p : All_Total_price) {
            Total_price_sum += p;
        }
        double Total_meal_sum = 0;
        for (double m : All_Meal) {
            Total_meal_sum += m;
        }
        double perMeal_cost = Total_price_sum / Total_meal_sum;
        double perRent_cost = All_Rent_cost / per;

        System.out.printf("Total Rent Cost: %.2f", All_Rent_cost);
        System.out.println(" tk");
        System.out.printf("Total Groceries Cost: %.2f", Total_price_sum);
        System.out.println(" tk");
        System.out.printf("Total Number of Meal: %.2f\n", Total_meal_sum);
        System.out.printf("Per Meal Cost: %.2f", perMeal_cost);
        System.out.println(" tk\n");

        File paymentFileObj = new File("PaymentFile.txt");

        try {
            FileWriter writerObj = new FileWriter("PaymentFile.txt");

            for (int i = 0; i < per; i++) {

                System.out.print("Rent cost for " + person[i].getName() + ": ");
                System.out.printf("%.2f", perRent_cost);
                System.out.println(" tk");

                System.out.print("Meal cost for " + person[i].getName() + ": ");
                System.out.printf("%.2f", perMeal_cost * All_Meal.get(i));
                System.out.println(" tk");

                System.out.print(person[i].getName() + " sold groceries: ");
                System.out.printf("%.2f", All_Total_price.get(i));
                System.out.println(" tk");

                double sub = (perMeal_cost * All_Meal.get(i)) - All_Total_price.get(i);

                double tot;
                if (sub >= 0) {
                    System.out.print(person[i].getName() + " needs to pay for meal cost: ");
                    System.out.printf("%.2f", sub);
                    System.out.println(" tk");

                    System.out.print("Finally, " + person[i].getName() + " needs to pay total: ");
                    System.out.printf("%.2f", sub + perRent_cost);
                    System.out.println(" tk\n");
                    tot = sub + perRent_cost;
                } else {
                    System.out.print(person[i].getName() + " get back from meal cost: ");
                    System.out.printf("%.2f", Math.abs(sub));
                    sub = Math.abs(sub);
                    System.out.println(" tk");

                    System.out.print("Finally, " + person[i].getName() + " needs to pay total: ");
                    System.out.printf("%.2f", perRent_cost - sub);
                    System.out.println(" tk\n");
                    tot = perRent_cost - sub;
                }

                double sub1 = sub;
                double per1 = tot;

                writerObj.write(person[i].getName() + " needs to pay for meal cost: " + sub1 + "tk\n\n");
                writerObj.write(person[i].getName() + " needs to pay total: " + per1 + "tk\n\n");
            }
            writerObj.close();
            System.out.println("\nPayment information successfully written in Payment file!");
        } catch (IOException ie) {
            System.out.println("Error");
        }

        try {
            Scanner readerObj = new Scanner(paymentFileObj);
            System.out.println("\nReading from payment file...");
            while (readerObj.hasNextLine()) {
                String data = readerObj.nextLine();
                System.out.println(data);
            }
            readerObj.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
