package progra3.datos.packettecapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    private EditText ETUser;
    private EditText ETPassword;
    private Button BTRegister;

    private RequestQueue mRequest;
    private VolleyRP Volley;

    private static String IP = "http://192.168.100.10:8082/algo";

    private String USER = "";
    private String PASSWORD = "";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Texto ingresado
        ETUser = (EditText) findViewById(R.id.ETUserRegister);
        ETPassword = (EditText) findViewById(R.id.ETPasswordRegister);

        //Boton de ingreso
        BTRegister = (Button) findViewById(R.id.BTRegister);

        BTRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //Evento del boton "Register"
                VerifyData(ETUser.getText().toString().toLowerCase(), ETPassword.getText().toString().toLowerCase());
            }
        });
    }

    public void VerifyData(String user, String password){
        USER = user;
        PASSWORD = password;
        //RequestJson(IP+user); cambia porque debe enviar informacion no recibir
    }




    /* Se debe:
    * Enviar informacion
    * Hacer que verifique si ya existe una cuenta con ese user en el servidor
    * Enviar error si ya existe (puede ser en un toast o un en texview), aceptar y enviar a la siguiente "actividad" si no existe
     */



    public void RequestJson(String url){ //buscar hacer llamado a enviar informacion
        JsonObjectRequest Request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject data) {
                VerifyRegister(data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(Request, mRequest, this, Volley);
    }
    public void VerifyRegister(JSONObject data){
        //Controlar el Json
        //el del video lo usa con formato: {"resultado":"CC","datos":{"id":"USER","Password":"PASSWORD"}}
        try {
            String state = "CC"; //String state = new data.getString("resultado");
            if (state.equals("CC")){
                JSONObject JsonData = new JSONObject(data.getString("datos"));
                String user = JsonData.getString("id");
                String password = JsonData.getString("Password");
                if (user.equals(USER) && password.equals(PASSWORD)) {
                    //Logueo correcto, llamado a nueva actividad
                    Intent i = new Intent(this, PrincipalStore.class);
                    startActivity(i);
                } else {
                    Toast.makeText(this,"La contraseña es incorrecta",Toast.LENGTH_SHORT).show();
                }
            } else {
                //el state seria el usuario no existe ya que diria {"resultado":"el usuario no existe"}
                Toast.makeText(this,state,Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}