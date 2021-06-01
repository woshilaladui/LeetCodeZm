## 情况1
![](https://pic.leetcode-cn.com/1608987739-IVvyxU-file_1608987739096)

1.落在 mid 的左边，当前例子中 情况是落在 [4,7）区间内，即 4 <= target < 7 ，也就是 target >= nums[left] && target < nums[mid]，此时我们让 right = mid -1，让 left 和 right 都落到数组 1 中，下次查找我们就是在数组1中进行了，完全有序，

2.落在 mid 的右边，此时例子中 target 不落在 [4,7）区间内，那就 target = 8 或 0 <= target <= 2 （此时我们的 target 均小于 nums[left]） 两种情况，也就是target > nums[mid] || target < nums[left] 此时我们让 left = mid + 1即可，也是为了慢慢将left 和 right 指针赶到一个有序数组内。

## 情况2
![](https://pic.leetcode-cn.com/1608987739-HDRNzp-file_1608987739098)
1.target <= nums[right] && target > nums[mid]
> 这里和上面的对应，此时的情况就是整个落在右半部分，我们下次就可以在数组2内进行查找。

2. target > nums[right] || target < nums[mid]
> 这里就是和上面的第二种情况对应，落在 mid 的左半部分，我们尽量将两个指针赶到一起


[一文带你搞定二分查找及多个变种](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/yi-wen-dai-ni-gao-ding-er-fen-cha-zhao-j-00kj/)
 