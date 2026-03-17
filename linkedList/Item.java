#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define structure for inventory item
typedef struct Item {
    int itemID;
    char itemName[50];
    int quantity;
    float price;
    struct Item* next;
} Item;

// Head pointer for singly linked list
Item* head = NULL;

// Function to create a new item
Item* createItem(int id, char name[], int quantity, float price) {
    Item* newItem = (Item*)malloc(sizeof(Item));
    newItem->itemID = id;
    strcpy(newItem->itemName, name);
    newItem->quantity = quantity;
    newItem->price = price;
    newItem->next = NULL;
    return newItem;
}

// Add at beginning
void addAtBeginning(int id, char name[], int quantity, float price) {
    Item* newItem = createItem(id, name, quantity, price);
    newItem->next = head;
    head = newItem;
}

// Add at end
void addAtEnd(int id, char name[], int quantity, float price) {
    Item* newItem = createItem(id, name, quantity, price);
    if (head == NULL) {
        head = newItem;
        return;
    }
    Item* temp = head;
    while (temp->next != NULL)
        temp = temp->next;
    temp->next = newItem;
}

// Add at position (1-based index)
void addAtPosition(int id, char name[], int quantity, float price, int pos) {
    if (pos == 1) {
        addAtBeginning(id, name, quantity, price);
        return;
    }
    Item* newItem = createItem(id, name, quantity, price);
    Item* temp = head;
    for (int i = 1; i < pos - 1 && temp != NULL; i++)
        temp = temp->next;
    if (temp == NULL) {
        printf("Position out of bounds.\n");
        free(newItem);
        return;
    }
    newItem->next = temp->next;
    temp->next = newItem;
}

// Remove item by ID
void removeByID(int id) {
    if (head == NULL) {
        printf("Inventory is empty.\n");
        return;
    }
    if (head->itemID == id) {
        Item* temp = head;
        head = head->next;
        free(temp);
        printf("Item removed.\n");
        return;
    }
    Item* temp = head;
    while (temp->next != NULL && temp->next->itemID != id)
        temp = temp->next;
    if (temp->next == NULL) {
        printf("Item not found.\n");
        return;
    }
    Item* toDelete = temp->next;
    temp->next = temp->next->next;
    free(toDelete);
    printf("Item removed.\n");
}

// Update quantity by ID
void updateQuantity(int id, int newQuantity) {
    Item* temp = head;
    while (temp != NULL && temp->itemID != id)
        temp = temp->next;
    if (temp == NULL) {
        printf("Item not found.\n");
        return;
    }
    temp->quantity = newQuantity;
    printf("Quantity updated.\n");
}

// Search by ID
void searchByID(int id) {
    Item* temp = head;
    while (temp != NULL) {
        if (temp->itemID == id) {
            printf("Found: %d | %s | Qty: %d | Price: %.2f\n",
                   temp->itemID, temp->itemName, temp->quantity, temp->price);
            return;
        }
        temp = temp->next;
    }
    printf("Item not found.\n");
}

// Search by Name
void searchByName(char name[]) {
    Item* temp = head;
    int found = 0;
    while (temp != NULL) {
        if (strcmp(temp->itemName, name) == 0) {
            printf("Found: %d | %s | Qty: %d | Price: %.2f\n",
                   temp->itemID, temp->itemName, temp->quantity, temp->price);
            found = 1;
        }
        temp = temp->next;
    }
    if (!found)
        printf("Item not found.\n");
}

// Calculate total inventory value
void totalInventoryValue() {
    Item* temp = head;
    float total = 0;
    while (temp != NULL) {
        total += temp->quantity * temp->price;
        temp = temp->next;
    }
    printf("Total Inventory Value: %.2f\n", total);
}

// Swap function for sorting
void swapItems(Item* a, Item* b) {
    int tempID = a->itemID;
    char tempName[50];
    strcpy(tempName, a->itemName);
    int tempQty = a->quantity;
    float tempPrice = a->price;

    a->itemID = b->itemID;
    strcpy(a->itemName, b->itemName);
    a->quantity = b->quantity;
    a->price = b->price;

    b->itemID = tempID;
    strcpy(b->itemName, tempName);
    b->quantity = tempQty;
    b->price = tempPrice;
}

// Sort inventory by name or price
void sortInventory(int criterion, int ascending) {
    if (head == NULL)
        return;
    Item* i;
    Item* j;
    for (i = head; i != NULL; i = i->next) {
        for (j = i->next; j != NULL; j = j->next) {
            int cmp = 0;
            if (criterion == 1) // name
                cmp = strcmp(i->itemName, j->itemName);
            else if (criterion == 2) // price
                cmp = (i->price > j->price) ? 1 : ((i->price < j->price) ? -1 : 0);

            if ((ascending && cmp > 0) || (!ascending && cmp < 0))
                swapItems(i, j);
        }
    }
    printf("Inventory sorted.\n");
}

// Display all items
void displayAll() {
    if (head == NULL) {
        printf("Inventory is empty.\n");
        return;
    }
    Item* temp = head;
    printf("ID | Name | Qty | Price\n");
    printf("-------------------------\n");
    while (temp != NULL) {
        printf("%d | %s | %d | %.2f\n", temp->itemID, temp->itemName, temp->quantity, temp->price);
        temp = temp->next;
    }
}

// Main menu
int main() {
    int choice, id, quantity, criterion, ascending, pos;
    char name[50];
    float price;

    while (1) {
        printf("\n--- Inventory Management System ---\n");
        printf("1. Add at beginning\n");
        printf("2. Add at end\n");
        printf("3. Add at position\n");
        printf("4. Remove item by ID\n");
        printf("5. Update quantity by ID\n");
        printf("6. Search by ID\n");
        printf("7. Search by Name\n");
        printf("8. Total inventory value\n");
        printf("9. Sort inventory\n");
        printf("10. Display all items\n");
        printf("11. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter ID, Name, Quantity, Price: ");
                scanf("%d %s %d %f", &id, name, &quantity, &price);
                addAtBeginning(id, name, quantity, price);
                break;
            case 2:
                printf("Enter ID, Name, Quantity, Price: ");
                scanf("%d %s %d %f", &id, name, &quantity, &price);
                addAtEnd(id, name, quantity, price);
                break;
            case 3:
                printf("Enter ID, Name, Quantity, Price, Position: ");
                scanf("%d %s %d %f %d", &id, name, &quantity, &price, &pos);
                addAtPosition(id, name, quantity, price, pos);
                break;
            case 4:
                printf("Enter ID to remove: ");
                scanf("%d", &id);
                removeByID(id);
                break;
            case 5:
                printf("Enter ID and new quantity: ");
                scanf("%d %d", &id, &quantity);
                updateQuantity(id, quantity);
                break;
            case 6:
                printf("Enter ID to search: ");
                scanf("%d", &id);
                searchByID(id);
                break;
            case 7:
                printf("Enter Name to search: ");
                scanf("%s", name);
                searchByName(name);
                break;
            case 8:
                totalInventoryValue();
                break;
            case 9:
                printf("Sort by 1. Name 2. Price: ");
                scanf("%d", &criterion);
                printf("Ascending (1) or Descending (0): ");
                scanf("%d", &ascending);
                sortInventory(criterion, ascending);
                break;
            case 10:
                displayAll();
                break;
            case 11:
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }
    return 0;
}