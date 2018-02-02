package com.example.busko.androidref;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Dialog11Activity extends AppCompatActivity {

    /**
     * A numeric value that identifies the notification that we'll be sending.
     * This value needs to be unique within this app, but it doesn't need to be
     * unique system-wide.
     */
    public static final int NOTIFICATION_ID = 1;

    Button dialogButton;

    TimePickDialog tpdf;
    DatePickDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog11);
        dialogButton = findViewById(R.id.buttonDialog);
    }

    public void showAlertDialogF(View v){
        AlertDialogFragment adf = new AlertDialogFragment();
        adf.show(getSupportFragmentManager(), "Adialog");
    }

    public void showTimePickDialogF(View v){
         tpdf = new TimePickDialog();
        tpdf.show(getSupportFragmentManager(), "TPdialog");
    }

    public void showDatePickDialog(View v){
        dpd = new DatePickDialog();
        dpd.show(getSupportFragmentManager(), "DPdialog");
    }

    Toast toast;

    public void showToast(View v){
        toast = Toast.makeText(this, "this is a toast", Toast.LENGTH_SHORT);
        toast.show();
    }

    //added to gradle compile 'com.android.support:design:26.1.0' don't accept another version as 26.0.0
    //added CoordinatorLayout into activiy_dialog11.xml
    public void showSnackbar(View v){
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.snackbarPosition),
                      "snackbar text: action-> show toast!", Snackbar.LENGTH_LONG);
        mySnackbar.setAction("action", clickListener);
        mySnackbar.show();
    }
    final View.OnClickListener clickListener = new View.OnClickListener() {
       public void onClick(View v) {
       showToast(v);
       showTimePickDialogF(v);
        }
    };


    public void sendNotification(View view) {

        // BEGIN_INCLUDE(build_action)
        /** Create an intent that will be fired when the user clicks the notification.
         * The intent needs to be packaged into a {@link android.app.PendingIntent} so that the
         * notification service can fire it on our behalf.
         */
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.android.com/reference/android/app/Notification.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        // END_INCLUDE(build_action)

        // BEGIN_INCLUDE (build_notification)
        /**
         * Use NotificationCompat.Builder to set up our notification(deprecated).
         NotificationCompat.Builder(Context, String) instead. All posted Notifications must specify a NotificationChannel Id.*/

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        /** Set the icon that will appear in the notification bar. This icon also appears
         * in the lower right hand corner of the notification itself.
         *
         * Important note: although you can use any drawable as the small icon, Android
         * design guidelines state that the icon should be simple and monochrome. Full-color
         * bitmaps or busy images don't render well on smaller screens and can end up
         * confusing the user.
         */
        builder.setSmallIcon(R.drawable.common_google_signin_btn_text_dark);

        // Set the intent that will fire when the user taps the notification.
        builder.setContentIntent(pendingIntent);

        // Set the notification to auto-cancel. This means that the notification will disappear
        // after the user taps it, rather than remaining until it's explicitly dismissed.
        builder.setAutoCancel(true);

        /**
         *Build the notification's appearance.
         * Set the large icon, which appears on the left of the notification. In this
         * sample we'll set the large icon to be the same as our app icon. The app icon is a
         * reasonable default if you don't have anything more compelling to use as an icon.
         */
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.common_full_open_on_phone));

        /**
         * Set the text of the notification. This sample sets the three most commononly used
         * text areas:
         * 1. The content title, which appears in large type at the top of the notification
         * 2. The content text, which appears in smaller text below the title
         * 3. The subtext, which appears under the text on newer devices. Devices running
         *    versions of Android prior to 4.2 will ignore this field, so don't use it for
         *    anything vital!
         */
        builder.setContentTitle("Simple Notifications");
        builder.setContentText("Time to learn about notifications!");
        builder.setSubText("Tap to view documentation about notifications.");

        // END_INCLUDE (build_notification)

        // BEGIN_INCLUDE(send_notification)
        /**
         * Send the notification. This will immediately display the notification icon in the
         * notification bar.
         */
 NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    notificationManager.notify(NOTIFICATION_ID, builder.build());
        // END_INCLUDE(send_notification)
    }


}
