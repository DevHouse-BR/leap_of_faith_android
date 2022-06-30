package br.com.devhouse.leap_of_faith;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Desligar o titulo da janela
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Ativar fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //setar o MainGamePanel como View
        setContentView(new MainGamePanel(this));

        // setContentView(R.layout.activity_main);

        Log.d(TAG, "View Adicionada");
    }

    @Override
    protected void onDestroy(){
        Log.d(TAG, "Destruindo...");
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        Log.d(TAG, "Parando...");
        super.onStop();
    }
}