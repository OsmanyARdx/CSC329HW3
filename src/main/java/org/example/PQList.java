package org.example;

/**
 * Node class blueprint to store an Account
 */
class Node {
    public Account acc;

    public Node next;

    /**
     * Node default constructor for a Node
     */
    public Node(){
        acc = null;
        next = null;
    }

    /**
     * Node constructor with an account parameter
     * @param a takes in an Account object to set inside the Node
     */
    public Node(Account a){
        this.acc = a;
        this.next = null;
    }

    /**
     * Method to insert an Account object to the Node
     * @param data takes in an Account object to be set
     */
    public void insert(Account data){
        this.acc = data;
    }
}

/**
 * PQList class blueprint which implements PriorityQueue
 */
public class PQList implements PriorityQueue{

    private Node head;

    private int length;

    /**
     * PQList default constructor
     */
    public PQList(){
        head = null;
        length = 0;

    }

    /**
     * PQList deep-copy constructor by iterating through an already existing PQList
     * @param originalList the PQList that will be deep-copied from
     */
    public PQList(PQList originalList){
        Node oCurr = originalList.head;

            //Go through the passed PQList and add each node.
            while (oCurr != null) {
                this.add(oCurr.acc.deepCopy());
                oCurr = oCurr.next;
            }
        }

    /**
     * Method to deep-copy the current PQList and return a new PQList from it
     * @return returns, the new deep-copy, PQList
     */
    public PQList deepCopy(){
        return new PQList(this);
    }

    /**
     * Method to add data into the PQList by creating Nodes and linking them together, in order of high to low account balance
     * @param a takes in an Account to be inserted into a Node and added to the PQList
     */
    @Override
    public void add(Account a) {
        Node newAdd = new Node(a);
        if(isEmpty() || head.acc.getBalance() < newAdd.acc.getBalance()) {
            newAdd.next = head;
            head = newAdd;
        }
        else{
            Node curr = head;
            //Loop will keep going until it finds a correct place for our new node (newAdd).
            while(curr.next != null && newAdd.acc.getBalance() <= curr.next.acc.getBalance()){
                curr = curr.next;
            }
            newAdd.next = curr.next;
            curr.next = newAdd;
        }
        length++;
    }

    /**
     * Method to get the Account with the highest account balance (already at the first node -head-)
     * @return returns the Account object inside the head Node
     */
    @Override
    public Account getMax() {
        Node maxNode = null;
        if(head != null){
            maxNode = head;
            head = head.next;
        }
        length--;
        return maxNode.acc;
    }

    /**
     * Method to clear the PQList
     */
    @Override
    public void clear() {
        head = null;
        length = 0;
    }

    /**
     * Method to get the length of the PQList
     * @return returns the length variable
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * Method to check if the PQList is empty
     * @return returns true if head is empty and length is 0, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null && length == 0;
    }
}
