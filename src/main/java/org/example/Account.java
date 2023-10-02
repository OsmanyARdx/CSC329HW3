package org.example;

import java.util.Objects;

/**
 * Account class blueprint
 * Holds data associated with an account
 */
public class Account{
    private String name;
    private double balance;

    /**
     * Account default constructor
     */
    public Account(){
        name = "NONAME";
        balance = 0.0;
    }

    /**
     * Account constructor that takes in a name and balance to create an Account object
     * @param na takes in the String to be used for the name in the account
     * @param bal takes in the double value to be used to the balance in the account
     */
    public Account(String na, double bal){
        name = na;
        balance = bal;
    }

    /**
     * Account deep-copy constructor
     * @param other takes in an existing Account object to deep-copy from
     */
    public Account(Account other){
        this.name = other.name;
        this.balance = other.balance;
    }

    /**
     * Method to get the name in the Account
     * @return returns the name as a String value
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name in the Account
     * @param name takes in a String value that will be used as the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the Account balance
     * @return returns the balance as a double value
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Method to set the balance
     * @param balance takes in a double that will be used as the balance in the Account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Method to deep-copy the current Account into a new one
     * @return returns the new Account object with deep-copied data
     */
    public Account deepCopy(){
        return new Account(this.getName(), this.getBalance());
    }

    /**
     * Method to check of objects of Account are equal
     * @param o takes in a Object that will be used as an Account to check if the data in them are equal
     * @return returns true if the name String is equal to the passed in Account name String, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        Account account = (Account) o;
        return this.getName().equals(account.getName());
    }

    /**
     * Method to create a new hashCode using the name and balance data in the Account
     * @return returns the new hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }
}
