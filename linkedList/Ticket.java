#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Ticket {
    int ticketID;
    char customer[50];
    char movie[50];
    int seat;
    char bookingTime[20];
    struct Ticket* next;
} Ticket;

Ticket* head = NULL;

// Add ticket at end
void addTicket(int id, char customer[], char movie[], int seat, char time[]) {
    Ticket* t = (Ticket*)malloc(sizeof(Ticket));
    t->ticketID = id;
    strcpy(t->customer, customer);
    strcpy(t->movie, movie);
    t->seat = seat;
    strcpy(t->bookingTime, time);
    if (!head) {
        head = t;
        t->next = head;
    } else {
        Ticket* temp = head;
        while (temp->next != head) temp = temp->next;
        temp->next = t;
        t->next = head;
    }
}

// Remove ticket by ID
void removeTicket(int id) {
    if (!head) return;
    Ticket* temp = head;
    Ticket* prev = NULL;
    // Head case
    if (head->ticketID == id) {
        Ticket* last = head;
        while (last->next != head) last = last->next;
        if (head->next == head) {
            free(head);
            head = NULL;
        } else {
            last->next = head->next;
            Ticket* toDelete = head;
            head = head->next;
            free(toDelete);
        }
        return;
    }
    prev = head;
    temp = head->next;
    while (temp != head && temp->ticketID != id) {
        prev = temp;
        temp = temp->next;
    }
    if (temp == head) return;
    prev->next = temp->next;
    free(temp);
}

// Display tickets
void displayTickets() {
    if (!head) { printf("No tickets booked.\n"); return; }
    Ticket* temp = head;
    printf("ID | Customer | Movie | Seat | Time\n");
    printf("----------------------------------\n");
    do {
        printf("%d | %s | %s | %d | %s\n", temp->ticketID, temp->customer, temp->movie, temp->seat, temp->bookingTime);
        temp = temp->next;
    } while (temp != head);
}

// Search by customer or movie
void searchTicket(char name[]) {
    if (!head) { printf("No tickets booked.\n"); return; }
    Ticket* temp = head;
    int found = 0;
    do {
        if (strcmp(temp->customer, name) == 0 || strcmp(temp->movie, name) == 0) {
            printf("%d | %s | %s | %d | %s\n", temp->ticketID, temp->customer, temp->movie, temp->seat, temp->bookingTime);
            found = 1;
        }
        temp = temp->next;
    } while (temp != head);
    if (!found) printf("No matching tickets.\n");
}

// Count tickets
int countTickets() {
    if (!head) return 0;
    int count = 0;
    Ticket* temp = head;
    do { count++; temp = temp->next; } while (temp != head);
    return count;
}