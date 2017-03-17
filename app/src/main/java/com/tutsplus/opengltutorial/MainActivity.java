package com.tutsplus.opengltutorial;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView mySurfaceView;
    private Torus torus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySurfaceView = (GLSurfaceView)findViewById(R.id.my_surface_view);

        mySurfaceView.setEGLContextClientVersion(2);

        mySurfaceView.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
                mySurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
                torus = new Torus(getApplicationContext());
            }

            @Override
            public void onSurfaceChanged(GL10 gl10, int width, int height) {
                GLES20.glViewport(0,0, width, height);
            }

            @Override
            public void onDrawFrame(GL10 gl10) {
                torus.draw();
            }
        });
    }

}
