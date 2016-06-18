# AnyImageView
 A library Android support custommize ImageView . 
### setup 
in your file gradle  : 
```groovy 
repositories {
     maven {
        url 'https://dl.bintray.com/dangngocduc/maven'
    }
}

```

add line below  to  _dependencies_
```groovy
compile 'android.dangngocduc:anyimageview:1.2.1'
```
### Usage
**1. _CircleImageView_**
```xml
   <android.dangngocduc.anyimageview.CircleImageView
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_centerInParent="true"
        android:src="@drawable/avatar"
    />
```
# Demo  
![](https://raw.githubusercontent.com/dangngocduc/AnyImageView/master/demo/circle_image.png)


