public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;
        int temp[] = new int[l];
        int i=0, j = l-1;
        for (int x=0;x<l;x++) {
            temp[x] = nums[x];          
        }
        mergeSort(nums, i, j);
        while(i<l) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                //System.out.println(i+" "+j);
                for (int x=0;x<l;x++) {
                  if (nums[i] == temp[x] || nums[j] == temp[x])
                    if (result[0] == Integer.MIN_VALUE)
                        result[0] = x;
                    else {
                        result[1] = x;
                        break;
                    }
                }
                break;
            }
            else {
                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }
    
    public void mergeSort(int[] nums, int l, int r) {
        if (l>=r)
            return;
        int m = (r+l)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1,r);
        merge(nums,l,m,m+1,r);
    }
    
    public void merge(int[] nums, int i, int j, int m, int n) {
        int[] temp = new int[n-i+1];
        int k=0;
        int l = i;
        while(i <=j && m<=n ) {
            if (nums[i] > nums[m]) {
                temp[k++] = nums[m];
                m++;
            }
            else {
                temp[k++]  = nums[i];
                i++;
            }
        }
        while(i<=j) {
            temp[k++] = nums[i++];
        }
        while(m<=n) {
            temp[k++] = nums[m++];
        }
        for (k=0;l<=n;l++) {
            nums[l] = temp[k++];
        }
    }
    
}