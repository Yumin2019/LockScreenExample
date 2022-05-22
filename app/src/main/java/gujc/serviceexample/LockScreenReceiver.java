package gujc.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LockScreenReceiver extends BroadcastReceiver {
    final String TAG = getClass().getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, "onReceive: " + action);

        if(action.equals(Intent.ACTION_SCREEN_ON)) {
            Intent startLockscreenActIntent = new Intent(context, LockScreenActivity.class);
            startLockscreenActIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startLockscreenActIntent);
        }
    }
}
