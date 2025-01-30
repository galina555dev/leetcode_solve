package EX1;

public class Program1 {
    public static void main(String[] args) {

    //Given a sorted array of distinct integers and a target value, return the index if the target is found.
    // If not, return the index where it would be if it were inserted in order.

    int[] nums = {3,-9,33,17};
    int target = 17;


    System.out.println("Index of target = " + searchInsert(nums,target));
}

    public static int searchInsert(int[] nums, int target) {
        // LEFT should be smaller than TARGET, RIGHT should be >= TARGET
        // left < target >= right
        int left = 0;
        int right = nums.length-1;

        if(nums[left]>=target)
            return left;
        if(nums[nums.length-1]<target)
            return nums.length;

        while(left +1 < right){
            int mid = (left + right)/2;
            if(nums[mid] == target && nums[mid-1]<target){
                return mid;
            }
            else if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return right;

    }
}
