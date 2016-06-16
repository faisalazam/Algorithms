package com.mindworks.algorithms.binarysearch;

/*
Binary search is a fast search algorithm with run-time complexity of O(log n). This search algorithm works on the
principle of divide and conquer. For this algorithm to work properly the data collection should be in sorted form.

Binary search, search a particular item by comparing the middle most item of the collection.
If match occurs then index of item is returned.
If middle item is greater than item then item is searched in sub-array to the right of the middle item,
other wise item is search in sub-array to the left of the middle item.
This process continues on sub-array as well until the size of subarray reduces to zero.

Class:	Search algorithm
Data structure:	Array
Worst case performance:	O(log n)
Best case performance:	O(1)
Average case performance:	O(log n)
Worst case space complexity:	O(1) iterative,
O(log n) recursive
(without tail call elimination)
 */
public class BinarySearch {
    private BinarySearch() {
    }

    public static int search(final int[] sortedSearchSpace, final int target) {
        if (sortedSearchSpace.length == 0) {
            return -1;
        }

        int middleIndex;
        int lowerIndex = 0;
        int higherIndex = sortedSearchSpace.length - 1;

        while (lowerIndex < higherIndex) {
            middleIndex = lowerIndex + ((higherIndex - lowerIndex) / 2);
            if (sortedSearchSpace[middleIndex] == target) {
                return middleIndex;
            } else if (target > sortedSearchSpace[middleIndex]) {
                lowerIndex = middleIndex + 1;
            } else {
                higherIndex = middleIndex - 1;
            }
        }
        return sortedSearchSpace[lowerIndex] == target ? lowerIndex : -1;
    }
}
