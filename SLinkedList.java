import java.util.Scanner;

public class SLinkedList {
    static Scanner sc = new Scanner(System.in);
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    public static void addNode(){
        int data = 0;
        System.out.println("Enter your data");
        data = sc.nextInt();
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
    }

    public static void deleteNode(){
        System.out.println("Enter the data you want to delete");
        int data = sc.nextInt();
        Node temp = head, prev = null;
        if(temp.data == data){
            head = temp.next;
            System.out.println(data+" deleted");
            return;
        }
        while(temp != null && temp.data != data){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("The data not found");
        }
        if(temp == tail){
            tail = prev;
            tail.next = null;
            System.out.println(data+" deleted");
            return;
        }
        prev.next = temp.next;

    }

    public static void displayNodes(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void insertAfter(){
        System.out.println("Enter the data after which you want to insert new data");
        int nextTo = sc.nextInt();
        System.out.println("Enter the data");
        int data = sc.nextInt();
        Node temp = head, prev = null;
        Node newNode = new Node(data);
        if(temp == null){
            System.out.println("The list is empty");
            return;
        }
        while(temp != null && temp.data != nextTo){
            temp = temp.next;
        }
        if(temp == tail){
            tail.next = newNode;
            tail = newNode;
            System.out.println(data+" added");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println(data+" added");

    }

    public static void main(String[] args) {
        int option = 0;
        do {
            System.out.println("Enter your option");
            System.out.print("1. Add Node 2.Delete Node 3. Display Nodes 4.Insert After Node 5.Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    addNode();
                    break;

                case 2:
                    deleteNode();
                    break;

                case 3:
                    displayNodes();
                    break;

                case 4:
                    insertAfter();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Please enter a valid option");

            }
        }while(option != 5);
    }
}