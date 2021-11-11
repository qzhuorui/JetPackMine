# ReadMe

> 本项目目的在于，记录对JetPack部分库的学习，Demo实践

## 一、MotionLayout
MotionLayout即动态布局，是`ConstraintLayout`的子类
在实践中使用方法为：
    1.通过include，导入控件布局，根布局为`MotionLayout`
    2.app:layoutDescription="@xml/textview_motion_layout_scene" 生成对动画进行控制的xml文件
    3.此文件为MotionLayout主要内容
    4.注意Scene中的命名空间一定要为`xmlns:motion`而不是`xmlns:app`
    5.坐标系为Android屏幕左上角