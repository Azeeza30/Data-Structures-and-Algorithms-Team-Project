public class Main {

    public static void main(String[] args) {


        Stack stack = new Stack();

        Queue queue = new Queue();


        System.out.println("=== Stack Test ===");


        stack.push("Add Student");
        stack.push("Update Student");
        stack.push("Delete Student");


        stack.display();


        System.out.println("\nRemove Latest Action:");

        stack.pop();



        System.out.println("\n=== Queue Test ===");


        queue.enqueue("Student Registration");
        queue.enqueue("Library Request");
        queue.enqueue("Exam Request");


        queue.display();



        System.out.println("\nProcess Request:");

        queue.dequeue();


        queue.display();

    }

}