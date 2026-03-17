#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define the structure for a student node
typedef struct Student {
    int rollNumber;
    char name[50];
    int age;
    char grade;
    struct Student* next;
} Student;

// Head pointer for the linked list
Student* head = NULL;

// Function to create a new student node
Student* createStudent(int roll, char name[], int age, char grade) {
    Student* newStudent = (Student*)malloc(sizeof(Student));
    newStudent->rollNumber = roll;
    strcpy(newStudent->name, name);
    newStudent->age = age;
    newStudent->grade = grade;
    newStudent->next = NULL;
    return newStudent;
}

// Add at the beginning
void addAtBeginning(int roll, char name[], int age, char grade) {
    Student* newStudent = createStudent(roll, name, age, grade);
    newStudent->next = head;
    head = newStudent;
}

// Add at the end
void addAtEnd(int roll, char name[], int age, char grade) {
    Student* newStudent = createStudent(roll, name, age, grade);
    if (head == NULL) {
        head = newStudent;
        return;
    }
    Student* temp = head;
    while (temp->next != NULL)
        temp = temp->next;
    temp->next = newStudent;
}

// Add at a specific position (1-based index)
void addAtPosition(int roll, char name[], int age, char grade, int pos) {
    if (pos == 1) {
        addAtBeginning(roll, name, age, grade);
        return;
    }
    Student* newStudent = createStudent(roll, name, age, grade);
    Student* temp = head;
    for (int i = 1; i < pos - 1 && temp != NULL; i++)
        temp = temp->next;
    if (temp == NULL) {
        printf("Position out of bounds.\n");
        free(newStudent);
        return;
    }
    newStudent->next = temp->next;
    temp->next = newStudent;
}

// Delete by roll number
void deleteByRoll(int roll) {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }
    if (head->rollNumber == roll) {
        Student* temp = head;
        head = head->next;
        free(temp);
        printf("Record deleted.\n");
        return;
    }
    Student* temp = head;
    while (temp->next != NULL && temp->next->rollNumber != roll)
        temp = temp->next;
    if (temp->next == NULL) {
        printf("Record not found.\n");
        return;
    }
    Student* toDelete = temp->next;
    temp->next = temp->next->next;
    free(toDelete);
    printf("Record deleted.\n");
}

// Search by roll number
Student* searchByRoll(int roll) {
    Student* temp = head;
    while (temp != NULL) {
        if (temp->rollNumber == roll)
            return temp;
        temp = temp->next;
    }
    return NULL;
}

// Update grade by roll number
void updateGrade(int roll, char newGrade) {
    Student* student = searchByRoll(roll);
    if (student == NULL) {
        printf("Student not found.\n");
        return;
    }
    student->grade = newGrade;
    printf("Grade updated.\n");
}

// Display all student records
void displayAll() {
    if (head == NULL) {
        printf("No records to display.\n");
        return;
    }
    Student* temp = head;
    printf("Roll\tName\t\tAge\tGrade\n");
    printf("-------------------------------------\n");
    while (temp != NULL) {
        printf("%d\t%s\t\t%d\t%c\n", temp->rollNumber, temp->name, temp->age, temp->grade);
        temp = temp->next;
    }
}

// Main menu
int main() {
    int choice, roll, age, pos;
    char name[50], grade;

    while (1) {
        printf("\n--- Student Record Management ---\n");
        printf("1. Add at beginning\n");
        printf("2. Add at end\n");
        printf("3. Add at position\n");
        printf("4. Delete by roll number\n");
        printf("5. Search by roll number\n");
        printf("6. Update grade\n");
        printf("7. Display all records\n");
        printf("8. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter Roll, Name, Age, Grade: ");
                scanf("%d %s %d %c", &roll, name, &age, &grade);
                addAtBeginning(roll, name, age, grade);
                break;
            case 2:
                printf("Enter Roll, Name, Age, Grade: ");
                scanf("%d %s %d %c", &roll, name, &age, &grade);
                addAtEnd(roll, name, age, grade);
                break;
            case 3:
                printf("Enter Roll, Name, Age, Grade, Position: ");
                scanf("%d %s %d %c %d", &roll, name, &age, &grade, &pos);
                addAtPosition(roll, name, age, grade, pos);
                break;
            case 4:
                printf("Enter Roll Number to delete: ");
                scanf("%d", &roll);
                deleteByRoll(roll);
                break;
            case 5:
                printf("Enter Roll Number to search: ");
                scanf("%d", &roll);
                Student* s = searchByRoll(roll);
                if (s != NULL)
                    printf("Found: %d %s %d %c\n", s->rollNumber, s->name, s->age, s->grade);
                else
                    printf("Student not found.\n");
                break;
            case 6:
                printf("Enter Roll Number and new Grade: ");
                scanf("%d %c", &roll, &grade);
                updateGrade(roll, grade);
                break;
            case 7:
                displayAll();
                break;
            case 8:
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }

    return 0;
}