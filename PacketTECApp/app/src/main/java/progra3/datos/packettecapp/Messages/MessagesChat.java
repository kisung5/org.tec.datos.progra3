package progra3.datos.packettecapp.Messages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import progra3.datos.packettecapp.R;

public class MessagesChat extends AppCompatActivity{

    private RecyclerView rv;
    private List<TextMessage> textMessages;
    private MessagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        textMessages = new ArrayList<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        rv = (RecyclerView) findViewById(R.id.rvMessages);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

    for (int i=0;i<10;i++){
            TextMessage textMessageAux = new TextMessage();
            textMessageAux.setId("i");
            textMessageAux.setMessage("hola "+i);
            textMessageAux.setMessageType(1);
            textMessageAux.setTimeMessage("4:2"+i);
            textMessages.add(textMessageAux);
        }

        adapter = new MessagesAdapter(textMessages);
        rv.setAdapter(adapter);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
