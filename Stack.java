import java.util.Scanner;
public class Stack {

    public static Scanner sc = new Scanner(System.in);

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data =  data;
        }
    }

    public static Node top;

    public static void push(){
        System.out.println("Enter your data");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
    }

    public static void pop(){
        if(top == null){
            System.out.println("Stack underflow");
            return;
        }
        top = top.next;
    }

    public static void display(){
        Node temp = top;

        if(temp == null){
            System.out.println("Stack underflow");
        }
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        int option= 0;
        do {
            System.out.println(" ");
            System.out.println("Enter your option");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. Display");
            option = sc.nextInt();
            switch(option){
                case 1:
                    push();
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    display();
                    break;

                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }while(option != 4);
    }
}
