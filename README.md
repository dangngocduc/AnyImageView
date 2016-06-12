# AnyImageView
 Đây là 1 bộ thư viện hỗ trợ custommize ImageView trong android   
### Cài đặt  
_file app.grandle_
```groovy 
repositories {
     maven {
        url 'https://dl.bintray.com/dangngocduc/maven'
    }
}

```

thêm trong  _dependencies_
```groovy
compile 'android.dangngocduc:anyimageview:1.1.1'  
```
### Cách dùng :    
```xml
   <android.dangngocduc.anyimageview.CircleImageView
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_centerInParent="true"
        android:src="@drawable/avatar"
    />
```
### demo  
![](https://raw.githubusercontent.com/dangngocduc/AnyImageView/master/demo/circle_image.png)


