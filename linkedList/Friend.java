#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Friend {
    int friendID;
    struct Friend* next;
} Friend;

typedef struct User {
    int userID;
    char name[50];
    int age;
    Friend* friends;
    struct User* next;
} User;

User* head = NULL;

// Create a new user
User* createUser(int id, char name[], int age) {
    User* u = (User*)malloc(sizeof(User));
    u->userID = id;
    strcpy(u->name, name);
    u->age = age;
    u->friends = NULL;
    u->next = NULL;
    return u;
}

// Add user
void addUser(int id, char name[], int age) {
    User* u = createUser(id, name, age);
    u->next = head;
    head = u;
}

// Find user by ID
User* findUserByID(int id) {
    User* temp = head;
    while (temp != NULL) {
        if (temp->userID == id) return temp;
        temp = temp->next;
    }
    return NULL;
}

// Add friend connection
void addFriend(int userID, int friendID) {
    User* user = findUserByID(userID);
    User* fr = findUserByID(friendID);
    if (!user || !fr) {
        printf("User(s) not found.\n");
        return;
    }
    // Add friendID to user's friend list
    Friend* f = (Friend*)malloc(sizeof(Friend));
    f->friendID = friendID;
    f->next = user->friends;
    user->friends = f;
    printf("Friend added.\n");
}

// Remove friend connection
void removeFriend(int userID, int friendID) {
    User* user = findUserByID(userID);
    if (!user) return;
    Friend* temp = user->friends;
    Friend* prev = NULL;
    while (temp && temp->friendID != friendID) {
        prev = temp;
        temp = temp->next;
    }
    if (!temp) { printf("Friend not found.\n"); return; }
    if (prev) prev->next = temp->next;
    else user->friends = temp->next;
    free(temp);
    printf("Friend removed.\n");
}

// Display friends of a user
void displayFriends(int userID) {
    User* user = findUserByID(userID);
    if (!user) { printf("User not found.\n"); return; }
    Friend* temp = user->friends;
    printf("Friends of %s: ", user->name);
    while (temp) {
        printf("%d ", temp->friendID);
        temp = temp->next;
    }
    printf("\n");
}

// Count number of friends
int countFriends(int userID) {
    User* user = findUserByID(userID);
    if (!user) return 0;
    int count = 0;
    Friend* temp = user->friends;
    while (temp) { count++; temp = temp->next; }
    return count;
}

// Find mutual friends
void mutualFriends(int user1ID, int user2ID) {
    User* u1 = findUserByID(user1ID);
    User* u2 = findUserByID(user2ID);
    if (!u1 || !u2) { printf("User(s) not found.\n"); return; }
    printf("Mutual Friends: ");
    for (Friend* f1 = u1->friends; f1; f1 = f1->next) {
        for (Friend* f2 = u2->friends; f2; f2 = f2->next) {
            if (f1->friendID == f2->friendID) printf("%d ", f1->friendID);
        }
    }
    printf("\n");
}