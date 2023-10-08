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
    public static void heapsort(Account[] a){
        PQHeap accountPQHeap= new PQHeap();
        for(int i = 0; i < a.length; i++){
            accountPQHeap.add(a[i]);
        }
        for(int i = 0; i < a.length; i++){
            a[i] = accountPQHeap.getMax();
        }
    }

    /**
     * Runnable program
     * @param args
     */
    public static void main(String[] args) {

    }
}