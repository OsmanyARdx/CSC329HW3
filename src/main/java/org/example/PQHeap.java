package org.example;

/**
 * Blueprint class of a Priority-Queue-Heap
 * Implements methods from Priority Queue interface
 */
public class PQHeap implements PriorityQueue{

    private Account[] arrayAccounts;
    int size;

    /**
     * Default constructor for a PQHeap
     */
    public PQHeap(){
        arrayAccounts = new Account[10];
        size = 0;
    }

    /**
     * Deep copy constructor for a PQHeap
     * @param toBeCopied takes in an existing PQHeap and creates deep copies of its data
     */
    public PQHeap(PQHeap toBeCopied){
        this.size = toBeCopied.size;
        this.arrayAccounts = new Account[toBeCopied.arrayAccounts.length];
        for(int i = 0; i < toBeCopied.size; i++){
            this.arrayAccounts[i] = toBeCopied.arrayAccounts[i].deepCopy();
        }
    }

    /**
     * Method to create a deep copy from this PQHeap
     * @return returns a PQHeap object with deep copied data from the original
     */
    public PQHeap deepCopy(){
        return new PQHeap(this);
    }

    /**
     * Method to add to the PQHeap
     *
     * @param a takes in Account data to add
     */
    @Override
    public void add(Account a) {

        //Check is the array can take any more data
        //If not, create a larger array (2x) and copy the data to it
        if(arrayAccounts.length == size){
            Account[] temp = new Account[size*2];
            for(int i = 0; i<arrayAccounts.length; i++){
                temp[i] = arrayAccounts[i];
            }
            arrayAccounts = temp;
            arrayAccounts[size] = a;
            size++;
            heapifyUp(size - 1);
        }else{
            arrayAccounts[size] = a;
            size++;
            heapifyUp(size - 1);
        }
    }

    /**
     * Method to get the index of the parent from a given index
     * @param index takes in the index from which we want to know the parent
     * @return returns the parent index as an int
     */
    public int getParentIndex(int index){
        return Math.floorDiv((index-1),2);
    }

    /**
     * Method to get the index of the left child from a given index
     * @param index takes in the index from which we want to know the left child
     * @return returns the left child index as an int
     */
    public int getLeftChildIndex(int index){
        return (2*index)+1;
    }

    /**
     * Method to get the index of the right child from a given index
     * @param index takes in the index from which we want to know the right child
     * @return returns the right child index as an int
     */
    public int getRightChildIndex(int index){
        return (2*index)+2;
    }

    /**
     * Method to swap the data from one given index to another given index
     * @param index1 takes in one of the indexes from which to take data
     * @param index2 takes on the other index from which to take data
     */
    public void swap(int index1, int index2){
        Account temp = arrayAccounts[index1];

        arrayAccounts[index1] = arrayAccounts[index2];
        arrayAccounts[index2] = temp;

    }

    /**
     * Recursive method to compare account balance to the parent index and swap
     * @param index takes in the index from which we want to heapifyUp
     */
    public void heapifyUp(int index){
        if(index != 0) {
            if (arrayAccounts[index].getBalance() > arrayAccounts[getParentIndex(index)].getBalance()) {
                swap(getParentIndex(index), index);
                if (getParentIndex(index) != 0) {
                    heapifyUp(getParentIndex(index));
                }else{
                    return;
                }
            }
        }
    }

    /**
     * Method to compare account balance to the children indexes and swap
     * @param index takes in the index from which we want to heapifyDown
     */
    public void heapifyDown(int index){
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);
        int tempLargest = index;

        if(leftChild < size && arrayAccounts[leftChild].getBalance() > arrayAccounts[tempLargest].getBalance()){
            tempLargest = leftChild;
        }
        if(rightChild < size && arrayAccounts[rightChild].getBalance() > arrayAccounts[tempLargest].getBalance()){
            tempLargest = rightChild;
        }
        if(tempLargest != index){
            swap(index, tempLargest);
            heapifyDown(tempLargest);
        }
    }

    /**
     * Method to get max value Account (Account with the highest priority)
     *
     * @return returns an Account object
     */
    @Override
    public Account getMax() {
        Account temp = arrayAccounts[0];
        if(size != 0){
            size--;
            swap(size, 0);
            heapifyDown(0);
        }
        return temp;
    }

    /**
     * Method to delete all data from the PriorityQueue
     */
    @Override
    public void clear() {
        this.arrayAccounts = new Account[10];
        size = 0;
    }

    /**
     * Method to get the length of the Priority Queue
     *
     * @return returns an integer value as the length
     */
    @Override
    public int getLength() {
        return size;
    }

    /**
     * Method to check if the Priority Queue is empty
     *
     * @return return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
