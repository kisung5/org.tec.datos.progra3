package progra3.datos.packettecapp.Messages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import progra3.datos.packettecapp.R;

public class MessagesChat extends AppCompatActivity{

    private RecyclerView rv;
    private Button BTSendMessage;
    private EditText ETWriteMessage;
    private List<TextMessage> textMessages;
    private MessagesAdapter adapter;

    private int temp;///////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        textMessages = new ArrayList<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        BTSendMessage = (Button) findViewById(R.id.BTSend);
        ETWriteMessage = (EditText) findViewById(R.id.ETWrite);

        rv = (RecyclerView) findViewById(R.id.rvMessages);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setStackFromEnd(true);
        rv.setLayoutManager(lm);

        temp=1;/////////////////////////////////////////////////////////////////////////////////////////////
    for (int i=0;i<20;i++){
            TextMessage textMessageAux = new TextMessage();
            textMessageAux.setId("i");
            textMessageAux.setMessageType(temp);
            textMessageAux.setTimeMessage("4:2"+i);
            if (temp == 1){/////////////////////////////////////////////////////////////////////////////////
                textMessageAux.setMessage("emisor "+i);
                temp=2;
            } else if (temp == 2){
                textMessageAux.setMessage("receptor "+i);
                temp=1;
            }
            textMessages.add(textMessageAux);
        }

        adapter = new MessagesAdapter(textMessages);
        rv.setAdapter(adapter);

        BTSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = ETWriteMessage.getText().toString();
                if (!message.isEmpty()) {
                    CreateMessage(message);
                }
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setScrollbarChat();
    }

    public void CreateMessage(String text){
        TextMessage textMessageAux = new TextMessage();
        textMessageAux.setId("0");
        textMessageAux.setMessage(text);
        textMessageAux.setMessageType(1);
        textMessageAux.setTimeMessage("4:20");
        textMessages.add(textMessageAux);
        adapter.notifyDataSetChanged();
        ETWriteMessage.setText("");
        setScrollbarChat();
    }

    public void setScrollbarChat(){
        rv.scrollToPosition(adapter.getItemCount()-1);
    }

}
