package com.crazystone.test;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.crazystone.utils.quickdev.annotation.SetContentView;
import com.crazystone.utils.quickdev.annotation.ViewInject;
import com.crazystone.utils.BaseActivity;

/**
 * Created by crazystone on 2015/12/31.
 */
@SetContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.txt_main)
    private TextView txt;

    @ViewInject(R.id.edit_main)
    private EditText edit;

    @ViewInject(R.id.btn_main)
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
        txt.setText("size :"+sizeOf("hello",bitmap));
        edit.setText("hehheheheh");
        handControl();
        //IoUtils.class;

//        CameraManager
    }


    private int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

    private void handControl() {

        $(btn);

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.btn_main) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(txt, "rotationY", -90f, 0f);
            animator.setDuration(1000);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.start();
        }
    }
}

