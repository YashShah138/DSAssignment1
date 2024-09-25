import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

      //reads log 
      FileReader fR = new FileReader("log-data.csv");

      //
      BufferedReader bR = new BufferedReader(fR);

      //creat a queue linked list 
       LinkedQueue queue = new LinkedQueue();

       //create a stack linked list
      LinkedStack stack = new LinkedStack();


      //Enqueue all log entries into a queue.
        String line; 
            while ((line = bufferedReader.readLine()) != null) { 
                queue.enqueue(line); 
            } 

      //Dequeue entries one by one until the queue is empty and 
      while(!queue.isEmpty()){

        if (queue.dequeue().equals("ERROR"))//FIX, this is the idea but the log entry needs to be parsed to compare 
         stack.push(queue.dequeue());
        
        
        {

     

          
          

      //close both fR and bR
      bReader.close(); 
      fReader.close(); 
    }
}
