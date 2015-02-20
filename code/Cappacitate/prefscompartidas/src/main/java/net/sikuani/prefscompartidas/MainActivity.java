package net.sikuani.prefscompartidas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getPreferences(MODE_PRIVATE);
        editor = prefs.edit();
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

    public void savePref(View view){

        switch (view.getId()){
            case R.id.btn_save_boolean:
                break;
            case R.id.btn_save_char:
                break;
            case R.id.btn_save_int:
                EditText campo = (EditText)findViewById(R.id.data_int);
                String campoStr = campo.getText().toString();
                if(campoStr != null && !campoStr.isEmpty()){
                    try {
                        int value = Integer.valueOf(campoStr);
                        editor.putInt("var_int", value);
                        Toast.makeText(this, "Int put", Toast.LENGTH_SHORT);
                    }catch (Exception e){
                        //No es un numero entero
                        Toast.makeText(this,"No es entero",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                //Alerta, método llamado desde otra vista diferente a los botones
        }

        editor.commit();
        Toast.makeText(this, "Commit", Toast.LENGTH_SHORT);

        refreshPrefs();

    }

    public void refreshPrefs(){
        TextView data_char, data_int, data_boolean;

        data_int = (TextView) findViewById(R.id.out_int);

        String val_int = String.valueOf(prefs.getInt("var_int",-1));

        data_int.setText(val_int);
    }

    public void clearPrefs(View view){
        editor.clear();
        //editor.remove("la_llave_que_quiero_limpar");
        editor.commit();
        refreshPrefs();
    }
}
