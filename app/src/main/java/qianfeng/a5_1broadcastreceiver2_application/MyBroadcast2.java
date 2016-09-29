package qianfeng.a5_1broadcastreceiver2_application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class MyBroadcast2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("google-my:", "onReceive: 22222222222222222222222222");
    }
}
