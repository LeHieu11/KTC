/**
 * HeapSort
 */
public class HeapSort {
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void toMaxHeap(int[] arr) {
        for(int i = 1; i < arr.length; i++) {

            //if parent "(i -1)/2" < current "i"
            //do a continuestly swap
            if (arr[(i -1)/2] < arr[i]) {
                int j = i;

                //while parent (j -1)/2 < child j
                //do a swap and get new j
                while (arr[(j -1)/2] < arr[j]) {
                    swap(arr, (j -1)/2, j);
                    j = (j -1)/2;
                }
            }
        }
    }

    public static void sort(int[] arr) {
        toMaxHeap(arr);

        // i varible gonna be the bound that the maxest of the moment gonna be in
        for (int i = arr.length - 1 ; i > 0; i--) {
            //swap the head of a heap which is largest to the end
            //do the swap until get the right head which is the second largest
            swap(arr, 0, i);

            //j for parent
            //index for child (could be left or right)
            int j = 0;
            int index;
            
            do {
                //index gonna be LEFT child of node j
                index = j * 2 + 1;

                //is the RIGH child bigger LEFT child
                //and not out of bound
                if (index < i - 1 && arr[index + 1] > arr[index]) index++;

                //doing swap if child > parent
                //set new j thus the on going node
                if (index < i && arr[index] > arr[j]) {
                    swap(arr, j, index);
                }
                
                j = index;

            }
            while(index < i); 
        }
    }

    public static void main(String[] args) {
        int[] input = {10, 20, 15, 17, 9, 21};
        sort(input);
        
        for (int i : input) {
            System.out.println(i);
        }
    }
}