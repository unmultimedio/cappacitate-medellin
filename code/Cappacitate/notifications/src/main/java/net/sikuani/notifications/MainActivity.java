package net.sikuani.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doNotification(View view){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        String title = "";
        String content = "";
        String ticker = "";

        title = ((EditText)findViewById(R.id.text_title)).getText().toString();
        content = ((EditText)findViewById(R.id.text_content)).getText().toString();
        ticker = ((EditText)findViewById(R.id.text_ticker)).getText().toString();

        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setTicker(ticker);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentInfo("25!");

        Intent intent = new Intent(this, ResultsActivity.class);

        intent.putExtra("titleKey",title);
        intent.putExtra("contentKey",content);
        intent.putExtra("tickerKey",ticker);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                1,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        builder.setAutoCancel(true);

        Notification n = builder.build();

        nm.notify(1, n);

    }
}
