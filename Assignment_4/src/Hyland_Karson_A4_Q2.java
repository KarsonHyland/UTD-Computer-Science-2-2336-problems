import java.util.Date;
import java.util.Random;
import java.util.Arrays;

public class Hyland_Karson_A4_Q2 {
	//the quickSort and partition functions
	static void quickSort(int arr[], int low, int high)
	{
	    if (low < high)
	    {
	        /* pi is partitioning index, arr[pi] is now
	           at right place */
	        int pi = partition(arr, low, high);

	        quickSort(arr, low, pi - 1);  // Before pi
	        quickSort(arr, pi + 1, high); // After pi
	    }
	}
	
	static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}

	static int partition (int arr[], int low, int high)
	{
	    // pivot (Element to be placed at right position)
	    int pivot = arr[high];  
	 
	    int i = (low - 1);  // Index of smaller element

	    for (int j = low; j <= high- 1; j++)
	    {
	        // If current element is smaller than the pivot
	        if (arr[j] < pivot)
	        {
	            i++;    // increment index of smaller element
	            swap(arr[i], arr[j]);
	        }
	    }
	    swap(arr[i + 1], arr[high]);
	    return (i + 1);
	}
    //end of quciksort
    
    //begining of heapsort
    static void heapSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
  
    static void heapify(int arr[], int n, int i) 
    { 
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
  
        // If left child is larger than root 
        if (left < n && arr[left] > arr[largest]) 
            largest = left; 
  
        // If right child is larger than largest so far 
        if (right < n && arr[right] > arr[largest]) 
            largest = right; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            heapify(arr, n, largest); 
        } 
    }
    //end of heap sort

    //begining of bubblesort
    static void bubbleSort(int[] arr) {
    	boolean needNextPass = true;
    	
    	for (int k = 1; k< arr.length && needNextPass; k++) {
    		needNextPass = false;
    		for (int i = 0; i < arr.length - k; i++) {
    			if (arr[i] > arr[i+1]) {
    				int temp = arr[i];
    				arr[i] = arr[i + i];
    				arr[i + 1] = temp;
    				needNextPass = true;
    			}
    		}
    	}
    }
    //end of bubblesort
    
    //begining of radix sort
    static void radixSort(int arr[], int n)
    {
        int m = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > m)
                m = arr[i];

        for (int exp = 1; m / exp > 0; exp *= 10) {
        	int output[] = new int[n];
	        int i;
	        int count[] = new int[10];
	        Arrays.fill(count, 0);
	 
	        for (i = 0; i < n; i++)
	            count[(arr[i] / exp) % 10]++;
	 
	        for (i = 1; i < 10; i++)
	            count[i] += count[i - 1];
	 
	        // Build the output array
	        for (i = n - 1; i >= 0; i--) {
	            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
	            count[(arr[i] / exp) % 10]--;
	        }
	 
	        for (i = 0; i < n; i++)
	            arr[i] = output[i];
        }
    }
    //end of radix sort
	
    //Tells the time it took for each sort
    static void sortTime(int arr[]) {
    	double first = System.nanoTime();
    	quickSort(arr, 0, arr.length-1);
    	double last = System.nanoTime();
    	System.out.println("Quick sort time in micro seconds: " + (last - first)/1000);
    	
    	first = System.nanoTime();
    	heapSort(arr);
    	last = System.nanoTime();
    	System.out.println("Heap sort time in micro seconds: " + (last - first)/1000);

    	first = System.nanoTime();
    	bubbleSort(arr);
    	last = System.nanoTime();
    	System.out.println("Bubble sort time in micro seconds: " + (last - first)/1000);
    	
    	first = System.nanoTime();
    	radixSort(arr, arr.length);
    	last = System.nanoTime();
    	System.out.println("Radix sort time in micro seconds: " + (last - first)/1000);
    }
	
	public static void main(String[] args) {
		int size = 10000;
		
		int arr[] = new int[size];
		
		Random num = new Random();
		for(int i = 0; i < size; i++) {
			arr[i] = num.nextInt(100);
			System.out.println(arr[i]);
		}
		sortTime(arr);

	}

}