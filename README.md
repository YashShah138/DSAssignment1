# **CS 2341** 
## Assignment 1
* @author: Yash Shah
* @duedate: September 29, 2024

### Objective
- Use stacks and queues to process a log file containing 10,000 entries
- Log Entry Format Example:
    - [ 2024-08-23 14:35:21] INFO User123 logged in
    - [ 2024-08-23 14:35:22] ERROR Database connection failed
    - [ 2024-08-23 14:35:23] WARN Memory usage at 85 %

### Tasks
1. Implement Queue Operations:
    - Read the log file into your program.
    - Enqueue all log entries into a queue.
    - Dequeue entries one by one until the queue is empty (do not print them)
2. Implement Stack Operations:
    - Implement a stack to handle and store error log entries (log level: ERROR).
    - Every time an error log entry is dequeued from the queue, it should be pushed onto the stack.
3. Data Analysis
    - Implement functionality to perform the following analysis on the log data:
       1. Count Log Levels: Calculate the total number of entries for each log level (INFO, WARN, ERROR). Hint: Do the calculations during dequeue.
       2. Recent Errors: Provide a list of the last 100 errors that occurred.
       3. Memory Warnings: Track how many times a memory warning (log level: WARN, containing "Memory") appears.
4. Performance Considerations:
    - Your implementation should be efficient in terms of time and space,
       especially given the large dataset.
    - Consider the use of appropriate data structures and algorithms t- handle the high volume of log entries. Solution hint: Use linked list for the implementation of both queue and stack.