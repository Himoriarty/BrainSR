package com.bcisr.moriarty.bcisr;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

public class MainActivity extends AppCompatActivity {

    private static ViewGroup getRootGroup(Activity activity){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            return (ViewGroup)activity.findViewById(android.R.id.content);
        }else{
            return (ViewGroup) activity.getWindow().getDecorView().getRootView();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SimpleDraweeView gifView = (SimpleDraweeView) findViewById(R.id.gif_show);

        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>(){
            @Override
            public void onFainalImageSet(
                String id, ImageInfo imageInfo, Animatable anim){
                    if (anim != null){
                        int duration = 0;
                        try{

                        }
                        anim.start();
                    }
                }
        };

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("res://"+getPackageName()+"/"+R.drawable.gif))
                .setControllerListener(controllerListener)
                .build();
        gifView.setController(controller);
    }
}
