package aacs.com.np.cabapp.RealTimeData;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import aacs.com.np.cabapp.R;

/**
 * Created by Dell on 1/4/2018.
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    Context context;
    private List<MyDataSet> notifications;
    private MyDataSet dataset;

    public NotificationAdapter(Context context, List<MyDataSet> notifications){
        this.context=context;
        this.notifications= notifications;
    }

    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_row,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder myHolder = holder;
        MyDataSet current= notifications.get(position);
        myHolder.itemTitle.setText(current.getTitle());
        myHolder.itemMessage.setText(current.getMessage());
        myHolder.itemDate.setText(current.getDate());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView itemTitle;
        public TextView itemMessage;
        public TextView itemDate;
        public ImageView itemImage;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage= (ImageView) itemView.findViewById(R.id.item_image);
            itemTitle= (TextView) itemView.findViewById(R.id.item_title);
            itemMessage= (TextView) itemView.findViewById(R.id.item_message);
            itemDate= (TextView) itemView.findViewById(R.id.item_date);

        }
    }




}
