package dida.chapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 20/04/16.
 */
public class LoginRequest extends StringRequest{

    private static final String peticio_login = "http://chapp.comxa.com/entrar.php";
    private Map<String, String> parametres;

    public LoginRequest(String usuari, String clau, Response.Listener<String> listener){

        super(Request.Method.POST, peticio_login, listener, null);
        parametres = new HashMap<>();
        parametres.put("usuari",usuari);
        parametres.put("clau",clau);

    }

    public Map<String, String> getParametres() {
        return parametres;
    }

}
