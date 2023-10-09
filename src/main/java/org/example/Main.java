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
    public static void heapSort(Account[] a){
        PQHeap accountPQHeap= new PQHeap();
        for(int i = 0; i < a.length; i++){
            accountPQHeap.add(a[i]);
        }
            a = accountPQHeap.arrayAccounts;
    }

    /**
     * Runnable program
     * @param args
     */
    public static void main(String[] args) {
        Account[] accounts = new Account[1000];
        PQHeap heap = new PQHeap();
        try {
            File accountsFile = new File("accounts.txt");
            Scanner scanner = new Scanner(accountsFile);
            int i =0;
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                double balanceScanned = Double.parseDouble(scanner.nextLine());
                accounts[i] = new Account(name, balanceScanned);
                heap.add(new Account(name, balanceScanned));
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //heapSort(accounts);

//        for(int i=0; i<accounts.length;i++){
//            System.out.println(accounts[i].getBalance() + " - " + accounts[i].getName());
//        }
        for(int i=0; i< heap.size;i++){
            System.out.println(heap.arrayAccounts[i].getBalance() + " - " + heap.arrayAccounts[i].getName());
        }
    }
}