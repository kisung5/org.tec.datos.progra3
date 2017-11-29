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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<TextMessages> textMessages;

    public Adapter(List<TextMessages> textMessages) {
        this.textMessages = textMessages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_messages, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.TvMessage.setText(textMessages.get(position).getMessage());
        holder.TvTime.setText(textMessages.get(position).getTimeMessage());
    }

    @Override
    public int getItemCount() {
        return textMessages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView TvMessage;
        TextView TvTime;

        ViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.CVMessage);
            TvMessage = (TextView) itemView.findViewById(R.id.MSText);
            TvTime = (TextView) itemView.findViewById(R.id.MSTime);
        }
    }
}
