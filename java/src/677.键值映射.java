import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 */

// @lc code=start
class MapSum {

    Map<String, Integer> map;

    public MapSum() {
        this.map = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        int res = 0;
        for (String s: map.keySet()) {
            if(s.startsWith(prefix)) {
                res += map.get(s);
            }
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

