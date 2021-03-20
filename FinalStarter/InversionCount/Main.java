class Main {
    // Function to find inversion count of the given array
    public static int getInversionCount(int[] arr) {
        //TODO write statements to find inversion count of the given array
        int count = 0; 
        for (int i = 0; i < arr.length - 1; i++) 
            for (int j = i + 1; j < arr.length; j++) 
                if (arr[i] > arr[j]) 
                    count++; 
  
        return count; 
    }
 
    public static void main(String[] args) {
        int[] arr = { 1, 9, 6, 4, 5 };
 
        System.out.println("Inversion count is " + getInversionCount(arr));
    }
}