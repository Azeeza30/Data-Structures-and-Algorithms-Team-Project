# Member 1 Work: Student Records + Linked List

## Assigned Responsibility
- **Student Record Management**: `Student` class (Student ID, Name, Programme, Marks)
- **Linked List Implementation**: `Node` and `LinkedListManager` classes
- **Operations**: Add, Update, Delete, Search, and Display all records

## Files in this module
- `Student.java`: Student entity class with attributes and getters/setters.
- `Node.java`: Generic singly-linked node.
- `LinkedListManager.java`: Linked list data structure supporting CRUD operations.
- `Member1_Demo.java`: Standalone interactive runner to test all Member 1 functionality.

## How to Compile and Run
```bash
cd Member_1_StudentRecords_LinkedList
javac *.java
java Member1_Demo
```

## GitHub Branch & Push Guide
1. Create and switch to your feature branch:
   ```bash
   git checkout -b feature/member-1-student-records
   ```
2. Stage and commit your files:
   ```bash
   git add .
   git commit -m "feat(member-1): implement Student class, Node, and LinkedListManager with full CRUD"
   ```
3. Push to GitHub:
   ```bash
   git push -u origin feature/member-1-student-records
   ```
4. Create a Pull Request (PR) on GitHub to merge into `main`.
