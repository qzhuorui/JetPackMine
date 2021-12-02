# ReadMe

> 本项目目的在于，记录对JetPack部分库的学习，Demo实践

## 一、MotionLayout

### 简介：
MotionLayout即动态布局，是`ConstraintLayout`的子类
在实践中使用方法为：
    1.通过include，导入控件布局，根布局为`MotionLayout`
    2.app:layoutDescription="@xml/textview_motion_layout_scene" 生成对动画进行控制的xml文件
    3.此文件为MotionLayout主要内容
    4.注意Scene中的命名空间一定要为`xmlns:motion`而不是`xmlns:app`
    5.坐标系为Android屏幕左上角

### MotionScene常见的标签及属性：

#### 1.Transition
        a.constraintSetStart/constraintSetEnd：ConstraintSet的ID或布局ID
        b.duration：持续时间
        c.motionInterpolator：运动差值器。easeInOut 缓入缓出;easeIn 缓入;easeOut 缓出;linear 线性;bounce 弹跳效果;
        d.autoTransition：自动过渡。none 不运动;jumpToStart 直接跳到开始;jumpToEnd 直接跳到结束;animateToStart 执行动画到开始;animateToEnd 执行动画到结束;

#### 2.OnSwipe,指定用户在布局上滑动时要执行的操作
        a.touchAnchorId：通过滑动移动的视图ID
        b.touchAnchorSide：手指和View的哪一侧保持恒定距离
        c.dragDirection：滑动的方向，如果设置此属性，则OnSwip仅适用于延特定方向的滑动

#### 3.OnClick,指定当用户点击特定视图时要执行的操作。单个Transition可以有多个OnClick节点，每个OnClick指定一个不同的目标视图，并在点击该视图时执行不同的操作
        a.targetId：点击指定的ID时，将会执行Transition
        b.ClickAction：点击视图时执行的操作

#### 4.KeyFrameSet
        指定运动序列过程中视图的位置和属性。
        默认情况下，运动会从初始状态进行到结束状态。通过使用，您可以构建更复杂的动作。
        包含或节点。这些节点中的每个节点都指定运动中特定点的目标视图的位置或属性。
        MotionLayout从起点到这些中间点中的每一个，再到最终目的地，使视图平滑地动画化

#### 5.KeyPosition,指定运动序列中特定时刻的视图位置。此属性用于调整运动的默认路径
        a.motionTarget：要改变属性的视图ID
        b.framePosition：在运动序列中何时，具有此属性。framePosition = 50则代表视图运动到整个运动序列的50%处
        c.percentX/percentY：指定视图应到达的位置
        d.keyPositionType：如何解释percentX/percentY
#### 6.KeyAttribute,指定运动序列中特定时刻的视图属性。您可以使用设置视图的任何标准属性
        a.alpha
        b.visibility
        c.elevation
        d.rotation, rotationX, rotationY
        e.translationX, translationY, translationZ
        f.scaleX, scaleY

#### 7. 使用问题汇总：
        1. 注意：一定要在scene中指定宽高属性，否则展示不出来
        2. 多元素点击，多Transition时，需要使用代码的方式来设置运行