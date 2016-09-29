package qianfeng.a5_1broadcastreceiver2_application;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// 动态创建广播的核心就是：registerReceiver()  注册广播，就是动态创建广播的核心
//

public class MainActivity extends AppCompatActivity {

    private MyBroadcast2 myBroadcast2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        { // 这种方式是 动态创建广播，而且是有自定义权限的广播
            myBroadcast2 = new MyBroadcast2();
            IntentFilter filter = new IntentFilter();
            filter.addAction("qianfeng.android");
            registerReceiver(myBroadcast2,filter,"custom.qianfeng",null);
        }

    }

    // 发送无序广播
    public void sendBoardcast(View view) { // 静态创建自定义广播，配合清单文件里注册的Action的名字一起使用

        Intent intent = new Intent("qianfeng.android"); // "qianfeng.android" 是一个Action
        sendBroadcast(intent); // 发送一条广播，这个广播是在配置清单里面就写好的Action,是自定义的Action,不是系统自带的。

        // 点击按钮，就发送广播，运用的是 sendBroadcast()方法，在这个方法里面，传入的是intent对象，
        // intent里面可以传入的参数是Action，跟静态注册里面的 Filter 里面的 Action属性中指定 name是一样的。



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcast2);
    }

    public void sendBoardcast2(View view) {  // 发送有序广播

        Intent intent = new Intent("android.android");
//        sendOrderedBroadcast(intent,null);
        // 不要企图利用intent来传递广播信息，一定要使用广播里面可传递信息的三种方法,在intent携带参数进行传递再修改是无效的,intent可以传，但不能被修改

        // 要传递信息，请使用 下面这种发送有序广播的方法(使用刚刚的重载方法)
        Bundle bundle = new Bundle();
        bundle.putString("nickname","张三");
        sendOrderedBroadcast(intent,null,new MyBroadcast3(),null,18,"zhangsan",bundle);


    }
}
