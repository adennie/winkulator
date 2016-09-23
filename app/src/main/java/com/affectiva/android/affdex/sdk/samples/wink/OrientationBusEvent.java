package com.affectiva.android.affdex.sdk.samples.wink;


public class OrientationBusEvent extends RxBus.BusEvent {

    public float pitch;
    public float roll;
    public float yaw;
    public OrientationBusEvent(float pitch, float roll, float yaw) {
        super(RxBus.BusEventType.FACE_ORIENTATION);
        this.pitch = pitch;
        this.roll = roll;
        this.yaw = yaw;
    }
}
