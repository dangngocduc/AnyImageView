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
compile compile 'android.dangngocduc:anyimageview:1.2.0' 
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
![](https://cloud.githubusercontent.com/assets/10508979/15991294/fb340f2a-30d8-11e6-8252-c0af2c41d1fb.png)


