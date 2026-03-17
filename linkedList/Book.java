#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Structure for a book
typedef struct Book {
    int bookID;
    char title[100];
    char author[50];
    char genre[30];
    int available; // 1 = available, 0 = checked out
    struct Book* next;
    struct Book* prev;
} Book;

// Head and tail pointers
Book* head = NULL;
Book* tail = NULL;

// Function to create a new book node
Book* createBook(int id, char title[], char author[], char genre[], int available) {
    Book* newBook = (Book*)malloc(sizeof(Book));
    newBook->bookID = id;
    strcpy(newBook->title, title);
    strcpy(newBook->author, author);
    strcpy(newBook->genre, genre);
    newBook->available = available;
    newBook->next = NULL;
    newBook->prev = NULL;
    return newBook;
}

// Add at beginning
void addAtBeginning(int id, char title[], char author[], char genre[], int available) {
    Book* newBook = createBook(id, title, author, genre, available);
    if (head == NULL) {
        head = tail = newBook;
    } else {
        newBook->next = head;
        head->prev = newBook;
        head = newBook;
    }
}

// Add at end
void addAtEnd(int id, char title[], char author[], char genre[], int available) {
    Book* newBook = createBook(id, title, author, genre, available);
    if (tail == NULL) {
        head = tail = newBook;
    } else {
        tail->next = newBook;
        newBook->prev = tail;
        tail = newBook;
    }
}

// Add at position (1-based)
void addAtPosition(int id, char title[], char author[], char genre[], int available, int pos) {
    if (pos == 1) {
        addAtBeginning(id, title, author, genre, available);
        return;
    }
    Book* temp = head;
    int count = 1;
    while (count < pos - 1 && temp != NULL) {
        temp = temp->next;
        count++;
    }
    if (temp == NULL) {
        printf("Position out of bounds.\n");
        return;
    }
    Book* newBook = createBook(id, title, author, genre, available);
    newBook->next = temp->next;
    newBook->prev = temp;
    if (temp->next != NULL)
        temp->next->prev = newBook;
    temp->next = newBook;
    if (newBook->next == NULL) // Update tail
        tail = newBook;
}

// Remove book by ID
void removeByID(int id) {
    Book* temp = head;
    while (temp != NULL && temp->bookID != id)
        temp = temp->next;
    if (temp == NULL) {
        printf("Book not found.\n");
        return;
    }
    if (temp->prev != NULL)
        temp->prev->next = temp->next;
    else
        head = temp->next;

    if (temp->next != NULL)
        temp->next->prev = temp->prev;
    else
        tail = temp->prev;

    free(temp);
    printf("Book removed.\n");
}

// Search by Title
void searchByTitle(char title[]) {
    Book* temp = head;
    int found = 0;
    while (temp != NULL) {
        if (strcmp(temp->title, title) == 0) {
            printf("%d | %s | %s | %s | %s\n", temp->bookID, temp->title, temp->author,
                   temp->genre, temp->available ? "Available" : "Checked Out");
            found = 1;
        }
        temp = temp->next;
    }
    if (!found)
        printf("Book not found.\n");
}

// Search by Author
void searchByAuthor(char author[]) {
    Book* temp = head;
    int found = 0;
    while (temp != NULL) {
        if (strcmp(temp->author, author) == 0) {
            printf("%d | %s | %s | %s | %s\n", temp->bookID, temp->title, temp->author,
                   temp->genre, temp->available ? "Available" : "Checked Out");
            found = 1;
        }
        temp = temp->next;
    }
    if (!found)
        printf("No books found by this author.\n");
}

// Update availability status
void updateAvailability(int id, int status) {
    Book* temp = head;
    while (temp != NULL && temp->bookID != id)
        temp = temp->next;
    if (temp == NULL) {
        printf("Book not found.\n");
        return;
    }
    temp->available = status;
    printf("Availability updated.\n");
}

// Display all books forward
void displayForward() {
    if (head == NULL) {
        printf("Library is empty.\n");
        return;
    }
    printf("ID | Title | Author | Genre | Availability\n");
    printf("-------------------------------------------\n");
    Book* temp = head;
    while (temp != NULL) {
        printf("%d | %s | %s | %s | %s\n", temp->bookID, temp->title, temp->author,
               temp->genre, temp->available ? "Available" : "Checked Out");
        temp = temp->next;
    }
}

// Display all books backward
void displayBackward() {
    if (tail == NULL) {
        printf("Library is empty.\n");
        return;
    }
    printf("ID | Title | Author | Genre | Availability (Reverse)\n");
    printf("---------------------------------------------------\n");
    Book* temp = tail;
    while (temp != NULL) {
        printf("%d | %s | %s | %s | %s\n", temp->bookID, temp->title, temp->author,
               temp->genre, temp->available ? "Available" : "Checked Out");
        temp = temp->prev;
    }
}

// Count total books
void countBooks() {
    int count = 0;
    Book* temp = head;
    while (temp != NULL) {
        count++;
        temp = temp->next;
    }
    printf("Total number of books: %d\n", count);
}

// Main menu
int main() {
    int choice, id, available, pos;
    char title[100], author[50], genre[30];

    while (1) {
        printf("\n--- Library Management System ---\n");
        printf("1. Add book at beginning\n");
        printf("2. Add book at end\n");
        printf("3. Add book at position\n");
        printf("4. Remove book by ID\n");
        printf("5. Search by Title\n");
        printf("6. Search by Author\n");
        printf("7. Update availability\n");
        printf("8. Display all books forward\n");
        printf("9. Display all books backward\n");
        printf("10. Count total books\n");
        printf("11. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                printf("Enter ID, Title, Author, Genre, Availability (1=Available,0=Checked Out): ");
                scanf("%d %s %s %s %d", &id, title, author, genre, &available);
                addAtBeginning(id, title, author, genre, available);
                break;
            case 2:
                printf("Enter ID, Title, Author, Genre, Availability: ");
                scanf("%d %s %s %s %d", &id, title, author, genre, &available);
                addAtEnd(id, title, author, genre, available);
                break;
            case 3:
                printf("Enter ID, Title, Author, Genre, Availability, Position: ");
                scanf("%d %s %s %s %d %d", &id, title, author, genre, &available, &pos);
                addAtPosition(id, title, author, genre, available, pos);
                break;
            case 4:
                printf("Enter Book ID to remove: ");
                scanf("%d", &id);
                removeByID(id);
                break;
            case 5:
                printf("Enter Title to search: ");
                scanf("%s", title);
                searchByTitle(title);
                break;
            case 6:
                printf("Enter Author to search: ");
                scanf("%s", author);
                searchByAuthor(author);
                break;
            case 7:
                printf("Enter Book ID and Availability (1=Available,0=Checked Out): ");
                scanf("%d %d", &id, &available);
                updateAvailability(id, available);
                break;
            case 8:
                displayForward();
                break;
            case 9:
                displayBackward();
                break;
            case 10:
                countBooks();
                break;
            case 11:
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }
    return 0;
}