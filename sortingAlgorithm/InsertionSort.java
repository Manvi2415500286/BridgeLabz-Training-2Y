class InsertionSort {
    public static void insertionSort(int[] empIds) {
        for (int i = 1; i < empIds.length; i++) {
            int key = empIds[i];
            int j = i - 1;

            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }
            empIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] empIds = {105, 102, 109, 101, 104};

        insertionSort(empIds);

        System.out.print("Sorted Employee IDs: ");
        for (int id : empIds) {
            System.out.print(id + " ");
        }
    }
}
