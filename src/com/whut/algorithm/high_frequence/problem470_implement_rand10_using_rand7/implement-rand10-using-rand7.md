(https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/)[题解]

## Part 1

假设已知rand2()可以**均匀**的生成[1,2]的随机数，现在想均匀的生成[1,4]的随机数，该如何考虑？

我想如果你也像我一样第一次接触这个问题，那么很可能会这么考虑——令两个rand2()相加，再做一些必要的边角处理。如下：

```text
rand2() + rand2() = ? ==> [2,4]
   1    +   1     = 2
   1    +   2     = 3
   2    +   1     = 3
   2    +   2     = 4

// 为了把生成随机数的范围规约成[1,n]，于是在上一步的结果后减1
(rand2()-1) + rand2() = ? ==> [1,3]
   0       +   1     = 1
   0       +   2     = 2
   1       +   1     = 2
   1       +   2     = 3

```


```text
已知 rand_N() 可以等概率的生成[1, N]范围的随机数
那么：
(rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
即实现了 rand_XY()
```