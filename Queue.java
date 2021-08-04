import java.util.Scanner;
public class Queue {

    public static Scanner sc = new Scanner(System.in);

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node front = null, rear = null;

    public static void enqueue(){
        System.out.println("Enter the data");
        int data = sc.nextInt();

        Node newNode = new Node(data);

        if(front == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public static void dequeue(){
        if(front == null){
            System.out.println("The queue is empty");
            return;
        }
        front = front.next;
        if(front == null){
            rear = null;
        }
    }

    public static void display(){
        if(front == null){
            System.out.println("The queue is empty");
            return;
        }
        Node temp = front;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int option = 0;
        do{
            System.out.println(" ");
            System.out.println("Select Your option");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            option = sc.nextInt();
            switch(option){
                case 1:
                    enqueue();
                    break;

                case 2:
                    dequeue();
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
