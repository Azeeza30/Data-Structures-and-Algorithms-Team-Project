public class Queue {


    String requests[] = new String[10];

    int front = 0;

    int rear = -1;



    // Add request

    public void enqueue(String request){

        if(rear == 9){

            System.out.println("Queue Full");

        }

        else{

            requests[++rear] = request;

        }

    }



    // Remove request

    public void dequeue(){

        if(front > rear){

            System.out.println("Queue Empty");

        }

        else{

            System.out.println(
            "Processed: " + requests[front++]
            );

        }

    }



    // Display queue

    public void display(){

        for(int i=front;i<=rear;i++){

            System.out.println(requests[i]);

        }

    }

}