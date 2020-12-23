## 题目描述

给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:
```aidl
nums = [1, 2, 3]
target = 4
```
所有可能的组合为：
```aidl
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
```

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。

## 思路

画树形图分析。
![](https://img-blog.csdnimg.cn/20200309204825998.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zOTAyOTE5NA==,size_16,color_FFFFFF,t_70)

很容易发现“重叠子问题”，因此，我们可以使用“动态规划”来做。

对上图的解释：

![](https://img-blog.csdnimg.cn/20200309204934173.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zOTAyOTE5NA==,size_16,color_FFFFFF,t_70)

方法：动态规划
“动态规划”的两个步骤是思考“状态”以及“状态转移方程”。

1、状态

对于“状态”，我们首先思考能不能就用问题当中问的方式定义状态，上面递归树都画出来了。当然就用问题问的方式。

dp[i] ：对于给定的由正整数组成且不存在重复数字的数组，和为 i 的组合的个数。

思考输出什么？因为状态就是问题当中问的方式而定义的，因此输出就是最后一个状态 dp[n]。

2、状态转移方程

由上面的树形图，可以很容易地写出状态转移方程：
```aidl
dp[i] = sum{dp[i - num] for num in nums and if i >= num}
```
注意：在 0这一点，我们定义 dp[0] = 1 的，它表示如果 nums 里有一个数恰好等于 target，它单独成为 1 种可能。

参考代码：
```java
/**
 * @author 灵洛
 * @date 2020/3/9 21:36
 * 题目描述：给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 状态转移方程：dp[i] = sum{dp[i - num] for num in nums and if i >= num}
 * 也就是 dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ...
 * 状态转移方程：dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ... （当 [] 里面的数 >= 0）
 * 特别注意：dp[0] = 1，表示，如果那个硬币的面值刚刚好等于需要凑出的价值，这个就成为 1 种组合方案
 * 再举一个具体的例子：nums=[1, 3, 4], target=7;
 * dp[7] = dp[6] + dp[4] + dp[3]
 * 即：7 的组合数可以由三部分组成，1 和 dp[6]，3 和 dp[4], 4 和dp[3];
 */
public class Combination_sum_iv_377 {
    public static void main(String[] args) {
        int result = combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(result);
    }

    /**
     *
     * @param nums 数组
     * @param target 正整数
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {
        // 数组长度
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 1.初始化dp数组 dynamic programming
        int dp[] = new int[target + 1];
        // 代表一个空集 空集和它"前面"的元素凑成一种解法，所以是 1
        dp[0] = 1;
        // 动态规划
        // 2.遍历目标正整数 i的意思是当前的目标正整数
        for (int i = 1; i <= target; i++) {
            // 3.遍历数组
            for (int num : nums) {
                if ( i - num >= 0) {
                    // dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ...
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}


```