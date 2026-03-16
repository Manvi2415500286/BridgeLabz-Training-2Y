#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define the structure for a task node
typedef struct Task {
    int taskID;
    char taskName[50];
    int priority;
    char dueDate[20];
    struct Task* next;
} Task;

// Head pointer for circular linked list
Task* head = NULL;
Task* current = NULL; // Pointer to keep track of current task

// Function to create a new task node
Task* createTask(int id, char name[], int priority, char dueDate[]) {
    Task* newTask = (Task*)malloc(sizeof(Task));
    newTask->taskID = id;
    strcpy(newTask->taskName, name);
    newTask->priority = priority;
    strcpy(newTask->dueDate, dueDate);
    newTask->next = NULL;
    return newTask;
}

// Add at beginning
void addAtBeginning(int id, char name[], int priority, char dueDate[]) {
    Task* newTask = createTask(id, name, priority, dueDate);
    if (head == NULL) {
        head = newTask;
        newTask->next = head;
    } else {
        Task* temp = head;
        while (temp->next != head) // Move to last node
            temp = temp->next;
        temp->next = newTask;
        newTask->next = head;
        head = newTask;
    }
}

// Add at end
void addAtEnd(int id, char name[], int priority, char dueDate[]) {
    Task* newTask = createTask(id, name, priority, dueDate);
    if (head == NULL) {
        head = newTask;
        newTask->next = head;
    } else {
        Task* temp = head;
        while (temp->next != head)
            temp = temp->next;
        temp->next = newTask;
        newTask->next = head;
    }
}

// Add at specific position (1-based index)
void addAtPosition(int id, char name[], int priority, char dueDate[], int pos) {
    if (pos == 1) {
        addAtBeginning(id, name, priority, dueDate);
        return;
    }
    Task* newTask = createTask(id, name, priority, dueDate);
    Task* temp = head;
    int count = 1;
    while (count < pos - 1 && temp->next != head) {
        temp = temp->next;
        count++;
    }
    if (count != pos - 1) {
        printf("Position out of bounds.\n");
        free(newTask);
        return;
    }
    newTask->next = temp->next;
    temp->next = newTask;
}

// Remove by Task ID
void removeByID(int id) {
    if (head == NULL) {
        printf("Task list is empty.\n");
        return;
    }

    Task* temp = head;
    Task* prev = NULL;

    // Special case: head node
    if (head->taskID == id) {
        // Find last node to update its next pointer
        Task* last = head;
        while (last->next != head)
            last = last->next;
        if (head->next == head) { // Only one node
            free(head);
            head = NULL;
        } else {
            Task* toDelete = head;
            head = head->next;
            last->next = head;
            free(toDelete);
        }
        printf("Task removed.\n");
        return;
    }

    prev = head;
    temp = head->next;
    while (temp != head && temp->taskID != id) {
        prev = temp;
        temp = temp->next;
    }
    if (temp == head) {
        printf("Task not found.\n");
        return;
    }
    prev->next = temp->next;
    free(temp);
    printf("Task removed.\n");
}

// View current task
void viewCurrentTask() {
    if (current == NULL) {
        if (head == NULL) {
            printf("No tasks in the list.\n");
            return;
        }
        current = head;
    }
    printf("Current Task: %d | %s | Priority: %d | Due: %s\n",
           current->taskID, current->taskName, current->priority, current->dueDate);
}

// Move to next task
void moveToNextTask() {
    if (current == NULL) {
        if (head == NULL) {
            printf("No tasks in the list.\n");
            return;
        }
        current = head;
    } else {
        current = current->next;
    }
    viewCurrentTask();
}

// Display all tasks
void displayAll() {
    if (head == NULL) {
        printf("No tasks to display.\n");
        return;
    }
    Task* temp = head;
    printf("Task ID | Task Name | Priority | Due Date\n");
    printf("-------------------------------------------\n");
    do {
        printf("%d | %s | %d | %s\n", temp->taskID, temp->taskName, temp->priority, temp->dueDate);
        temp = temp->next;
    } while (temp != head);
}

// Search by priority
void searchByPriority(int priority) {
    if (head == NULL) {
        printf("No tasks to search.\n");
        return;
    }
    Task* temp = head;
    int found = 0;
    do {
        if (temp->priority == priority) {
            printf("%d | %s | %d | %s\n", temp->taskID, temp->taskName, temp->priority, temp->dueDate);
            found = 1;
        }
        temp = temp->next;
    } while (temp != head);
    if (!found)
        printf("No tasks found with priority %d.\n", priority);
}

// Main menu
int main() {
    int choice, id, priority, pos;
    char taskName[50], dueDate[20];

    while (1) {
        printf("\n--- Task Scheduler ---\n");
        printf("1. Add task at beginning\n");
        printf("2. Add task at end\n");
        printf("3. Add task at position\n");
        printf("4. Remove task by ID\n");
        printf("5. View current task\n");
        printf("6. Move to next task\n");
        printf("7. Display all tasks\n");
        printf("8. Search by priority\n");
        printf("9. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter Task ID, Name, Priority, Due Date: ");
                scanf("%d %s %d %s", &id, taskName, &priority, dueDate);
                addAtBeginning(id, taskName, priority, dueDate);
                break;
            case 2:
                printf("Enter Task ID, Name, Priority, Due Date: ");
                scanf("%d %s %d %s", &id, taskName, &priority, dueDate);
                addAtEnd(id, taskName, priority, dueDate);
                break;
            case 3:
                printf("Enter Task ID, Name, Priority, Due Date, Position: ");
                scanf("%d %s %d %s %d", &id, taskName, &priority, dueDate, &pos);
                addAtPosition(id, taskName, priority, dueDate, pos);
                break;
            case 4:
                printf("Enter Task ID to remove: ");
                scanf("%d", &id);
                removeByID(id);
                break;
            case 5:
                viewCurrentTask();
                break;
            case 6:
                moveToNextTask();
                break;
            case 7:
                displayAll();
                break;
            case 8:
                printf("Enter priority to search: ");
                scanf("%d", &priority);
                searchByPriority(priority);
                break;
            case 9:
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }
    return 0;
}