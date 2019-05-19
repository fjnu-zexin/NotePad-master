
# NotePad
该项目功能介绍如下：
# 基本功能一：增加时间戳
#### 步骤1.增加TestView
打开notelist_item.xml,增加一个TestView用来显示时间戳
![img](https://github.com/fjnu-zexin/test1/blob/master/img/1.PNG)



#### 步骤2：创建类MySimpleCursorAdapter
由于NotesList使用SimpleCursorAdapter来绑定显示数据。所以需要创建MySimpleCursorAdapter并继承SimpleCursorAdapter用来编写显示时间戳的代码
![img](https://github.com/fjnu-zexin/test1/blob/master/img/2.PNG) 


#### 步骤3.修改NotesList
将new SimpleCursorAdapter改为new MySimpleCursorAdapter，在dataColumns增加一个NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE，viewIDs增加一个android.R.id.text2。
![img](https://github.com/fjnu-zexin/test1/blob/master/img/3.PNG)

# 基本功能二：增加查询功能
#### 步骤1.添加搜索组件
在menu->list_options_menu.xml中增加一个item项
并添加属性android:actionViewClass="android.widget.SearchView"，说明这个菜单使用SearchView组件
![img](https://github.com/fjnu-zexin/test1/blob/master/img/4.PNG)

#### 步骤2：增加SearchView事件
在NoteList中的onCreateOptionsMenu方法中，使用setOnQueryTextListener监听OnQueryText事件，重写OnQueryTextListener接口的两个函数onQueryTextSubmit，onQueryTextChange
![img](https://github.com/fjnu-zexin/test1/blob/master/img/5.PNG)

#### 步骤3：编写方法searchNote
在方法managedQuery中的参数selection中，可用sql语言对数据库进行检索。创建新的adapter用来显示检索后的匹配内容
![img](https://github.com/fjnu-zexin/test1/blob/master/img/6.PNG)


# 附加功能一：优化UI
#### 步骤
打开res->drawable,替换相应图标的图片即可替换UI
![img](https://github.com/fjnu-zexin/test1/blob/master/img/10.PNG)



# 附加功能二：更改记事本背景

在layout->note_editor.xml中添加属性android：background，即可更改图片

![img](https://github.com/fjnu-zexin/test1/blob/master/img/7.PNG)

# 实现程序截图：

<img src="https://github.com/fjnu-zexin/test1/blob/master/img/8.PNG" width = 50%/>

<img src="https://github.com/fjnu-zexin/test1/blob/master/img/9.PNG" width = 50%/>





