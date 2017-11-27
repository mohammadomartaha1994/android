.......... on AndroidManifest

       <receiver
            android:name=".NotificationService"
            android:enabled="true"
            android:exported="false">
            <intent-filter>
            
                <action android:name="com.kafrmalik.mohammad" />                /// name of service
                
                <action android:name="android.intent.action.ACTION_SHUTDOWN" />
                <action android:name="android.intent.action.QUICKBOOT_POWERON" />
                <action android:name="android.intent.action.BOOT_COMPLETED" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </receiver>
        
        
        
............ code on activity


Intent alertIntent = new Intent(getApplicationContext(),NotificationService.class);

alertIntent.setAction("com.kafrmalik.mohammad");   //// name of service should be the same on AndroidManifest

AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime() +
                                10 * 1000,  // 10 seconds
                                PendingIntent.getBroadcast(getApplicationContext(), 0,alertIntent,PendingIntent.FLAG_CANCEL_CURRENT));
