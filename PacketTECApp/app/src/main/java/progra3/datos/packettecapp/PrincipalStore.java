package progra3.datos.packettecapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import progra3.datos.packettecapp.Messages.MessagesChat;

public class PrincipalStore extends AppCompatActivity {

    private Button BTNewMessage;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        BTNewMessage = (Button) findViewById(R.id.BTNewMessage);

        BTNewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //Evento del boton "register"
                //Lamado a nueva actividad para proceder con la escritura de nuevo mensaje
                Intent w = new Intent(PrincipalStore.this, MessagesChat.class);
                startActivity(w);
            }
        });

    }
}
