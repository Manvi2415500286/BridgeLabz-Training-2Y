#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_HISTORY 10

typedef struct State {
    char text[100];
    struct State* prev;
    struct State* next;
} State;

State* head = NULL;
State* current = NULL;
int historySize = 0;

// Add new state
void addState(char text[]) {
    State* s = (State*)malloc(sizeof(State));
    strcpy(s->text, text);
    s->prev = current;
    s->next = NULL;
    if (current) current->next = s;
    current = s;
    if (!head) head = s;
    historySize++;
    // Limit history
    State* temp = head;
    int count = 1;
    while (temp && count < historySize - MAX_HISTORY) {
        State* toDelete = temp;
        temp = temp->next;
        free(toDelete);
        head = temp;
        if (temp) temp->prev = NULL;
    }
}

// Undo
void undo() {
    if (current && current->prev) current = current->prev;
    printf("Current State: %s\n", current->text);
}

// Redo
void redo() {
    if (current && current->next) current = current->next;
    printf("Current State: %s\n", current->text);
}

// Display current
void displayCurrent() {
    if (current) printf("Current Text: %s\n", current->text);
    else printf("No text available.\n");
}