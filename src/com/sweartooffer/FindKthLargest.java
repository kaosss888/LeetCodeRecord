package com.sweartooffer;

/**
 * 数组中的第K个最大元素
 * 大顶堆、快速选择（利用快排的切分）
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MAX_VALUE;
        buildMaxHeap(nums, nums.length);
        int i = 1;
        while (i <= k) {
            max = nums[0];

            nums[0] = nums[0] ^ nums[nums.length - i];
            nums[nums.length - i] = nums[0] ^  nums[nums.length - i];
            nums[0] = nums[0] ^  nums[nums.length - i];
            buildMaxHeap(nums, nums.length - i);
            i++;
        }
        return max;
    }

    public void buildMaxHeap(int[] nums, int length) {

        for (int i = length / 2; i > 0; i--) {

            int child = i * 2 - 1;
            int parent = i - 1;
            int temp;
            while (child <= length - 1) {
                temp = nums[parent];
                if (child + 1 <= length - 1 && nums[child] < nums[child + 1])
                    child++;
                if (temp > nums[child])
                    break;
                nums[parent] = nums[child];
                nums[child] = temp;
                parent = child;
                child = (child + 1) * 2 - 1;
            }
        }
    }

//    public static void main(String[] args) {
//        FindKthLargest findKthLargest = new FindKthLargest();
//        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
//
//        System.out.println(findKthLargest.findKthLargest(arr, 4));
//    }
}
