import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents one entry in the recent-actions history stack.
 * Member 2 Work: Stack + Queue
 */
public class ActionRecord {
    private final String actionType;
    private final String studentId;
    private final String details;
    private final String timestamp;

    public ActionRecord(String actionType, String studentId, String details) {
        this.actionType = actionType;
        this.studentId = studentId;
        this.details = details;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getActionType() { return actionType; }
    public String getStudentId() { return studentId; }
    public String getDetails() { return details; }
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("[%s] %-8s | Student ID: %-10s | %s", timestamp, actionType, studentId, details);
    }
}
