import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;

public class TestClient {
    public static void main(String[] args) throws IOException {
        //creat a queue linked list 
        LinkedQueue<String> queue = new LinkedQueue<>();
        
        //create a stack linked list
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

        LinkedStack<String> topErrors = new LinkedStack<>();
        int recentErrorsMax = 100;

        //Dequeue entries one by one until the queue is empty and 
        while(!queue.isEmpty()) {

            String logEntry = queue.dequeue();

            String[] logParts = logEntry.split(" ", 4);
            if (logParts.length < 3) continue;
            String logLevel = logParts[2];

            if (logLevel.equals("INFO")) {
                infoCount++;
            } else if (logLevel.equals("WARN")) {
                warnCount++;
                if (logEntry.contains("Memory")) {
                    memoryWarningCount++;
                }
            } else if (logLevel.equals("ERROR")) {
                errorCount++;
                stack.push(logEntry);

                if (topErrors.size() == recentErrorsMax) {
                    topErrors.pop();
                }
                topErrors.push(logEntry);
            }

            
        }

        // Display results of data analysis
        System.out.println("\033[0;1m" + "\nLog Levels Count: " + "\033[0m");
        System.out.println("INFO: " + infoCount);
        System.out.println("WARN: " + warnCount);
        System.out.println("ERROR: " + errorCount);
        System.out.println("Memory Warnings: " + memoryWarningCount);

        System.out.println("\033[0;1m" + "\nRecent 100 Errors " + "\033[0m");
        while (!topErrors.isEmpty()) {
            System.out.println(topErrors.pop());
        }
    }
}
