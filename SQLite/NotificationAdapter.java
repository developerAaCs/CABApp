package aacs.com.np.cabapp.SQLite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aacs.com.np.cabapp.R;

/**
 * Created by Dell on 8/25/2017.
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    Context context;
    private List<Notification> notifications;
    private Notification notification;
    int currentPos=0;
    public NotificationAdapter(Context context, List<Notification> notifications){
        this.context=context;
        this.notifications=notifications;


    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemMessage;

        public ViewHolder(View itemView){
            super(itemView);
            itemImage= (ImageView) itemView.findViewById(R.id.item_image);
            itemTitle= (TextView) itemView.findViewById(R.id.item_title);
            itemMessage= (TextView) itemView.findViewById(R.id.item_message);

        }
    }

    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_row, parent, false);

        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.ViewHolder holder, int position) {
        int code=0;
        ViewHolder myHolder= holder;
        Notification current=notifications.get(position);
        myHolder.itemTitle.setText(current.getTitle());
        myHolder.itemMessage.setText(current.getBody());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }
}
