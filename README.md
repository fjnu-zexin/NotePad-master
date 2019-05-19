# NotePad
This is an AndroidStudio rebuild of google SDK sample NotePad
# 一、首先是时间显示问题
#### 1.修改view
我们先从view开始，先把要显示时间的view做好。经过观察，本程序在NotesList中继承ListActivity来显示笔记列表，NotesList中使用了SimpleCursorAdapter来绑定数据，我们可以看到每个Item的view是用R.layout.noteslist_item。
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/2.png">

所以我们在res中找到layout->noteslist_item这个xml，在原本显示标题的TextView下增加一个显示时间的TextView。
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/1.png">

#### 2.修改Adapter
由于NotesList使用SimpleCursorAdapter来绑定显示数据。按住Ctrl键点击SimpleCursorAdapter这个类查看他的源码。
![img](https://raw.githubusercontent.com/huadream/NotePad/master/picture/3.png)
 
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/4.png">

通过观察源代码可以看到ListView是调用他的bindView函数进行UI更新，所以我们要从这个函数下手，我们新建自己的类MySimpleCursorAdapter继承SimpleCursorAdapter，使用Alt+Insert唤出Generate菜单选择Override Methods
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/5.png">

<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/6.png">

找到bindView这个函数ok来重写他，为了方便，我们先使用super.bindView(view, context, cursor);调用原函数来进行默认UI更新，然后在增加我们自己写的内容，如图所示，重写这个bindView的函数。
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/7.png">

#### 3.修改NotesList
首先，将new SimpleCursorAdapter改为new MySimpleCursorAdapter，由于我们增加了一个数据显示，所以dataColumns增加一个NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE，viewIDs增加一个android.R.id.text2，这个text2就是我们在noteslist_item中增加来显示时间的TextView的id。
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/8.png">

# 二、增加搜索功能
#### 1.先找数据源
显示笔记本列表的是NotesList，绑定数据用的是SimpleCursorAdapter，数据来源是cursor，而cursor是通过managedQuery这个函数得到的
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/10.png">

按住Ctrl放在managedQuery上面可以看到managedQuery的文档，通过文档我们得知，selection参数就是SQL WHERE的语句，所以，通过selection参数就可以过滤记事本进行查询操作。
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/11.png">

#### 2.增加搜索组件
首先，观察源码后发现NotesList使用了menu以及ActionBar，然后就想到ActionBar有个控件---SearchView，我们在NotesList找到onCreateOptionsMenu函数得知其使用R.menu.list_options_menu，在res找到menu->list_options_menu，增加一个菜单项然后增加一个属性android:actionViewClass="android.widget.SearchView"，说明这个菜单使用SearchView组件。
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/12.png">

#### 3.增加SearchView事件
由于，SearchView是在菜单创建后创建的，所以我们将SearchView的事件绑定放在onCreateOptionsMenu，使用setOnQueryTextListener监听OnQueryText事件，重写OnQueryTextListener接口的两个函数onQueryTextSubmit，onQueryTextChange，参数就是搜索内容。
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/13.png">

<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/14.png">

# 三、实现效果
<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/15.png" width = 50%/>

<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/16.png" width = 50%/>

<img src="https://raw.githubusercontent.com/huadream/NotePad/master/picture/17.png" width = 50%/>

