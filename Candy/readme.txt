http://www.cnblogs.com/felixfang/p/3620086.html

请回想一下：我们为什么需要辅助空间？当孩子的rate是一个非递减曲线的时候，我们是不需要辅助空间的，比如5个孩子的rate分别是1，2，5，7，10。那么糖果数自然是1，2，3，4，5。又如5个孩子的rate分别是1，2，5，5，10，那么糖果数自然是1，2，3，1，2。

因此如果rate是非递减数列，我们可以精确计算出当前孩子应该给多少糖果，把这个糖果数加入总数即可。

当孩子的rate出现递减的情况该如何是好？不用辅助空间能处理吗？

假设5个孩子的rate是 1，5，4，3，2。我们这样计算：遍历时，第一个孩子依然糖果为1，第二个孩子糖果为2，第三个孩子糖果给几个？我们遍历到后面就会知道第二个孩子给的糖果太少了，应该给4个。有没有办法在遍历到后面时，能计算出一个修正值，使得加上这个修正值，正好依然可以使总糖果数是正确的？

 

其实这个修正值不难计算，因为可以发现递减数列的长度决定了第二个孩子该给几个糖果。仔细观察：遍历到第四个孩子时我们知道了第二个孩子不该给2，应该给3，因此Total 要 +=1；遍历到第五个孩子我们知道了第二个孩子不该给3得给4，因此Total 要 += 1。我们设一个变量beforeDenc表示进入递减序列之前的那个孩子给的糖果值，再设置length用来表达当前递减序列的长度。这两个变量就可以决定Total是不是要修正：当遍历第三个孩子的时候 beforeDenc = 2，以后每遍历一个孩子，因为length已经超过了beforeDenc，每次Total都要额外+1，来修正第二个孩子的糖果数。

 

对于后面三个孩子，我们可以这样计算：遍历到第三个孩子，因为这是递减数列的第二个数字，我们Total += 1；第四个孩子是递减数列的第三个数字，Total += 2；第五个孩子是递减数列的第四个数字，Total += 3。

可以发现最后三个孩子的糖果总数依然是正确的，虽然Total 每次增加的糖果数量正好和当前孩子得到的糖果数是反序关系。

 

这种边遍历边修正的方法可以保证一次遍历，不需要O(n)空间下计算出Total的正确值。