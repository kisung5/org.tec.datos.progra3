package progra3.datos.packettecapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText ETUser;
    private EditText ETPassword;
    private Button BTLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Texto ingresado
        ETUser = (EditText) findViewById(R.id.ETUser);
        ETPassword = (EditText) findViewById(R.id.ETPassword);

        //Boton de ingreso
        BTLogIn = (Button) findViewById(R.id.BTLogIn);

        BTLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this, "Log in...", Toast.LENGTH_SHORT).show();    //Flag con texto
                VerifyData(ETUser.getText().toString().toLowerCase(), ETPassword.getText().toString().toLowerCase());
            }
        });
    }

    public void VerifyData(String user, String password){
        Toast.makeText(this, "El usuario es: " + user + " y la contraseña es: " + password, Toast.LENGTH_SHORT).show();
    }


}
