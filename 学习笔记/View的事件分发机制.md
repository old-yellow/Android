# View的事件分发机制

点击事件（MotionEvent）的传递规则

```java
public boolean dispatchTouchEvent(MotionEvent ev) {
    boolean consume = false;
    if(onIntercepteTouchEvent(ev)) {
        consume = onTouchEvent(ev);
    } else {
        consume = child.dispatchTouchEvent(ev);
    }
    
    return consume;
}
```

