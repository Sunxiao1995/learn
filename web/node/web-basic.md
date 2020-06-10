## HTML

#### 1. 什么是HTML？

超文本标记语言（英语：HyperText Markup Language，简称：HTML）

- 是一种用于创建网页的标准标记语言。HTML是一种基础技术，常与CSS、JavaScript一起被众多网站用于设计网页、网页应用程序以及移动应用程序的用户界面。网页浏览器可以读取HTML文件，并将其渲染成可视化网页。HTML描述了一个网站的结构语义随着线索的呈现，使之成为一种标记语言而非编程语言。

#### 2. 文档结构

```html
<!DOCTYPE html>
<html>
    <head>
        ......
    </head>
    <body>
        ......
    </body>
</html>
```

- HTML文档总是以<html>标签开始并以</html>结束
- HTML 有两个主要结构：头部head和主体body。通常将文档的描述信息放在头部，而将文档的主体信息放在主体部分

##### 2.1文档类型声明

​        HTML文档需要以==文档类型声明==（英语非正式说法“doctype”）开头。在浏览器中，文档类型声明有助于确定渲染模式——特别是是否使用怪异模式。
​       文档类型声明的初衷是通过基于文档类型定义（DTD）的SGML工具来解析并验证HTML文档。
​       HTML5未定义DTD，所以在HTML5中文档类型声明更为简短：

`<!DOCTYPE html>`

​      HTML 4文档类型声明举例：

`<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">`

##### 2.2 head

注意head 和header的不同点，head是用于定义文档头部，他是所有头部元素的容器。而header是定义在body里的 用于定义文档的介绍信息等

- **\<title>**

```html
<head>
    <title>文档标题</title>
</head>
```

即我们跳转页面时浏览器上方的位置显示的页面标题

- **\<link>**

```html
<html>

<head>
<link rel="stylesheet" type="text/css" href="/html/csstest1.css" >
</head>

<body>
<h1>我通过外部样式表进行格式化。</h1>
<p>我也一样！</p>
</body>

</html>
```

1. link标签是单标签（空标签），没有元素内容，只有属性；

2.rel属性是用来定义当前文档与被链接文档之间的关系（如：rel="stylesheet"，表示链接文档是一个样式表）；

3.type属性规定被链接文档的MIME类型；

4.href属性定义被链接文档的位置；

5.除了rel、type、href常用属性外，link标签还有很多属性，

- **\<meta>**

​        可提供有关页面的元信息（meta-information），比如针对搜索引擎和更新频度的描述和关键词。

​        \<meta> 标签位于文档的头部，不包含任何内容。\<meta> 标签的属性定义了与文档相关联的名称/值对。

```html
<meta name="keywords" content="HTML,ASP,PHP,SQL">
```

```html
<meta http-equiv="charset" content="iso-8859-1">
<meta http-equiv="expires" content="31 Dec 2008">
```

content 和http-equiv name 等配套使用

里面的内容不会直接显示，只有浏览器可以接受这些附加的头部字段，并能以适当的方式使用它们时，这些字段才有意义。

- **\<script>**

  - \<script> 标签用于定义客户端脚本，比如 JavaScript。

  - script 元素既可以包含脚本语句，也可以通过 src 属性指向外部脚本文件。
  - 必需的 type 属性规定脚本的 MIME 类型。
  - JavaScript 的常见应用时图像操作、表单验证以及动态内容更新。

- **\<style>**

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<title>菜鸟教程(runoob.com)</title>
<style type="text/css">
h1 {color:red;}
p {color:blue;}
</style>
</head>
 
<body>
<h1>这是一个标题</h1>
<p>这是一个段落。</p>
</body>
 
</html>
```

\<style> 标签定义 HTML 文档的样式信息。

在 \<style> 元素中，您可以规定在浏览器中如何呈现 HTML 文档。

每个 HTML 文档能包含多个 \<style> 标签。

##### 2.3 body

body 元素定义文档的主体。

body 元素包含文档的所有内容（比如文本、超链接、图像、表格和列表等等。）



#### 3.全局属性

##### 3.1 class

class 属性规定元素的类名（classname）。

class 属性大多数时候用于指向样式表中的类（class）。不过，也可以利用它通过 JavaScript 来改变带有指定 class 的 HTML 元素。

```html
<html>
<head>
<style type="text/css">
h1.intro {color:blue;}
p.important {color:green;}
  .ss{color:red;}
</style>
</head>

<body>
<h1 class="intro">Header 1</h1>
<p>A paragraph.</p>
<p class="important">Note that this is an important paragraph.</p>
<div class = "ss">
 
  </div>
</body>
</html>
```

在body里可以定义class 可以把需要定义相同style的内容归为一类，然后在head里面可以使用.classname{

color:red  等形式对其作出更改

} 

其中h1.classname 这相当于两者同时符合才可以。

##### 3.2 id

```html
<html>
<head>
<script type="text/javascript">
function change_header()
{
document.getElementById("myHeader").innerHTML="Nice day!";
}
</script>
</head>

<body>
<h1 id="myHeader">Hello World!</h1>
<button onclick="change_header()">Change text</button>
</body>

</html>
```

d 属性规定 HTML 元素的唯一的 id。

id 在 HTML 文档中必须是唯一的。

id 属性可用作链接锚（link anchor），通过 JavaScript（HTML DOM）或通过 CSS 为带有指定 id 的元素改变或添加样式。

##### 3.3 style

```html
<html>

<head>
<style type="text/css">
h1 {color: red
  background:green}
  
p {color: blue}
</style>
</head>

<body>
<h1>header 1</h1>
<p>A paragraph.</p>
</body>

</html>

```

color:red 设置颜色  background-color：red 设置背景色 

 font-family 设置字体                            font-size 设置字体大小

text-align 文本对齐方式

left：左对齐

center：中间对齐

right：右对齐

##### 3.4 data

```html
<!DOCTYPE html>
<html>
<head>
<script>
function showDetails(animal) {
    var animalType = animal.getAttribute("data-animal-type");
    alert(animal.innerHTML + "是一种" + animalType + "。");
}
</script>
</head>
<body>

<h1>物种</h1>

<p>点击某个物种来查看其类别：</p>

<ul>
  <li onclick="showDetails(this)" id="owl" data-animal-type="鸟类">喜鹊</li>
  <li onclick="showDetails(this)" id="salmon" data-animal-type="鱼类">金枪鱼</li>  
  <li onclick="showDetails(this)" id="tarantula" data-animal-type="蜘蛛">蝇虎</li>  
</ul>

</body>
</html>

```



data-* 属性用于存储页面或应用程序的私有自定义数据。

data-* 属性赋予我们在所有 HTML 元素上嵌入自定义 data 属性的能力。

存储的（自定义）数据能够被页面的 JavaScript 中利用，以创建更好的用户体验（不进行 Ajax 调用或服务器端数据库查询）。

data-* 属性包括两部分：

- 属性名不应该包含任何大写字母，并且在前缀 "data-" 之后必须有至少一个字符
- 属性值可以是任意字符串

##### 3.5 hidden 

```html
<!DOCTYPE html>
<html>
<body>

<p hidden="hidden">这是一段隐藏的段落。</p>
<p>这是一段可见的段落。</p>

</body>
</html>
```

hidden 属性是布尔属性。

如果设置该属性，它规定元素仍未或不再相关。

浏览器不应显示已规定 hidden 属性的元素。

hidden 属性也可用于防止用户查看元素，直到匹配某些条件（比如选择了某个复选框）。然后，JavaScript 可以删除 hidden 属性，以使此元素可见。



#### 4.标签

##### 4.1 文字

```html
<pre>
<code>body{
    background:#fff;
      font: 12px/24px 1.66;
}</code>
</pre>
```

pre 标签一般可以用来放代码 歌词等 格式会保留

最好不要嵌套其他会导致段落断开的标签

**问题**

如果我们在pre里放置的文本过长，中间也没有换行，由于pre会保持文本的格式，导致文本溢出。
解决的两种方法：

1 给pre标签定义横向滚动条

2 直接定义pre标签里的css属性white-space的值为pre-wrap。

```html
<html>
<head>
<style>
pre{
  white-space:pre-wrap;
}
</style>
</head>

<body>

<div style="width:500px; background:red; padding:20px;">
<pre>

</pre>
</div>

</body>
</html>
```

##### 4.2 行内元素

- **span**

span标签通常使用来将文本的一部分或者文档的一部分独立出来，从而对独立出来的内容设置单独的样式。

span标签是内联元素，不像块级元素（如：div标签、p标签等）哪样有换行的效果；

如果不对span元素应用样式，使用span标签没有任何的显示效果；

span标签可以设置id或class属性，这样不仅能增加语义，还能更方便的对span元素应用样式；

- **超链接**

```html
<html>

<body>

<a href="http://www.w3school.com.cn/" target="_blank">Visit W3School!</a>
  

  
<h1>
  <a name="C4">ssss</a>
  </h1>
<p>如果把链接的 target 属性设置为 "_blank"，该链接会在新窗口中打开。</p>
  

</body>

</html>
```

这里的Visit W3School! 不一定是文字 也可以是图片或者button等

这里的http://www.w3school.com.cn/改成#C4就可以连接到本文档中的位置。

- 选择列表

```html
<html>

<body>

<form>
<select name="cars">
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="fiat" selected="selected">Fiat</option>
<option value="audi">Audi</option>
</select>
</form>

</body>
</html>

```

这里的selected="selected" 会设置预选值

##### 4.3 可变元素

- **button**

```html
<button type="button">Click Me!</button>
```

<button>标签功能虽然强大，但是在html表单中建议使用<input>标签来创建按钮，因为对于<button>标签在html表单中，不同的浏览器可能提交不同的按钮值。

可以使用 input 创建按钮

- **图片**
```html
  <img src="/i/eg_tulip.jpg"  alt="上海鲜花港 - 郁金香" />
```

```html
<img src="/i/mouse.jpg" height="200" width="200" />
```

height 和width 可以改变图片的大小

- **输入框 input**
  - **form**

<form> 标签用于为用户输入创建 HTML 表单。

表单能够包含 [input 元素](https://www.w3school.com.cn/tags/tag_input.asp)，比如文本字段、复选框、单选框、提交按钮等等。

表单还可以包含 [menus](https://www.w3school.com.cn/tags/tag_menu.asp)、[textarea](https://www.w3school.com.cn/tags/tag_textarea.asp)、[fieldset](https://www.w3school.com.cn/tags/tag_fieldset.asp)、[legend](https://www.w3school.com.cn/tags/tag_legend.asp) 和 [label 元素](https://www.w3school.com.cn/tags/tag_label.asp)。

表单用于向服务器传输数据。



**\<input>** 标签用于搜集用户信息。

根据不同的 type 属性值，输入字段拥有很多种形式。输入字段可以是文本字段、复选框、掩码后的文本控件、单选按钮、按钮等等。

```html
<html>

<body>

<form>
名：
<input type="text" name="firstname">  //name 可以改为user password   type 如果改成checkbox 会生成复选框
<br />
姓：
<input type="text" name="lastname">
</form>

</body>
</html>
```

另一种创建按钮

```html
<html>

<body>

<form>
<input type="button" value="Hello world!">
</form>

</body>
</html>

```



##### 4.4 块级元素

- **段落**

```html
<h1>
  标题
</h1>
<P> 段落<br/>段落中换行 </P>
```

- **列表**

  - 有序列表

  ```html
  <!DOCTYPE html>
  <html>
  <body>
  
  <ol>    //可以定义type 大小写字母开始等
    <li>咖啡</li>
    <li>牛奶</li>
    <li>茶</li>
  </ol>
  
  <ol start="50">   //从50开始的有序列表
    <li>咖啡</li>
    <li>牛奶</li>
    <li>茶</li>
  </ol>
   
  </body>
  </html>
  ```

  - 无序列表

  ```html
  <html>
  
  <body>
  
  <h4>一个无序列表：</h4>
  <ul>   //可以定义type disc circle square 
    <li>咖啡</li>
    <li>茶</li>
    <li>牛奶</li>
  </ul>
  
  </body>
  </html>
  ```

  - 自定义列表

```html
<html>

<body>

<h2>一个定义列表：</h2>

<dl>
   <dt>计算机</dt>
   <dd>用来计算的仪器 ... ...</dd>
   <dt>显示器</dt>
   <dd>以视觉方式显示信息的装置 ... ...</dd>
</dl>

</body>
</html>
dl标签为自定义列表 dt是自定义的列表名  dd是列表的内容
```

