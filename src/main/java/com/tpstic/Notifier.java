package com.tpstic;

import java.util.ArrayList;
import java.util.List;

// 传入包含回调函数的对象
public class Notifier {
    private List<Event> eventListenerList = new ArrayList();
    private Boolean doWaiting;

    public void regist(Event event) {
        eventListenerList.add(event);
    }

    public void doWork(String EventInfo) {
        for (Event event : eventListenerList) {
            // 触发回调函数
            event.processEvent(EventInfo);
        }
    }

    public Boolean getDoWaiting() {
        return doWaiting;
    }

    public void setDoWaiting(Boolean doWaiting) {
        this.doWaiting = doWaiting;
    }
}