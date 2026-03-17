#include <stdio.h>
#include <stdlib.h>

// Structure for a process node
typedef struct Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    struct Process* next;
} Process;

// Head pointer for circular linked list
Process* head = NULL;

// Function to create a new process node
Process* createProcess(int pid, int burstTime, int priority) {
    Process* newProc = (Process*)malloc(sizeof(Process));
    newProc->pid = pid;
    newProc->burstTime = burstTime;
    newProc->remainingTime = burstTime;
    newProc->priority = priority;
    newProc->next = NULL;
    return newProc;
}

// Add process at end
void addProcess(int pid, int burstTime, int priority) {
    Process* newProc = createProcess(pid, burstTime, priority);
    if (head == NULL) {
        head = newProc;
        newProc->next = head;
    } else {
        Process* temp = head;
        while (temp->next != head)
            temp = temp->next;
        temp->next = newProc;
        newProc->next = head;
    }
}

// Remove process by PID
void removeProcess(int pid) {
    if (head == NULL)
        return;

    Process* temp = head;
    Process* prev = NULL;

    // Special case: head node
    if (head->pid == pid) {
        Process* last = head;
        while (last->next != head)
            last = last->next;
        if (head->next == head) { // only one process
            free(head);
            head = NULL;
        } else {
            last->next = head->next;
            Process* toDelete = head;
            head = head->next;
            free(toDelete);
        }
        return;
    }

    prev = head;
    temp = head->next;
    while (temp != head && temp->pid != pid) {
        prev = temp;
        temp = temp->next;
    }
    if (temp == head) // not found
        return;
    prev->next = temp->next;
    free(temp);
}

// Display all processes
void displayProcesses() {
    if (head == NULL) {
        printf("No processes in the queue.\n");
        return;
    }
    Process* temp = head;
    printf("PID | Burst | Remaining | Priority\n");
    printf("-------------------------------\n");
    do {
        printf("%d | %d | %d | %d\n", temp->pid, temp->burstTime, temp->remainingTime, temp->priority);
        temp = temp->next;
    } while (temp != head);
}

// Round-robin scheduling simulation
void roundRobin(int timeQuantum) {
    if (head == NULL) {
        printf("No processes to schedule.\n");
        return;
    }

    int totalTime = 0, totalWait = 0, totalTurnaround = 0;
    int processCount = 0;
    Process* temp = head;

    // Count total processes
    do {
        processCount++;
        temp = temp->next;
    } while (temp != head);

    int completed = 0;
    printf("\n--- Round Robin Execution ---\n");

    while (head != NULL) {
        Process* current = head;
        do {
            if (current->remainingTime > 0) {
                int execTime = (current->remainingTime > timeQuantum) ? timeQuantum : current->remainingTime;
                printf("Process %d executes for %d units.\n", current->pid, execTime);
                current->remainingTime -= execTime;
                totalTime += execTime;

                if (current->remainingTime == 0) {
                    // Completion, calculate waiting and turnaround times
                    int turnaround = totalTime;
                    int waiting = turnaround - current->burstTime;
                    printf("Process %d completed. Waiting: %d, Turnaround: %d\n", current->pid, waiting, turnaround);
                    totalWait += waiting;
                    totalTurnaround += turnaround;
                    Process* nextProc = current->next;
                    removeProcess(current->pid);
                    current = nextProc;
                    if (head == NULL)
                        break;
                    continue;
                }
            }
            current = current->next;
        } while (current != head);
        printf("\nProcesses in queue after round:\n");
        displayProcesses();
        printf("\n");
    }

    if (processCount > 0) {
        printf("Average Waiting Time: %.2f\n", (float)totalWait / processCount);
        printf("Average Turnaround Time: %.2f\n", (float)totalTurnaround / processCount);
    }
}

// Main menu
int main() {
    int choice, pid, burst, priority, tq;

    while (1) {
        printf("\n--- Round Robin Scheduling ---\n");
        printf("1. Add process\n");
        printf("2. Display processes\n");
        printf("3. Simulate Round-Robin\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter PID, Burst Time, Priority: ");
                scanf("%d %d %d", &pid, &burst, &priority);
                addProcess(pid, burst, priority);
                break;
            case 2:
                displayProcesses();
                break;
            case 3:
                printf("Enter Time Quantum: ");
                scanf("%d", &tq);
                roundRobin(tq);
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }
    return 0;
}