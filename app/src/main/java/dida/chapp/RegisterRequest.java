package dida.chapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 19/04/16.
 */
public class RegisterRequest extends StringRequest {

    private static final String peticio_registre = "http://chapp.comxa.com/registre.php";
    private Map<String, String> params;

    public RegisterRequest(String usuari, String nick, String correu, String clau, Response.Listener<String> listener){

        super(Method.POST, peticio_registre, listener, null);
        params = new HashMap<>();
        params.put("usuari",usuari);
        params.put("nick",nick);
        params.put("correu",correu);
        params.put("clau",clau);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
