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
    private Map<String, String> parametres;

    public RegisterRequest(String usuari, String nick, String correu, String clau, Response.Listener<String> listener){

        super(Method.POST, peticio_registre, listener, null);
        parametres = new HashMap<>();
        parametres.put("usuari",usuari);
        parametres.put("nick",nick);
        parametres.put("correu",correu);
        parametres.put("clau",clau);

    }

    public Map<String, String> getParametres() {
        return parametres;
    }
}
