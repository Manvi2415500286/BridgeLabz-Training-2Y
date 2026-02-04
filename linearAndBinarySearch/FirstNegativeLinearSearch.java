class FirstNegativeLinearSearch {

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, -3, 8, -2};

        int index = findFirstNegative(arr);
        System.out.println("Index of first negative number: " + index);
    }
}
