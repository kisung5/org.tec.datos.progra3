package progra3.datos.packettecapp.Messages;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        holder.TvMessage.setText(textMessages.get(position).getMessage());
        holder.TvTime.setText(textMessages.get(position).getTimeMessage());
    }

    @Override
    public int getItemCount() {
        return textMessages.size();
    }

    static class MessagesViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView TvMessage;
        TextView TvTime;

        MessagesViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.CVMessage);
            TvMessage = (TextView) itemView.findViewById(R.id.MSText);
            TvTime = (TextView) itemView.findViewById(R.id.MSTime);
        }
    }
}
