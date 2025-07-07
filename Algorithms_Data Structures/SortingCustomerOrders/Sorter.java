public class Sorter {
    public static void quickSort(Order[] arr, int low, int high) {
        if(low<high) {
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
    private static int partition(Order[] arr,int low,int high){
        double pivot=arr[high].price;
        int i=low-1;
        for(int j=low;j<high;j++)
            if(arr[j].price<pivot){
                i++; Order tmp=arr[i]; arr[i]=arr[j]; arr[j]=tmp;
            }
        Order tmp=arr[i+1]; arr[i+1]=arr[high]; arr[high]=tmp;
        return i+1;
    }
}