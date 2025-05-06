package br.edu.ufam.testenotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class NotificationPub extends BroadcastReceiver {

    public static String ID = "notification-id";
    public static String NOTIFICATION = "notification";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("debug","Trying rcv notif");
        NotificationChannel channel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel(
                    "br.edu.ufam.testenotification",
                    "testeNotification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
        }
        NotificationManager nfm = (NotificationManager)
                context.getSystemService(
                        Context.NOTIFICATION_SERVICE
                );
        if(nfm != null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                nfm.createNotificationChannel(channel);
                Log.i("debug","criando canal de notif");
            }
        }
        Log.i("debug","notificando...");
        Notification nf = intent.getParcelableExtra(NOTIFICATION);
//        int id = intent.getIntExtra(ID, 0 );
//        nfm.notify(id,nf);
        String channelID = "CHANNEL_ID_NOTIFICATION";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                context, channelID
        );

        builder.setSmallIcon(R.drawable.baseline_info_24)
                .setContentTitle("Titulo")
                .setContentText("Notificacao tops")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        nfm.notify(1, builder.build());
    }
}
