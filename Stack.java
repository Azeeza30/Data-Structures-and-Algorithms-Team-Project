public class Stack {


    String actions[] = new String[10];

    int top = -1;



    // Push operation

    public void push(String action){

        if(top == 9){

            System.out.println("Stack Full");

        }

        else{

            actions[++top] = action;

        }

    }



    // Pop operation

    public void pop(){

        if(top == -1){

            System.out.println("No History");

        }

        else{

            System.out.println(actions[top--]);

        }

    }



    // Display stack

    public void display(){

        for(int i = top; i >= 0; i--){

            System.out.println(actions[i]);

        }

    }

}