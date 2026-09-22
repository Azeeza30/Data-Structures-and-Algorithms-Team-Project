# University Student Record and Campus Route Management System

**Module:** CIT300 - Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 1 (Week 10)
**Contribution:** 10% of final module grade

## 1. Project Overview

A Java console application that manages university student records and
models the campus location network as a graph. It demonstrates the
practical use of linked lists, stacks, queues, trees, hashing, and graphs,
as required by the assignment brief.

## 2. Group Members

> **Fill this in before submission — required by the assignment brief.**

| # | Full Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|-----------|-----------|--------------------------|--------------------------|
| 1 |           |           | Linked list implementation and student-record management | |
| 2 |           |           | Stack and queue implementation and related operations | |
| 3 |           |           | BST/AVL tree implementation and hashing/search functionality | |
| 4 |           |           | Graph implementation, campus locations, connections, and BFS/DFS traversal | |
| — | All Members | — | Integration, validation, testing, debugging, documentation, GitHub collaboration | |

*If your group has fewer than 4 members, combine the roles above among the
members you have. Every component, including the graph, is still compulsory.*

## 3. How the Requirements Are Met

| Req. | Requirement | Where it's implemented |
|------|-------------|--------------------------|
| 1 | Student record (ID, Name, Programme, Marks) | `Student.java` |
| 2 | Linked list to store/manage records | `LinkedListManager.java`, `Node.java` |
| 3 | Stack for recent actions / history | `LinkedStack.java`, `ActionRecord.java` |
| 4 | Queue for service requests | `LinkedQueue.java`, `ServiceRequest.java` |
| 5 | BST/AVL to organise/search by Student ID | `StudentBST.java` |
| 6 | Hashing for efficient ID search | `StudentHashTable.java` (custom chained hash table) |
| 7-11 | Graph of campus locations/connections, adjacency list, add/remove, display, BFS/DFS | `CampusGraph.java` |
| 12-14 | Add/update/delete/search/display, menu, input validation | `Main.java` |

Each `Student` object is created once and shared by reference across the
linked list, BST, and hash table. Updating a record through any one
structure is therefore reflected consistently in the others, while
deletion explicitly removes the record from all three.

## 4. Project Structure

```
StudentCampusSystem/
├── src/
│   ├── Student.java
│   ├── Node.java
│   ├── LinkedListManager.java
│   ├── LinkedStack.java
│   ├── LinkedQueue.java
│   ├── ActionRecord.java
│   ├── ServiceRequest.java
│   ├── StudentBST.java
│   ├── StudentHashTable.java
│   ├── CampusGraph.java
│   └── Main.java
└── README.md
```

## 5. How to Compile and Run

From the `src/` directory, using the JDK (Java 11+):

```bash
javac -d ../bin *.java
cd ../bin
java Main
```

## 6. Menu

```
 1. Add Student Record
 2. Update Student Record
 3. Delete Student Record
 4. Display All Records using Linked List
 5. Add Service Request to Queue
 6. Process Next Service Request
 7. Display Recent Actions using Stack
 8. Display Students using BST
 9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS or DFS
16. Exit
```

## 7. Testing Notes

The application has been manually tested end-to-end covering every menu
option: adding, updating, deleting and searching student records; enqueuing
and processing service requests; viewing the action-history stack; viewing
records sorted via the BST; adding/removing campus locations and
connections; and running both BFS and DFS traversals. Invalid input
(non-numeric menu choices, out-of-range marks, empty strings, duplicate
IDs, missing locations, unknown connections) is handled with clear error
messages and does not crash the program.

## 8. Suggested Next Steps for the Group

- Fill in the group member table above.
- Divide the code review/demo so each member can explain the file(s)
  matching their assigned responsibility (see the table in Section 3).
- Set up the GitHub repository, and use branches/commits/pull requests to
  show real collaboration, as required by the deliverables section.
- Record the demonstration video, with each member showing their part.
- Follow the submission checklist in the assignment brief exactly
  (Google Drive Editor access for both listed emails if you submit via
  Drive, correct LMS submission before the 29th September deadline).
