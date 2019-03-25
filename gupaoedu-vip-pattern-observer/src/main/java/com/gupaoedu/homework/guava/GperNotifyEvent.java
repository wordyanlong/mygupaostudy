package com.gupaoedu.homework.guava;

import com.google.common.eventbus.EventBus;

public class GperNotifyEvent {

    private static EventBus eventBus = new EventBus();

    private GperNotifyEvent() {

    }

    public static EventBus getInstance() {
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }
}
