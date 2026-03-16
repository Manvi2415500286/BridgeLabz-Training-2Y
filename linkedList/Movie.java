#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define the structure for a movie node
typedef struct Movie {
    char title[100];
    char director[50];
    int year;
    float rating;
    struct Movie* next;
    struct Movie* prev;
} Movie;

// Head and tail pointers for the doubly linked list
Movie* head = NULL;
Movie* tail = NULL;

// Function to create a new movie node
Movie* createMovie(char title[], char director[], int year, float rating) {
    Movie* newMovie = (Movie*)malloc(sizeof(Movie));
    strcpy(newMovie->title, title);
    strcpy(newMovie->director, director);
    newMovie->year = year;
    newMovie->rating = rating;
    newMovie->next = NULL;
    newMovie->prev = NULL;
    return newMovie;
}

// Add at beginning
void addAtBeginning(char title[], char director[], int year, float rating) {
    Movie* newMovie = createMovie(title, director, year, rating);
    if (head == NULL) {
        head = tail = newMovie;
    } else {
        newMovie->next = head;
        head->prev = newMovie;
        head = newMovie;
    }
}

// Add at end
void addAtEnd(char title[], char director[], int year, float rating) {
    Movie* newMovie = createMovie(title, director, year, rating);
    if (tail == NULL) {
        head = tail = newMovie;
    } else {
        tail->next = newMovie;
        newMovie->prev = tail;
        tail = newMovie;
    }
}

// Add at a specific position (1-based index)
void addAtPosition(char title[], char director[], int year, float rating, int pos) {
    if (pos == 1) {
        addAtBeginning(title, director, year, rating);
        return;
    }
    Movie* newMovie = createMovie(title, director, year, rating);
    Movie* temp = head;
    for (int i = 1; i < pos - 1 && temp != NULL; i++)
        temp = temp->next;
    if (temp == NULL) {
        printf("Position out of bounds.\n");
        free(newMovie);
        return;
    }
    newMovie->next = temp->next;
    newMovie->prev = temp;
    if (temp->next != NULL)
        temp->next->prev = newMovie;
    temp->next = newMovie;
    if (newMovie->next == NULL)  // Update tail if inserted at end
        tail = newMovie;
}

// Remove by movie title
void removeByTitle(char title[]) {
    Movie* temp = head;
    while (temp != NULL && strcmp(temp->title, title) != 0)
        temp = temp->next;
    if (temp == NULL) {
        printf("Movie not found.\n");
        return;
    }
    if (temp->prev != NULL)
        temp->prev->next = temp->next;
    else
        head = temp->next; // Removing head

    if (temp->next != NULL)
        temp->next->prev = temp->prev;
    else
        tail = temp->prev; // Removing tail

    free(temp);
    printf("Movie removed.\n");
}

// Search by director
void searchByDirector(char director[]) {
    Movie* temp = head;
    int found = 0;
    while (temp != NULL) {
        if (strcmp(temp->director, director) == 0) {
            printf("%s | %s | %d | %.1f\n", temp->title, temp->director, temp->year, temp->rating);
            found = 1;
        }
        temp = temp->next;
    }
    if (!found)
        printf("No movies found by director %s.\n", director);
}

// Search by rating
void searchByRating(float rating) {
    Movie* temp = head;
    int found = 0;
    while (temp != NULL) {
        if (temp->rating == rating) {
            printf("%s | %s | %d | %.1f\n", temp->title, temp->director, temp->year, temp->rating);
            found = 1;
        }
        temp = temp->next;
    }
    if (!found)
        printf("No movies found with rating %.1f.\n", rating);
}

// Update movie rating by title
void updateRating(char title[], float newRating) {
    Movie* temp = head;
    while (temp != NULL && strcmp(temp->title, title) != 0)
        temp = temp->next;
    if (temp == NULL) {
        printf("Movie not found.\n");
        return;
    }
    temp->rating = newRating;
    printf("Rating updated.\n");
}

// Display all movies forward
void displayForward() {
    if (head == NULL) {
        printf("No movies to display.\n");
        return;
    }
    printf("Title | Director | Year | Rating\n");
    printf("------------------------------------\n");
    Movie* temp = head;
    while (temp != NULL) {
        printf("%s | %s | %d | %.1f\n", temp->title, temp->director, temp->year, temp->rating);
        temp = temp->next;
    }
}

// Display all movies backward
void displayBackward() {
    if (tail == NULL) {
        printf("No movies to display.\n");
        return;
    }
    printf("Title | Director | Year | Rating (Reverse)\n");
    printf("------------------------------------------\n");
    Movie* temp = tail;
    while (temp != NULL) {
        printf("%s | %s | %d | %.1f\n", temp->title, temp->director, temp->year, temp->rating);
        temp = temp->prev;
    }
}

// Main menu
int main() {
    int choice, pos, year;
    char title[100], director[50];
    float rating;

    while (1) {
        printf("\n--- Movie Management System ---\n");
        printf("1. Add at beginning\n");
        printf("2. Add at end\n");
        printf("3. Add at position\n");
        printf("4. Remove by title\n");
        printf("5. Search by director\n");
        printf("6. Search by rating\n");
        printf("7. Update rating\n");
        printf("8. Display forward\n");
        printf("9. Display backward\n");
        printf("10. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter Title, Director, Year, Rating: ");
                scanf(" %[^\n]s", title);
                scanf(" %[^\n]s", director);
                scanf("%d %f", &year, &rating);
                addAtBeginning(title, director, year, rating);
                break;
            case 2:
                printf("Enter Title, Director, Year, Rating: ");
                scanf(" %[^\n]s", title);
                scanf(" %[^\n]s", director);
                scanf("%d %f", &year, &rating);
                addAtEnd(title, director, year, rating);
                break;
            case 3:
                printf("Enter Title, Director, Year, Rating, Position: ");
                scanf(" %[^\n]s", title);
                scanf(" %[^\n]s", director);
                scanf("%d %f %d", &year, &rating, &pos);
                addAtPosition(title, director, year, rating, pos);
                break;
            case 4:
                printf("Enter Title to remove: ");
                scanf(" %[^\n]s", title);
                removeByTitle(title);
                break;
            case 5:
                printf("Enter Director to search: ");
                scanf(" %[^\n]s", director);
                searchByDirector(director);
                break;
            case 6:
                printf("Enter Rating to search: ");
                scanf("%f", &rating);
                searchByRating(rating);
                break;
            case 7:
                printf("Enter Title and new Rating: ");
                scanf(" %[^\n]s", title);
                scanf("%f", &rating);
                updateRating(title, rating);
                break;
            case 8:
                displayForward();
                break;
            case 9:
                displayBackward();
                break;
            case 10:
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }
    return 0;
}