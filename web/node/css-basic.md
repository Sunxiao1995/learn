## CSS

#### 1.什么是css

​          层叠样式表(英文全称：Cascading Style Sheets)是一种用来表现[HTML](https://baike.baidu.com/item/HTML)（[标准通用标记语言](https://baike.baidu.com/item/标准通用标记语言/6805073)的一个应用）或[XML](https://baike.baidu.com/item/XML)（标准通用标记语言的一个子集）等文件样式的计算机语言。CSS不仅可以静态地修饰网页，还可以配合各种脚本语言动态地对网页各元素进行格式化。

#### 2.css特性

##### 2.1层叠

所谓层叠性是指多种CSS样式的叠加。

是浏览器处理冲突的一个能力,如果一个属性通过两个相同选择器设置到同一个元素上，那么这个时候一个属性就会将另一个属性层叠掉

比如先给某个标签指定了内部文字颜色为红色，接着又指定了颜色为蓝色，此时出现一个标签指定了相同样式不同值的情况，这就是样式冲突。

一般情况下，如果出现样式冲突，则会按照CSS书写的顺序，以最后的样式为准。

1. 样式冲突，遵循的原则是就近原则。 那个样式离着结构近，就执行那个样式。
2. 样式不冲突，不会层叠

```
 CSS最后的执行口诀：  长江后浪推前浪，前浪死在沙滩上。
```

##### 2.2 继承

所谓继承性是指书写CSS样式表时，子标签会继承父标签的某些样式，如文本颜色和字号。想要设置一个可继承的属性，只需将它应用于父元素即可。

简单的理解就是： 子承父业。

```
 CSS最后的执行口诀：  龙生龙，凤生凤，老鼠生的孩子会打洞。
```

##### 2.3 CSS优先级

定义CSS样式时，经常出现两个或更多规则应用在同一元素上，这时就会出现优先级的问题。

在考虑权重时，初学者还需要注意一些特殊的情况，具体如下：

```
 继承样式的权重为0。即在嵌套结构中，不管父元素样式的权重多大，被子元素继承时，他的权重都为0，也就是说子元素定义的样式会覆盖继承来的样式。
 
 行内样式优先。应用style属性的元素，其行内样式的权重非常高，可以理解为远大于100。总之，他拥有比上面提高的选择器都大的优先级。
 
 权重相同时，CSS遵循就近原则。也就是说靠近元素的样式具有最大的优先级，或者说排在最后的样式优先级最大。
 
 CSS定义了一个!important命令，该命令被赋予最大的优先级。也就是说不管权重如何以及样式位置的远近，!important都具有最大优先级。
```

1. 使用了 !important声明的规则。
2. 内嵌在 HTML 元素的 style属性里面的声明。
3. 使用了 ID 选择器的规则。
4. 使用了类选择器、属性选择器、伪元素和伪类选择器的规则。
5. 使用了元素选择器的规则。
6. 只包含一个通用选择器的规则。
7. 同一类选择器则遵循就近原则。

#### 3.样式

##### 3.1 背景

设置背景颜色

```html
<html>
<head>

<style type="text/css">

body {background-color: yellow  padding: 20px;}

</style>

</head>
<body>

</body>
</html>
```

background-color 设置背景色 petting设置内边距

background-image：url(   ); 可以设置背景图片 注意背景色和背景图片都不能被继承

背景重复 

```html
body
  { 
  background-image: url(/i/eg_bg_03.gif);
  background-repeat: repeat-y;
  }
```

y是垂直方向平铺

background-attachment:fixed 可以固定住背景图像

##### 3.2 文本

通过文本属性，您可以改变文本的颜色、字符间距，对齐文本，装饰文本，对文本进行缩进，等等。

text-indent 5em 快里的第一行行缩进5e m

text-align left right center 左对齐 右对齐 居中

word-spacing 单词之间的间隔 中文没有用

letter-spacing 字符或者字母之间的间隔

text-decoration line-through 划线  underline 下划线 overlain 上划线

##### 3.3 字体

font-family 设置字体 如果没有安装会显示默认字体

font-style normal italic oblique

font-weight 设置文本的粗细

font-size 设置文本的大小

##### 3.4 轮廓

是绘制于元素周围的一条线，位于边框边缘的外围，可起到突出元素的作用CSS outline 属性规定元素轮廓的样式、颜色和宽度。

outline-color outline-style  outline-width 如果直接写按照这个顺序来设置

#### 4.盒子模型

当您指定一个 CSS 元素的宽度和高度属性时，你只是设置内容区域的宽度和高度。要知道，完整大小的元素，你还必须添加内边距，边框和边距。

##### 4.1width

border 边框

border-width 设置边框的宽度

border-style 设置边框风格 dotted 点线边框 dashed 虚线边框 solid 实现边框  

border-color 设置边框的颜色

可以单独设置各边

可以按照上面的顺序简写

padding 内边距  写一个所有都设置 写两个也是 写三个按照顺时针设置

margin 外边距

##### 4.2选择器

**id 选择器 #id**

**类选择器 .class**

/* 选择所有元素

**后代选择器**

element element 空格 后代选择器 选择所有前一个后代

element>element 大于 子元素选择器 选择所有父类是前一个element 的元素

交集选择器 

element，element  并集选择器

**伪类选择器**

#### 5.伪类和伪元素

##### 5.1 伪类和伪元素的区别

- 伪类和伪元素都是为了给一些特殊需求加样式，定义上基本一致。
- 伪类像类选择器一样给已经存在的某个元素添加额外的样式 伪元素则是给自己虚拟的元素添加样式。
- 已经存在元素是指DOM中存在的，伪元素则是虚拟的一种 样式也是给这个虚拟的元素使用的 比如一个虚拟的div
- 声明不同，伪类和选择器之间用一个冒号隔开 伪元素则用两个

##### 5.2 常用的伪类

常用的伪类有两类UI伪类和结构伪类。

**5.2.1hover 和 active**

这两个属于UI伪类(link/active/visted/hover) 四个中的其中两个，hover指当鼠标移动到元素上时触发某种样式；active指鼠标按下时的某种样式。

hover使用场景：一些可点击的列表，表格行 卡片等 鼠标放上去后背景会发生变化，就可以使用hover；

active 使用场景：按钮按下 图片按下以及一些可地啊你元素或者组件等按下操作样式改变。

```html
    .btn{
        height: 34px;
        padding: 6px 12px;
        border-radius: 4px;
        font-size: 15px;
        color: rgba(0,0,0,.65);
        font-weight: 400;
        outline: none;
        border: 1px solid #cbcbcb;
    }
    .btn:hover{
        border-color: #3385ff;
        color: #3385ff;
    }
    
    .btn2{
        height: 34px;
        padding: 6px 12px;
        border-radius: 4px;
        font-size: 15px;
        color: #fff;
        background: #3385ff;
        border-width: 0;
        font-weight: 400;
        outline: none;
    }
    .btn2:active{
        border: 1px solid #3385ff;
        color: #3385ff;
        background: #fff;
    }
```

使用非常简单，就是在类选择器后面**使用一个冒号**后面根据需求是鼠标放上去时触发还是按下时触发决定使用哪一个伪类。如上面第一个btn是( .btn:hover ) 第二个则是( .btn2:active )。

**5.2.2.first-child  last-child  nth-child(n/odd/even)**

这三个属于结构伪类，常用来给表格或者列表添加样式。

- 假设父元素是一个div，使用样式class=‘box’；

- 那么当定义.box:first-child或者.box:last-child时分别是指**给div的第一个或者最后一个子元素添加样式**。

- nth-child这个就比较牛掰了，

  参数是一个数值代表给第几个元素添加样式，如果是odd标示给元素为奇数的添加样式，even则是给是偶数的元素添加样式


##### 5.3 常用伪元素

**before 和 after**是经常经常重用的伪元素。我们直接看两个最简单的例子。再一句话的前面(before)和后面(after)分别添加一个圆形和一个矩形。

```html
 <p>wonyun!</p>
    <style>
        p:before{content: "hello "}
        p:after{content: "you are handsome!"}
    </style>
```

上面例子从技术角度看，等价于下面的html结构：

```html
 <p>
        <span>hello </span>
        wonyun!
        <span> you are handsome!</span>
    </p>
```

由此可知：**伪元素:before和:after添加的内容默认是`inline`元素**；这个两个伪元素的`content`属性，表示伪元素的内容,设置:before和:after时必须设置其`content`属性，否则伪元素就不起作用。那么问题来了，`content`属性的值可以有哪些内容呢，具体有以下几种情况：

- `字符串`，字符串作为伪元素的内容添加到主元素中

  > **注意**：字符串中若有html字符串，添加到主元素后不会进行html转义，也不会转化为真正的html内容显示，而是会原样输出

- `attr(attr_name)`, 伪元素的内容跟主元素的某个属性值进行关联，及其内容为主元素的某指定属性的值

  > **好处**：可以通过js动态改变主元素的指定属性值，这时伪元素的内容也会跟着改变，可以实现某些特殊效果，如图片加载失败用一段文字替换。

- `url()/uri()`, 引用外部资源，例如图片；

- `counter()`, 调用计数器，可以不使用列表元素实现序号问题。

**before和:after特点**

面说了，伪元素是通过样式来达到元素效果的，也就是说伪元素不占用dom元素节点，引用[:before,:after伪元素妙用](http://www.alloyteam.com/2015/04/beforeafter伪元素妙用/)里面总结的，:before和:after伪元素的主要特点如下：

- **伪元素不属于文档**，所以js无法操作它
- 伪元素属于主元素的一部分，因此**点击伪元素触发的是主元素的click事件**
- 原文说块级元素才能有:before, :after，其实是不妥的，大部分行级元素也可以设置伪元素，但是像img可替换元素，因为其外观和尺寸有外部资源决定，那么如果外部资源正确加载，就会替换掉其内部内容，这时伪元素也会被替换掉，但是当外部资源加载失败时，设置的伪元素是可以起作用的。

基于伪元素的特点可以知道其优缺点，也引用别人文章的话：

- 优点
  - 减少dom节点数
  - 让css帮助解决部分js问题，让问题变得简单
- 缺点
  - 不利于SEO
  - 无法审查元素，不利于调试

**伪元素的一些用法**

https://www.cnblogs.com/wonyun/p/5807191.html

#### 6.优先级

**CSS 优先规则1：** 最近的祖先样式比其他祖先样式优先级高。

例1：

```html
<!-- 类名为 son 的 div 的 color 为 blue -->
<div style="color: red">
    <div style="color: blue">
        <div class="son"></div>
    </div>
</div>
```

如果我们把一个标签从祖先那里继承来的而自身没有的属性叫做"祖先样式"，那么"直接样式"就是一个标签直接拥有的属性。又有如下规则：

**CSS 优先规则2：**"直接样式"比"祖先样式"优先级高。

例2：

```
<!-- 类名为 son 的 div 的 color 为 blue -->
<div style="color: red">
    <div class="son" style="color: blue"></div>
</div>
```

**CSS 优先规则3：**优先级关系：内联样式 > ID 选择器 > 类选择器 = 属性选择器 = 伪类选择器 > 标签选择器 = 伪元素选择器

例3：

```
// HTML
<div class="content-class" id="content-id" style="color: black"></div>

// CSS
#content-id {
    color: red;
}
.content-class {
    color: blue;
}
div {
    color: grey;
}
```

最终的 color 为 black，因为内联样式比其他选择器的优先级高。

所有 CSS 的选择符由上述 7 种基础的选择器或者组合而成，组合的方式有 3 种：

- 后代选择符： .father .child{}
- 子选择符： .father > .child{}
- 相邻选择符: .bro1 + .bro2{}

当一个标签同时被多个选择符选中，我们便需要确定这些选择符的优先级。我们有如下规则：

**CSS 优先规则4：**计算选择符中 ID 选择器的个数（a），计算选择符中类选择器、属性选择器以及伪类选择器的个数之和（b），计算选择符中标签选择器和伪元素选择器的个数之和（c）。按 a、b、c 的顺序依次比较大小，大的则优先级高，相等则比较下一个。若最后两个的选择符中 a、b、c 都相等，则按照"就近原则"来判断。

例4：

```
// HTML
<div id="con-id">
    <span class="con-span"></span>
</div>

// CSS
#con-id span {
    color: red;
}
div .con-span {
    color: blue;
}
```

由规则 4 可见，<span> 的 color 为 red。

**CSS 优先规则5：**属性后插有 **!important** 的属性拥有最高优先级。若同时插有 **!important**，则再利用规则 3、4 判断优先级。

例6：

```
// HTML
<div class="father">
    <p class="son"></p>
</div>

// CSS
p {
    background: red !important;
}
.father .son {
    background: blue;
}
```

虽然 .father .son 拥有更高的权值，但选择器 p 中的 background 属性被插入了 !important， 所以 <p> 的 background 为 red。

#### 7.css定位(

##### 7.1 static

HTML 元素的默认值，即没有定位，遵循正常的文档流对象。静态定位的元素不会受到 top, bottom, left, right影响。

##### 7.2 相对定位 relative

```html
h2.pos_left
{
    position:relative;
    left:-20px;
}
h2.pos_right
{
    position:relative;
    left:20px;
}

```

需要注意的是 相对定位位置移动时 其原本所占的空间不会改变

##### 7.3绝对定位 absolute

绝对定位的元素的位置相对于最近的已定位父元素，如果元素没有已定位的父元素，那么它的位置相对于<html>:(非static）

```
h2
{
    position:absolute;
    left:100px;
    top:150px;
}
```

absolute 定位使元素的位置与文档流无关，因此不占据空间。

absolute 定位的元素和其他元素重叠。

##### 7.4 sticky定位

sticky 英文字面意思是粘，粘贴，所以可以把它称之为粘性定位。

**position: sticky;** 基于用户的滚动位置来定位。

粘性定位的元素是依赖于用户的滚动，在 **position:relative** 与 **position:fixed** 定位之间切换。

它的行为就像 **position:relative;** 而当页面滚动超出目标区域时，它的表现就像 **position:fixed;**，它会固定在目标位置。

元素定位表现为在跨越特定阈值前为相对定位，之后为固定定位。

这个特定阈值指的是 top, right, bottom 或 left 之一，换言之，指定 top, right, bottom 或 left 四个阈值其中之一，才可使粘性定位生效。否则其行为与相对定位相同。

```
div.sticky {
    position: -webkit-sticky; /* Safari */
    position: sticky;
    top: 0;
    background-color: green;
    border: 2px solid #4CAF50;
}
```

##### 7.5 浮动

https://www.w3school.com.cn/css/css_positioning_floating.asp

##### 7.6 超出边框处理

```
div.ex1 {
    overflow: scroll     //无论内容 都会出现滚动条
}
 
div.ex2 {
    overflow: hidden;  隐藏
}
 
div.ex3 {
    overflow: auto;   根据内容出现滚动条与否
}
 
div.ex4 {
    overflow: visible;   默认情况 会直接溢出
}
```

##### 7.7 图层

```html
img
  {
  position:absolute;
  left:0px;
  top:0px;
  z-index:-1;
  }
```

#### 8 布局

##### 8.1 单列布局

##### 8.2 2列布局 2列自适应

##### 8.3 3列布局 3列自适应

#### 9 动画



**transition:**

rotate 45(deg) 旋转

scale(1.2) 放大

translate(30px,3opx) 移动



**transition:**

一定时间之内 一组css属性变换到另一组属性的动画展示过程

属性：

transition-property：动画展示哪些属性 可以使用all 关键字

transition-duration: 动画过程有多久

transition-timing-funcyion:linear,ease,ease-in,ease-out,ease-in-out 贝塞尔曲线等：控制动画速度变化

transition-delay：动画是否延迟执行；

一般来说，将transition属性应用到最初的样式里，而不是放在结束的样式里，

即定义动画开始之前的元素外观的样式。

只需要给元素设置一次transition，浏览器就会负责以动画展示从一个样式到另一个样式，再返回最初样式的变化过程。

1. 需要一个事件来触发，比如hover，所以没法在网页加载时自动触发。

2. 是一次性的，不能重复发生，除非一再触发。

3. 只能定义开始状态和结束状态，不能定义中间状态，也就是说只有两个状态。

4. 一条transition规则，只能定义一个属性的变化，不能涉及多个属性。



与transition不同的是，animation可以通过keyframes显式控制当前帧的属性值，

而transition只能隐式来进行（不能指定每帧的属性值），所以相对而言animation的功能更加灵活。

animation-name：keyframes中定义的动画名称；

animation-duration：动画执行一次持续的时长；

animation-timing-function：动画速率变化函数；

animation-delay：动画延迟执行的时间；

animation-iteration-count：动画执行的次数，可以是数字，或者关键字（infinate）;

animation-direction：alternate(奇数次超前运行，偶数次后退运行)。

animation-fill-mode：告诉浏览器将元素的格式保持为动画结束时候的样子。





clip:rect( ) 裁剪