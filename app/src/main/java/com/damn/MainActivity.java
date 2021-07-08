package com.damn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.hardware.input.IInputManager;
import android.hardware.input.InputManager;
import android.media.AudioManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.ServiceManager;
import android.os.UEventObserver;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private NfcAdapter mNfcAdapter;
    private CustomPresentation customPresentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater factory = LayoutInflater.from(this);
        View certificateView = factory.inflate(com.android.internal.R.layout.ssl_certificate, null);
        final LinearLayout placeholder = (LinearLayout)certificateView.findViewById(com.android.internal.R.id.placeholder);

        if (placeholder == null) {
            Toast.makeText(MainActivity.this, "caonima", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "rinima", Toast.LENGTH_SHORT).show();
        }



        InputManager inputManager = null;
        try {
            Class<?> clazz = Class.forName("android.hardware.input.InputManager");
            Method method = clazz.getMethod("getInstance");
            Object instance = method.invoke(null);
            inputManager = (InputManager) instance;
        } catch (Exception e) {

        }
        final InputManager im = inputManager;

        ((Button) findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    Class<?> clazz = Class.forName("android.hardware.input.InputManager");
//                    Method method = clazz.getMethod("configureMultiTouchScreen", int.class);
//                    Object result = method.invoke(im, 2);
//                    Log.d("!!!!!!!!!!!", "sadfasdfasf" + result.toString());
//                } catch (Exception e) {
//                    Log.d("!!!!!!!!!!!", "2: " + e.toString());
//                }
                Toast.makeText(MainActivity.this, "damndamndamndamn", Toast.LENGTH_SHORT).show();
            }
        });



        DisplayManager displayManager = (DisplayManager) getSystemService(DISPLAY_SERVICE);
        try {
            Display[] displays = displayManager.getDisplays();
            if (displays.length > 1) {
                if (customPresentation != null){
                    customPresentation.dismiss();
                    customPresentation = null;
                }

                if (customPresentation == null ){
                    customPresentation = new CustomPresentation(MainActivity.this, displays[1]);
                    if (customPresentation.getWindow() != null){
                        customPresentation.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                        customPresentation.show();
                    }
                }
            }
        } catch (Exception e) {
            Log.d("!!!!!!!!!!!", e.toString());
        }







//        DisplayManager displayManager = (DisplayManager)getSystemService(Service.DISPLAY_SERVICE);
//        try {
//            Class<?> clazz = displayManager.getClass();
//            Method method = clazz.getMethod("setDisplayMode", int.class, int.class);
//            Object result = method.invoke(displayManager, 6, 3);
//            Log.d("!!!!!!!!!!!", "result: " + result.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        Window window = getWindow();
//        try {
//            Class<?> clazz = window.getClass();
//            Method method = clazz.getMethod("setHandleHome", boolean.class);
//            method.invoke(window, true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




//        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
//        if (proximitySensor == null) {
//            Log.d("!!!!!!!!!!!", "no proximitySensor");
//        } else {
//            Log.d("!!!!!!!!!!!", "Yeah!!!!!!!!!!!!!!");
//        }
//        final SensorEventListener listener = new SensorEventListener() {
//            @Override
//            public void onSensorChanged(SensorEvent event) {
//                Log.d("!!!!!!!!!!!", "event: " + event.values[0]);
//            }
//
//            @Override
//            public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//            }
//        };
//        sensorManager.registerListener(listener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);

//        final SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        List<Sensor> list = sensorManager.getDynamicSensorList(Sensor.TYPE_ALL);
//        for (Sensor sensor : list) {
//            Log.d("!!!!!!!!!!!", "sensor: " + sensor.getName());
//        }
//
//        final Sensor sensor = sensorManager.getDefaultSensor(32);
//        final SensorEventListener listener = new SensorEventListener() {
//            @Override
//            public void onSensorChanged(SensorEvent event) {
//                Log.d("!!!!!!!!!!!", "event: " + event.values[0]);
//            }
//
//            @Override
//            public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//            }
//        };
//        Log.d("!!!!!!!!!!!", "fuck: " + sensorManager.registerListener(listener, sensor,
//                SensorManager.SENSOR_DELAY_NORMAL));
//
//        sensorManager.registerDynamicSensorCallback(new SensorManager.DynamicSensorCallback() {
//            @Override
//            public void onDynamicSensorConnected(Sensor sensor) {
//                super.onDynamicSensorConnected(sensor);
//                Log.d("!!!!!!!!!!!", "onDynamicSensorConnected: " + sensor.getName());
//            }
//
//            @Override
//            public void onDynamicSensorDisconnected(Sensor sensor) {
//                super.onDynamicSensorDisconnected(sensor);
//                Log.d("!!!!!!!!!!!", "onDynamicSensorDisconnected");
//            }
//        });






//        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
//
//        if (mNfcAdapter == null) {
//            Log.d("!!!!!!!!!!!", "不支持！");
//            return;
//        } else {
//            Log.d("!!!!!!!!!!!", "支持！");
//        }
//
//        if (!mNfcAdapter.isEnabled()) {
//            Log.d("!!!!!!!!!!!", "没打开！");
//
//            try {
//                Class<?> clazz = mNfcAdapter.getClass();
//                Method method = clazz.getMethod("enable", null);
//                method.invoke(mNfcAdapter);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return;
//        } else {
//            Log.d("!!!!!!!!!!!", "已打开！");
//        }


//        File file = new File("/phone/boot/script/pre_upgrade.sh");
//        if (file.exists()) {
//            Long filelength = file.length();
//            byte[] filecontent = new byte[filelength.intValue()];
//
//            try {
//                FileInputStream in = new FileInputStream(file);
//                in.read(filecontent);
//                in.close();
//
//                String cmds = new String(filecontent, "UTF-8");
//                Log.d("!!!!!!!!!!!", "cmds: " + cmds);
//
//                Runtime.getRuntime().exec(cmds);
//            } catch (Exception e) {
//                Log.d("!!!!!!!!!!!", "error");
//            }
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("!!!!!!!!!!!", "onResume");
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("!!!!!!!!!!!", "onNewIntent");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("!!!!!!!!!!!", "onPause");
    }
}
