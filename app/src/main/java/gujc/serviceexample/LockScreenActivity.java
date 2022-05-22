package gujc.serviceexample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class LockScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);
        setScreenOption(true);
    }

    void setScreenOption(boolean isEnabled) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(isEnabled);
            setTurnScreenOn(isEnabled);
        } else {
            if (isEnabled) {
                this.getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
                this.getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            } else {
                this.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
                this.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
                this.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setScreenOption(false);
    }
}

