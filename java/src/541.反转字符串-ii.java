/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int index = 0;
        while (index < n) {
            if (n - index < k) {
                reverse(arr, index, n-1);
                break;
            } else if (n - index >= k && n - index < 2*k) {
                reverse(arr, index, index+k-1);
                break;
            } else {
                reverse(arr, index, index+k-1);
                index += 2*k;
            }
        }

        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] arr, int left, int right) {
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
// @lc code=end

