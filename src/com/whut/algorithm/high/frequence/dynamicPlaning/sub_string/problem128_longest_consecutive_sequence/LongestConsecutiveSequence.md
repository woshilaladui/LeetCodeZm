## 题目描述

给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。


**进阶**：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？

示例 1：
```text
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
```
示例 2：
``` text
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
```
提示：
```text
0 <= nums.length <= 104
-109 <= nums[i] <= 109
```


## 方法1：排序
* 时间复杂度O(nlogn)，不满足要求，但能通过，比较好想

### 思路
* 从小到大排序
* 遍历数组，比较相邻的两项，如果相同，则跳过，继续遍历下一项
* 如果 当前项+1 等于 下一项，说明遇到连续项，count +1
* 否则，说明连续情况发生中断，将 count 重置为 1

### 方法1 代码
```javascript
var longestConsecutive = (nums) => {
  if (nums.length === 0) return 0
  nums.sort((a, b) => a - b)
  let max = 1
  let count = 1
  for (let i = 0; i < nums.length - 1; i++) {
    let cur = i, next = i + 1
    if (nums[cur] === nums[next]) continue // 相同就跳过本次循环
    if (nums[cur] + 1 === nums[next]) { // 发现连续项 count++
      count++
    } else { // 否则，count重置1
      count = 1
    }
    max = Math.max(max, count)
  }
  return max
}
```
## 方法2：Set 的查找是 O(1)
### 思路
* 查找 Set 中的元素的时间复杂度是 O(1)，JS 的 Set 能给数组去掉重复元素
* 将数组元素存入 set 中，遍历数组 nums
* 如果 当前项 - 1 存在于 set ，说明当前项不是连续序列的起点，跳过，继续遍历
* 当前项没有“左邻居”，它就是连续序列的起点
* 不断在 set 中查看 cur + 1 是否存在，存在，则 count +1
* cur 不再有 “右邻居” 了，就算出了一段连续序列的长度

### 代码
```javascript
var longestConsecutive = (nums) => {
  const set = new Set(nums) // set存放数组的全部数字
  let max = 0
  for (let i = 0; i < nums.length; i++) {
    if (!set.has(nums[i] - 1)) { // nums[i]没有左邻居，是序列的起点
      let cur = nums[i]
      let count = 1
      while (set.has(cur + 1)) { // cur有右邻居cur+1
        cur++ // 更新cur
        count++ 
      }
      max = Math.max(max, count) // cur不再有右邻居，检查count是否最大
    }
  }
  return max
}
```

## 方法3：哈希表
### 哈希表的value存什么
* key存数字，value存什么？
* 新存入的数字，如果它找到相邻的数，它希望从邻居数那里获取什么信息？
* 很显然它希望，左邻居告诉它左边能提供的连续长度，右邻居告诉它右边能提供的连续长度
* 加上它自己的长度，就有了自己处在的连续序列的长度

![](https://pic.leetcode-cn.com/2894864f20ba11062c1383215cabee48f423d8813ce291ff0ae7a3c58bbc780e-image.png)

### 更新新序列的两端数字的value
* 同处一个连续序列的数字的value理应都相同，这是它们共同特征
* 但没有必要每个的value都是序列长度，只需要两端的数存序列的长度就好
* 因为靠的是两端和新数对接，序列是连续的，中间没有空位
* 序列的一端找到邻居后，将另一端对应的value更新为最新的序列长度

### 代码 
```java

        if(nums.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int preLen = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int lastLen = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int curLen = preLen + 1 + lastLen;

                //更新自己
                map.put(num,curLen);

                max = Math.max(max, curLen);
                //更新选中两边的value值
                map.put(num - preLen, curLen);
                map.put(num + lastLen, curLen);
            }

        }

        return max;
```