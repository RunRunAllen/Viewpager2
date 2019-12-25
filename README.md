# Viewpager2
1.基于RecycleView 实现，这就意味着RecycleView 的优点将会被Viewpager2 所继承。
2. 支持竖直滑动，mViewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
3. 支持 关闭用户输入，通过setUserInputEnabled 来设置是否禁止用户滑动。
4.支持通过编程方式滚动。通过fakeDragBy(offsetPx)代码模拟用户滑动页面。
5.CompositePageTransformer 支持同时添加多个PageTransformer
6.支持DiffUtil ，可以添加数据集合改变的item动画。
7.支持RTL (right-to-left)布局。我觉得这个功能对国内开发者来说可能用处不大..
