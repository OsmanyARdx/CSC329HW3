package org.example;

/**
 * PriorityQueue Interface with a blueprint of all the methods to be implemented and used
 */
public interface PriorityQueue {

    /**
     * Method to add to the PriorityQueue
     * @param a takes in Account data to add
     */
    public void add(Account a);

    /**
     * Method to get max value Account (Account with the highest priority)
     * @return returns an Account object
     */
    public Account getMax();

    /**
     * Method to delete all data from the PriorityQueue
     */
    public void clear();

    /**
     * Method to get the length of the Priority Queue
     * @return returns an integer value as the length
     */
    public int getLength();

    /**
     * Method to check if the Priority Queue is empty
     * @return return true if empty, false otherwise
     */
    public boolean isEmpty();
}
