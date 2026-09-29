# University Student Record and Campus Route Management System

**Module:** CIT300 - Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 1 (Week 10)
**Contribution:** 10% of final module grade

## 1. Project Overview

This Java coursework project contains implementations of student records,
linked lists, stacks, queues, binary search trees, hashing, and a campus
location graph. The modules are currently organized as separate source
folders and standalone demos.

## 2. Group Members

> **Fill this in before submission — required by the assignment brief.**

| # | Full Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|-----------|-----------|--------------------------|--------------------------|
| 1 |  Ms.Hassana         |  23DA2-0565         | Linked list implementation and student-record management | |
| 2 | S.Sulachchika          |     23DA2-1178      | Stack and queue implementation and related operations | |
| 3 |   AF.Azeeza        |    23DA2-0494       | BST/AVL tree implementation and hashing/search functionality | |
| 4 |          MRH.Mahmooth |   23DA2-542        | Graph implementation, campus locations, connections, and BFS/DFS traversal | |
| — | All Members | — | Integration, validation, testing, debugging, documentation, GitHub collaboration | |

*If your group has fewer than 4 members, combine the roles above among the
members you have. Every component, including the graph, is still compulsory.*

## 3. Implemented Modules

| Requirement | Implementation |
|-------------|----------------|
| Student records and linked list | `src/Student.java`, `src/Node.java`, `src/LinkedListManager.java` |
| Stack and queue | `Member_2_Stack_Queue/LinkedStack.java`, `Member_2_Stack_Queue/LinkedQueue.java` |
| BST and hashing | `StudentBST.java`, `StudentHashTable.java`, `Student.java` |
| Campus graph with BFS and DFS | `CampusGraph.java` |

The linked-list, stack/queue, and graph modules each have a standalone demo.
The repository does not currently contain a unified `Main.java` application.

## 4. Project Structure

```
.
├── src/                         # Member 1: student records and linked list
├── Member_2_Stack_Queue/         # Member 2: stack and queue
├── Student.java                 # Student model for BST and hashing module
├── StudentBST.java
├── StudentHashTable.java
├── CampusGraph.java              # Member 4: campus graph
├── Member4_Demo.java
├── Member1_README.md
└── README.md
```

## 5. How to Compile and Run

Install a JDK, then run a module demo from the project root using these
commands:

```powershell
# Member 1: student records and linked list
Set-Location src
javac *.java
java Member1_Demo

# Member 2: stack and queue (run after returning to the project root)
Set-Location ..\Member_2_Stack_Queue
javac *.java
java Member2_Demo

# Member 4: campus graph (run after returning to the project root)
Set-Location ..
javac CampusGraph.java Member4_Demo.java
java Member4_Demo
```

## 6. Demo Entry Points

The standalone demos are `src/Member1_Demo.java`,
`Member_2_Stack_Queue/Member2_Demo.java`, and `Member4_Demo.java`.
The BST and hash table classes are in the project root; a standalone demo
for those classes is not currently included.

## 7. Testing Notes

Run each module's demo to exercise its operations. The current repository
does not provide a single integrated application or an automated test
suite.

## 8. Suggested Next Steps for the Group

- Fill in the group member table above and confirm each member's
  contribution.
- Integrate the modules into one application and add validation/tests for
  the combined workflows.
- Prepare the demonstration so each member can explain the files matching
  their assigned responsibility (see Section 3).
- Follow the submission checklist in the assignment brief.
- Record the demonstration video, with each member showing their part.
