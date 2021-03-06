# Multilevel-Feedback-Queue
In computer science, a multilevel feedback queue is a scheduling algorithm. In a multilevel queue-scheduling algorithm, processes are permanently assigned to a queue on entry to the system. Processes do not move between queues. This setup has the advantage of low scheduling overhead, but the disadvantage of being inflexible. 

### How does MLFQ work
Multilevel feedback queue scheduling, however, allows a process to move between queues. The idea is to separate processes with different CPU-burst characteristics. If a process uses too much CPU time, it will be moved to a lower-priority queue. Similarly, a process that waits too long in a lower-priority queue may be moved to a higher-priority queue. This form of aging prevents starvation.

In general, a multilevel feedback queue scheduler is defined by the following parameters: The number of queues. The scheduling algorithm for each queue. The method used to determine when to upgrade a process to a higher-priority queue. The method used to determine when to demote a process to a lower-priority queue.
