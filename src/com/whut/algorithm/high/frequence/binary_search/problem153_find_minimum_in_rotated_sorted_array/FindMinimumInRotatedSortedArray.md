![](https://pic.leetcode-cn.com/1608987739-zeegVj-file_1608987739105)

* 数组完全有序 nums[left] < nums[right]，此时返回 nums[left] 即可

* left 和 mid 在一个都在前半部分，单调递增区间内，所以需要移动 left，继续查找，left = mid + 1；

* left 在前半部分，mid在后半部分，则最小值必在 left 和 mid 之间（见下图）。则需要移动right ，right = mid，我们见上图，如果我们 right = mid - 1，则会漏掉我们的最小值，因为此时 mid 指向的可能就是我们的最小值。所以应该是 right = mid 。
