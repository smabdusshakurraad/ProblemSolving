package week_one;

public class MockOne {
    public static void main(String[] args){
        int[] arr = {3,6,1,5,4};
        int n = arr.length;
        int m = median(n,arr);

        System.out.println(m);

        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int median(int n, int[] arr) {
        quickSort(arr,0,n-1);
        return arr[n/2];
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start-1;
        int temp;
        for(int j=start;j<end;j++){
            if(arr[j]<pivot){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }
    private static void quickSort(int[] arr, int start, int end) {
        if(start<end){
            int pivotIndx = partition(arr,start,end);
            quickSort(arr,start,pivotIndx-1);
            quickSort(arr,pivotIndx+1,end);
        }
    }
}
