package progra3.datos.packettecapp.Messages;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import progra3.datos.packettecapp.R;

/**
 * Created by deiber on 11/28/17.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>{

    private List<TextMessage> textMessages;

    public MessagesAdapter(List<TextMessage> textMessages) {
        this.textMessages = textMessages;
    }

    @Override
    public MessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_messages, parent, false);
        return new MessagesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MessagesViewHolder holder, int position) {
        RelativeLayout.LayoutParams rl = (RelativeLayout.LayoutParams) holder.cardView.getLayoutParams();
        FrameLayout.LayoutParams fl = (FrameLayout.LayoutParams) holder.MessageBG.getLayoutParams();
        //LinearLayout.LayoutParams llMessage = (LinearLayout.LayoutParams) holder.TvMessage.getLayoutParams(); //parametro a utilizar para mover texto
        LinearLayout.LayoutParams llTime = (LinearLayout.LayoutParams) holder.TvTime.getLayoutParams();

        if (textMessages.get(position).getMessageType()==1){ //EMISOR
            holder.MessageBG.setBackgroundResource(R.drawable.in_message_bg);//cambio de color y direccion de nube de mensaje
            rl.addRule(RelativeLayout.ALIGN_PARENT_LEFT,0);
            rl.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            //llMessage.gravity = Gravity.RIGHT;        //Para mover texto
            llTime.gravity = Gravity.RIGHT;
            fl.gravity = Gravity.RIGHT;
        } else if (textMessages.get(position).getMessageType()==2) { //RECEPTOR
            holder.MessageBG.setBackgroundResource(R.drawable.out_message_bg);//cambio de color y direccion de nube de mensaje
            rl.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,0);
            rl.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            llTime.gravity = Gravity.RIGHT;
            fl.gravity = Gravity.LEFT;
        }

        holder.cardView.setLayoutParams(rl);
        holder.MessageBG.setLayoutParams(fl);
        //holder.TvMessage.setLayoutParams(llMessage); //Para activar movimiento de texto
        holder.TvTime.setLayoutParams(llTime);
        holder.TvMessage.setText(textMessages.get(position).getMessage());
        holder.TvTime.setText(textMessages.get(position).getTimeMessage());
    }

    @Override
    public int getItemCount() {
        return textMessages.size();
    }

    static class MessagesViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        LinearLayout MessageBG;
        TextView TvMessage;
        TextView TvTime;

        MessagesViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.CVMessage);
            MessageBG = (LinearLayout) itemView.findViewById(R.id.messageBG);
            TvMessage = (TextView) itemView.findViewById(R.id.MSText);
            TvTime = (TextView) itemView.findViewById(R.id.MSTime);
        }
    }
}
