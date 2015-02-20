package net.sikuani.cappacitate;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    // Tutorial Instalar Genymotion:
    // http://tleyden.github.io/blog/2013/11/22/android-studio-plus-genymotion-emulator/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast mensaje =
        Toast.makeText(this, "Pasó por onCreate()", Toast.LENGTH_SHORT).show();

        //mensaje.show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Pasó por onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Pasó por onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Pasó por onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Pasó por onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Pasó por onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Pasó por onDestroy()", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public void clickEnBoton(View view){
        String msj;
        msj = getResources().getString(R.string.msj);
        switch (view.getId()){
            case R.id.primero:
                msj += "1";
                break;
            case R.id.segundo:
                msj += "2";
                break;
            case R.id.tercero:
                msj += "3";
                break;
        }
        Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();;
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
}
