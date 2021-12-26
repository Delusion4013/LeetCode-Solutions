import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 公式推导
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;


        
        // O(n2) 递推
        // List<List<Integer>> tr = new ArrayList<>();
        // for (int i = 0; i <= rowIndex; i++) {
        //     List<Integer> row = new ArrayList<>();
        //     for (int j = 0; j <= i; j++) {
        //         if (j == 0 || j == i) {
        //             row.add(1);
        //         } else {
        //             row.add(tr.get(i-1).get(j-1) + tr.get(i-1).get(j));
        //         }
        //     }
        //     tr.add(row);
        // }

        // return tr.get(rowIndex);
    }
}
// @lc code=end

