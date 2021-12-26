/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = -1;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == ' ') {
                reverseWord(arr, i, j);
                i = k+1;
                j = k;
            } else if (k == arr.length - 1) {
                reverseWord(arr, i, arr.length - 1);
            } else {
                j++;
            }
        }
        return new String(arr);
    }

    public void reverseWord(char[] arr, int i, int j) {
        int left = i, right = j;
        while (left < right && left <= j && right >= i) {
            swap(arr, left, right);
            left++; right--;
        }
    }

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
// @lc code=end

