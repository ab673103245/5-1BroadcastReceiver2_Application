package qianfeng.a5_1broadcastreceiver2_application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class MyBroadcast5 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("google-my:", "onReceive: 5");

        int resultCode = getResultCode();
        String resultData = getResultData();
        // 这个getResultExtras的参数设定为true，是如果不存在bundle，它会帮你new一个，里面虽然没内容，但是不报空指针异常
        Bundle resultExtras = getResultExtras(true);
        String nickname = resultExtras.getString("nickname");

        Log.d("google-my:", "onReceive: " + resultData + "," + resultData + "," + nickname);

        setResultData("lisi");
        setResultCode(40);
        Bundle bundle = new Bundle();
        bundle.putString("nickname","李四");
        setResultExtras(bundle);

    }
}
