package com.example.numberprogressbardemo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity implements OnProgressBarListener{

	
	 private Timer timer;

	    private NumberProgressBar bnp;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);

	        bnp = (NumberProgressBar)findViewById(R.id.numberbar1);
	        bnp.setOnProgressBarListener(this);
	        timer = new Timer();
	        timer.schedule(new TimerTask() {
	            @Override
	            public void run() {
	                runOnUiThread(new Runnable() {
	                    @Override
	                    public void run() {
	                        bnp.incrementProgressBy(1);
	                    }
	                });
	            }
	        }, 1000, 100);
	    }

	    @Override
	    protected void onDestroy() {
	        super.onDestroy();
	        timer.cancel();
	    }

	    @Override
	    public void onProgressChange(int current, int max) {
	        if(current == max) {
	            Toast.makeText(getApplicationContext(),"完成", Toast.LENGTH_SHORT).show();
	            bnp.setProgress(0);
	            timer.cancel();
	        }
	    }
}
