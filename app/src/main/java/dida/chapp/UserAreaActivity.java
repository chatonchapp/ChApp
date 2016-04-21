package dida.chapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final EditText uiUsuari = (EditText) findViewById(R.id.uiUsuari);
        final EditText uiClau = (EditText) findViewById(R.id.uiNick);
        final TextView missatge = (TextView) findViewById(R.id.missatge);

        Intent intent = getIntent();
        String usuari = intent.getStringExtra("usuari");
        String nick = intent.getStringExtra("nick");

        String msg = "Buenos dias " + usuari + " alias: " + nick;
        missatge.setText(msg);
        uiUsuari.setText(usuari);
        uiClau.setText(nick);



    }

}
