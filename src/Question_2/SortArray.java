/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

/**
 *
 * @author xhu
 */

/*
1. Quick sort is not the best way of finding the median, as it requires sorting the entire array.
   This leads to an average time complexity of O(n log n) (worst case O(n^2) if pivot selection is poor),
   and is not necessary if we only need to find the median.

2. A better way of finding the median is using the "median of medians" algorithm, which takes a similar
   approach to quick sort, using a pivot and sub-arrays, but only continues until the pivot value is
   found at the median index of the array. Furthermore, it ensures good pivot selection by partitioning the array
   and finding the median value of each subsection, then choosing the median of those medians as the pivot value.
   This approach guarantees a worst case time complexity of O(n), making it much more efficient than a traditional
   quick sort.
   
*/
public class SortArray <E extends Comparable> {
    
    E[] array;
    
    public SortArray(E[] array)
    {
        this.array = array;
    }
    
    public void setArray(E[] array)
    {
        this.array = array;
    }
    
    public void quickSort()
    {
        quickSort(array, 0, array.length-1);
    }
    
    private void quickSort(E[] list, int head, int tail)
    {
        // only run the method if the sublist has more than one element
        if (head < tail) {
            E pivot = list[tail];
            int index = head;
            
            int swapMarker = head-1;
            // loop through entire sublist incrementing index
            while (index <= tail) {
                // if the value at index is greater than pivot the swapMarker lags behind the index
                if (list[index].compareTo(pivot) <= 0) {
                    swapMarker++;
                    // if swapMarker has lagged behind, swap with index
                    if (index > swapMarker) {
                        swap(list, index, swapMarker);
                    }
                }
                index++;
            }
            
            // once pivot is in the middle of the sublist, recursively sort the sublists on either side of the pivot
            quickSort(list, head, swapMarker-1);
            quickSort(list, swapMarker+1, tail);
        }
    }
    
    private void swap(E[] list, int a, int b)
    {
        E temp = list[a];
        list[a] = list[b];
        list[b] = temp;
        
    }    
}
