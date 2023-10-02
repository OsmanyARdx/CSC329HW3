package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Runs main program
 */
public class Main {

    /**
     * Runnable program
     * @param args
     */
    public static void main(String[] args) {
        //Reads from the "accounts.txt" and creates accounts, stores them in bankList in order
        PQList bankList = new PQList();
        try {
            File accountsFile = new File("accounts.txt");
            Scanner scanner = new Scanner(accountsFile);
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                double balanceScanned = Double.parseDouble(scanner.nextLine());
                bankList.add(new Account(name, balanceScanned));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Test to see if the list is organized from highest to lowest
//        int i = 0;
//        while (!bankList.isEmpty()) {
//            i++;
//            System.out.println(i + " " + bankList.getLength());
//            System.out.println(bankList.getMax().getBalance());
//
//        }


        //Test to see if the list is deep-copied.


        //If the list hasn't been emptied print out the Max
        if (!bankList.isEmpty()) {
            System.out.println("1 - Length of list before removal: " + bankList.getLength());
            Account maxBank = bankList.getMax();
            System.out.println("1 - Largest account balance: $" + maxBank.getBalance() + " - " + maxBank.getName());
            System.out.println("1 - Length of list after removal: " + bankList.getLength());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            PQList bank2List = new PQList(bankList);

            System.out.println("++++++++++Compare Classes+++++++");
            System.out.println(bank2List.getMax());
            System.out.println(bankList.getMax());
            System.out.println("2 - Length of list before removal: " + bank2List.getLength());
            Account maxBank2 = bank2List.getMax();
            System.out.println("2 - Largest account balance: $" + maxBank2.getBalance() + " - " + maxBank2.getName());
            System.out.println("2 - Length of list after removal: " + bank2List.getLength());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

            //Test the deepCopy method
            PQList bank3List = new PQList(bank2List);
            System.out.println("3 - Length of list before removal: " + bank3List.getLength());
            Account maxBank3 = bank3List.getMax();
            System.out.println("3 - Largest account balance: $" + maxBank3.getBalance() + " - " + maxBank3.getName());
            System.out.println("3 - Length of list after removal: " + bank3List.getLength());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        }

        //test account equals override method
        Account acc1 = new Account("James", 19901);
        Account acc2 = new Account("James", 19901);
        System.out.println(acc1.equals(acc2));

        //Account deep copy method
        Account acc3 = acc2.deepCopy();

        System.out.println(acc3);
        System.out.println(acc2);
        System.out.println(acc3.equals(acc2));


    }
}