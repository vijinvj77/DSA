import java.util.Scanner;

public class DoublyLinkedList {
    public static Scanner sc = new Scanner(System.in);
    public static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    public static void addNode(){
        System.out.println("Enter your data");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public static void displayStraight(){
        Node temp = head;
        if(temp == null){
            System.out.println("The list is empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void displayReverse(){
        Node temp = tail;
        if(tail == null){
            System.out.println("The list is empty");
        }

        while(temp != null){
            System.out.println(temp.data+" ");
            temp = temp.prev;
        }
    }

    public static void deleteNode(){
        System.out.println("Enter the data you want to delete");
        int data = sc.nextInt();

        Node temp = head;
        if(temp == null){
            System.out.println("The list is empty");
            return;
        }



        while(temp != null && temp.data != data){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("The element not found");
            return;
        }

        if(temp == head){
            head = temp.next;
            head.prev = null;
            System.out.println(data + " deleted");
            return;
        }

        if(temp == tail){
            tail = temp.prev;
            tail.next = null;
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public static void addAfter(){
        System.out.println("Enter the element after which you want to add the data");
        int nextTo = sc.nextInt();

        System.out.println("Enter the data");
        int data = sc.nextInt();

        Node newNode = new Node(data);

        Node temp = head;
        while(temp != null && temp.data != nextTo){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("The element not found");
            return;
        }

        if(temp == tail){
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
            System.out.println(data+" added");
            return;
        }

        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
        System.out.println(data+" added");
    }

    public static void addBefore(){
        System.out.println("Enter the element before which you want to add the data");
        int before = sc.nextInt();

        System.out.println("Enter the data");
        int data = sc.nextInt();

        Node newNode = new Node(data);

        Node temp = head;

        while(temp != null && temp.data != before){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("The data not found");
            return;
        }

        if(temp == head){
            temp.prev = newNode;
            newNode.next = temp;
            head = newNode;
            System.out.println(data +" added");
            return;
        }

        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        temp.prev = newNode;
        System.out.println(data+" added");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        int option = 0;
        do{
            System.out.println("Select your option");
            System.out.println("1. Add Node");
            System.out.println("2. Delete Node");
            System.out.println("3. Display Straight");
            System.out.println("4. Display Reverse");
            System.out.println("5. Add after");
            System.out.println("6. Add Before");
            System.out.println("7. Exit");
            option = sc.nextInt();
            switch(option){
                case 1:
                    addNode();
                    break;

                case 2:
                    deleteNode();
                    break;

                case 3:
                    displayStraight();
                    break;

                case 4:
                    displayReverse();
                    break;

                case 5:
                    addAfter();
                    break;

                case 6:
                    addBefore();
                    break;

                default:
                    System.out.println("Please enter a valid option");
            }
        }while(option != 7);
    }
}
