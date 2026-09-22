import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents one entry in the recent-actions history stack.
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

    @Override
    public String toString() {
        return String.format("[%s] %-8s | Student ID: %-10s | %s", timestamp, actionType, studentId, details);
    }
}
