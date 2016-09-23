package com.affectiva.android.affdex.sdk.samples.wink;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * The launch Activity for the app.  Handles camera permission request on Marshmallow+ and
 * provides a button to launch the second Activity.
 * <p>
 * See the README.md file at the root of the ServiceFrameDetectorDemo module for more info on this
 * sample app.
 */
public class MainActivity extends BaseActivity {
    private final static int CAMERA_PERMISSIONS_REQUEST_CODE = 0;
    private final static String[] CAMERA_PERMISSIONS_REQUEST = new String[]{Manifest.permission.CAMERA};
    private boolean handleCameraPermissionGrant;
    private RxBus bus = RxBus.getInstance();

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonDivision ,
            buttonMul , button10 , buttonC , buttonEqual ;
    EditText displayValue;
    float valOne, valTwo;
    boolean adding, subtracting, multiplying, dividing;

    private int displayHeight;
    private int displayWidth;
    private View dot;
    private View contentView;
    private float dotX;
    private float dotY;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        displayHeight = displayMetrics.heightPixels;
        displayWidth = displayMetrics.widthPixels;

        setContentView(R.layout.activity_main);
        contentView = ((ViewGroup)findViewById(android.R.id.content)).getChildAt(0);

        dot = findViewById(R.id.dot);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        displayValue = (EditText) findViewById(R.id.edt1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+"0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (displayValue == null){
                    displayValue.setText("");
                }else {
                    valOne = Float.parseFloat(displayValue.getText() + "");
                    adding = true;
                    displayValue.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valOne = Float.parseFloat(displayValue.getText() + "");
                subtracting = true ;
                displayValue.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valOne = Float.parseFloat(displayValue.getText() + "");
                multiplying = true ;
                displayValue.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valOne = Float.parseFloat(displayValue.getText()+"");
                dividing = true ;
                displayValue.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valTwo = Float.parseFloat(displayValue.getText() + "");

                if (adding == true){

                    displayValue.setText(valOne + valTwo +"");
                    adding =false;
                }

                if (subtracting == true){
                    displayValue.setText(valOne - valTwo +"");
                    subtracting =false;
                }

                if (multiplying == true){
                    displayValue.setText(valOne * valTwo +"");
                    multiplying =false;
                }

                if (dividing == true){
                    displayValue.setText(valOne / valTwo +"");
                    dividing =false;
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayValue.setText(displayValue.getText()+".");
            }
        });

        // on Marshmallow+, we have to ask for the camera permission the first time
        if (!CameraHelper.checkPermission(this) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(CAMERA_PERMISSIONS_REQUEST, CAMERA_PERMISSIONS_REQUEST_CODE);
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onResume() {
        super.onResume();
        if (handleCameraPermissionGrant) {
            // a response to our camera permission request was received
            if (CameraHelper.checkPermission(this)) {
                startService(new Intent(this, DetectorService.class));
            } else {
                Toast.makeText(MainActivity.this, R.string.camera_permission_denied, Toast.LENGTH_LONG).show();
            }
            handleCameraPermissionGrant = false;
        }

        bus.observeEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .forEach(new Action1<RxBus.BusEvent>() {
                    @Override
                    public void call(RxBus.BusEvent busEvent) {
                        switch (busEvent.type) {
                            case FACE_FOUND:
                                Toast.makeText(MainActivity.this, R.string.face_found, Toast.LENGTH_SHORT).show();
                                dot.setBackground(getResources().getDrawable(R.drawable.dot_red));
                                dot.setVisibility(View.VISIBLE);
                                break;
                            case FACE_LOST:
                                Toast.makeText(MainActivity.this, R.string.face_lost, Toast.LENGTH_SHORT).show();
                                dot.setVisibility(View.INVISIBLE);
                                break;
                            case FACE_ORIENTATION:
                                OrientationBusEvent e = (OrientationBusEvent) busEvent;

                                // translate yaw range of [-20, 20] to X coordinate
                                if (e.yaw < -20f) {
                                    dotX = 0;
                                } else if (e.yaw > 20f) {
                                    dotX = displayWidth;
                                } else {
                                    dotX = displayWidth * (e.yaw + 20f) / 40f;
                                }

                                // translate pitch range of [-10,30] to Y coordinate
                                if (e.pitch < -10f) {
                                    dotY = displayHeight;
                                } else if (e.pitch > 30f) {
                                    dotY = 0;
                                } else {
                                    dotY = displayHeight - displayHeight * (e.pitch+10) / 40f;
                                }

                                Log.d(WinkApplication.LOG_TAG, "x/y = " + Float.toString(dotX)
                                        + "/" + Float.toString(dotY));

                                dot.setX(dotX);
                                dot.setY(dotY);

                                break;
                            case WINK_START:
                                contentView.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(),
                                        SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, dotX, dotY, 0));
                                contentView.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(),
                                        SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, dotX, dotY, 0));
                                dot.setBackground(getResources().getDrawable(R.drawable.dot_blue));
                                break;
                            case WINK_STOP:
                                dot.setBackground(getResources().getDrawable(R.drawable.dot_red));
                                break;
                        }
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSIONS_REQUEST_CODE) {
            for (String permission : permissions) {
                if (permission.equals(Manifest.permission.CAMERA)) {
                    // next time through onResume, handle the grant result
                    handleCameraPermissionGrant = true;
                    break;
                }
            }
        }
    }
}
