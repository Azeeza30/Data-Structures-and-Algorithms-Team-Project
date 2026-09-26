# Member 2 Work: Stack + Queue

## Assigned Responsibility
- **Stack Implementation**: `LinkedStack` class (LIFO) for maintaining recent actions/history
- **Queue Implementation**: `LinkedQueue` class (FIFO) for managing student service requests
- **Action/Request Models**: `ActionRecord` and `ServiceRequest`

## Files in this module
- `Node.java`: Generic node structure used by both Stack and Queue.
- `LinkedStack.java`: Custom linked-node stack for recent actions history.
- `LinkedQueue.java`: Custom linked-node queue for first-in-first-out service requests.
- `ActionRecord.java`: Model capturing action timestamp, type, student ID, and details.
- `ServiceRequest.java`: Model capturing student ID and request description.
- `Member2_Demo.java`: Standalone interactive runner to test Stack and Queue operations.

## How to Compile and Run
From this directory:

```bash
javac *.java
java Member2_Demo
```

## Git Branch
These files are included on the repository's `stack-queue` branch.
