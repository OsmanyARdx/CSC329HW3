package org.example;

public class PQHeap implements PriorityQueue{

    public Account[] arrayAccounts;
    int size;

    public PQHeap(){
        arrayAccounts = new Account[10];
        size = 0;
    }

    public PQHeap(PQHeap toBeCopied){
        this.size = toBeCopied.size;
        this.arrayAccounts = new Account[toBeCopied.arrayAccounts.length];
        for(int i = 0; i < toBeCopied.size; i++){
            this.arrayAccounts[i] = toBeCopied.arrayAccounts[i].deepCopy();
        }
    }

    public PQHeap deepCopy(){
        return new PQHeap(this);
    }

    /**
     * Method to add to the PriorityQueue
     *
     * @param a takes in Account data to add
     */
    @Override
    public void add(Account a) {
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

    public int getParentIndex(int index){
        return Math.floorDiv((index-1),2);
    }

    public int getLeftChildIndex(int index){
        return (2*index)+1;
    }

    public int getRightChildIndex(int index){
        return (2*index)+2;
    }

    public void swap(int index1, int index2){
        Account temp = arrayAccounts[index1];

        arrayAccounts[index1] = arrayAccounts[index2];
        arrayAccounts[index2] = temp;

    }

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

    public void heapifyDown(int index){
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);
        int tempSmall = index;

        if(leftChild < size && arrayAccounts[leftChild].getBalance() > arrayAccounts[tempSmall].getBalance()){
            tempSmall = leftChild;
        }
        if(rightChild < size && arrayAccounts[rightChild].getBalance() > arrayAccounts[tempSmall].getBalance()){
            tempSmall = rightChild;
        }
        if(tempSmall != index){
            swap(index, tempSmall);
            heapifyDown(tempSmall);
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
        swap(size, 0);
        heapifyDown(0);
        size--;
        return temp;
    }

    /**
     * Method to delete all data from the PriorityQueue
     */
    @Override
    public void clear() {
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
