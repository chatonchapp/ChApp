package dida.chapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText regUsuari = (EditText) findViewById(R.id.regUsuari);
        final EditText regNick = (EditText) findViewById(R.id.regNick);
        final EditText regCorreu = (EditText) findViewById(R.id.regCorreu);
        final EditText regClau = (EditText) findViewById(R.id.regClau);
        final Button bRegistrar = (Button) findViewById(R.id.bRegistrar);

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usuari = regUsuari.getText().toString();
                final String nick = regNick.getText().toString();
                final String correu = regCorreu.getText().toString();
                final String clau = regClau.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            //si el registre es correcte, anem a la pàgina Login, sino mostrem un missatge d'error.
                            if(success){

                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);

                            }else{

                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("El registro ha fallado")
                                        .setNegativeButton("Volver a intentar", null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest peticioRegistre = new RegisterRequest(usuari,nick,correu,clau,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(peticioRegistre);

            }
        });

    }
}
