import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestClient {
    public static void main(String[] args) throws IOException {
        // Create a queue linked list
        LinkedQueue<String> queue = new LinkedQueue<>();

        // Create a stack linked list
        LinkedStack<String> stack = new LinkedStack<>();

        // Counters
        int infoCount = 0, warnCount = 0, errorCount = 0;
        int memoryWarningCount = 0;

        // Reading the log file (assuming the log is stored in logs.txt)
        BufferedReader br = new BufferedReader(new FileReader("log-data.csv"));
        String line;

        while ((line = br.readLine()) != null) {
            queue.enqueue(line);
        }
        br.close();

        // Stack to store the most recent 100 errors
        LinkedStack<String> recentErrors = new LinkedStack<>();
        int recentErrorsMax = 100;

        // Dequeue entries one by one until the queue is empty
        while (!queue.isEmpty()) {
            String logEntry = queue.dequeue();

            String[] logParts = logEntry.split(" ", 4);
            if (logParts.length < 3)
                continue;
            String logLevel = logParts[2];

            if (logLevel.equals("INFO")) {
                infoCount++;
            } else if (logLevel.equals("WARN")) {
                warnCount++;
                if (logEntry.equals("Memory")) {
                    memoryWarningCount++;
                }
            } else if (logLevel.equals("ERROR")) {
                errorCount++;
                stack.push(logEntry);

                if (recentErrors.size() == recentErrorsMax) {
                    recentErrors.pop();  // Remove the oldest error (bottom of the stack)
                }
                recentErrors.push(logEntry);  // Push the latest error (top of the stack)
            }
        }

        // Display all data
        System.out.println("\033[0;1m" + "\nLog Levels Count: " + "\033[0m");
        System.out.println("INFO: " + infoCount);
        System.out.println("WARN: " + warnCount);
        System.out.println("Memory Warnings: " + memoryWarningCount);
        System.out.println("ERROR: " + errorCount);

        // Use a temp stack to correct the order of printing
        System.out.println("\nThe Most Recent 100 Errors: ");
        LinkedStack<String> tempStack = new LinkedStack<>();

        // Reverse the order by popping from recentErrors and pushing to tempStack
        while (!recentErrors.isEmpty()) {
            tempStack.push(recentErrors.pop());
        }

        // Now print the errors in the correct order
        while (!tempStack.isEmpty()) {
            System.out.println(tempStack.pop());
        }
    }
}
