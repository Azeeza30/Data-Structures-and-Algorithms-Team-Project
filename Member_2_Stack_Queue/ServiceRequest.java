/**
 * Represents one student service request waiting in the queue.
 * Member 2 Work: Stack + Queue
 */
public class ServiceRequest {
    private final String studentId;
    private final String requestDescription;

    public ServiceRequest(String studentId, String requestDescription) {
        this.studentId = studentId;
        this.requestDescription = requestDescription;
    }

    public String getStudentId() { return studentId; }
    public String getRequestDescription() { return requestDescription; }

    @Override
    public String toString() {
        return "Student ID: " + studentId + " | Request: " + requestDescription;
    }
}
