package dida.chapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText regUsuari = (EditText) findViewById(R.id.regUsuari);
        final EditText regClau = (EditText) findViewById(R.id.regClau);
        final Button bLogin = (Button) findViewById(R.id.bEntrar);
        final TextView linkRegistre = (TextView) findViewById(R.id.crearUsuari);

        linkRegistre.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent intentRegistre = new Intent (LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intentRegistre);

            }

        });

        bLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                final String usuari = regUsuari.getText().toString();
                final String clau = regClau.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response){

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                String usuari = jsonResponse.getString("usuari");
                                String nick = jsonResponse.getString("nick");
                                Intent intent = new Intent (LoginActivity.this, UserAreaActivity.class);
                                intent.putExtra("usuari",usuari);
                                intent.putExtra("nick",nick);

                                LoginActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("El inicio de sesión ha fallado")
                                        .setNegativeButton("Volver a intentar", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };

                LoginRequest loginRequest = new LoginRequest(usuari,clau,responseListener);

            }

        });

    }
}
