

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by mohammad on 12/17/2016.
 */
public class AlertReceier extends BroadcastReceiver{
        public AlertReceier(){
        }
    @Override
    public void onReceive(Context context, Intent intent) {

            if(intent.getAction().equalsIgnoreCase("com.kafrmalik.mohammad")){
            PendingIntent notification = PendingIntent.getActivity(context, 0,
                    new Intent(context,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.mypic)
                    .setContentTitle("Mohammad Omar Taha")
                    .setContentText(" Fool me once shame on you, fool me twice shame on me .");
            builder.setContentIntent(notification);
            builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
            builder.setAutoCancel(true);
            builder.setVibrate(new long[] { 1000, 1000});
            NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            nm.cancel(0);
            nm.notify(0,builder.build());
            }
            else if (intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")){

                   //

            }
    }
}
