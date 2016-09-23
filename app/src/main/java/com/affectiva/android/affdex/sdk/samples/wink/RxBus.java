/*
 * Copyright (c) 2015 WHOOP, Inc. All rights reserved.
 */

package com.affectiva.android.affdex.sdk.samples.wink;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;


public class RxBus {
    private static RxBus INSTANCE;
    private final Subject<BusEvent, BusEvent> bus
            = new SerializedSubject<>(PublishSubject.<BusEvent>create());

    public static RxBus getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RxBus();
        }
        return INSTANCE;
    }

    public void send(BusEvent e) {
        bus.onNext(e);
    }

    public Observable<BusEvent> observeEvents() {
        return bus;
    }

    public enum BusEventType {
        FACE_FOUND,
        FACE_LOST,
        FACE_ORIENTATION,
        WINK_START,
        WINK_STOP;
    }


    public static class BusEvent {
        public BusEventType type;


        public BusEvent(BusEventType type) {
            this.type = type;
        }
    }
}
