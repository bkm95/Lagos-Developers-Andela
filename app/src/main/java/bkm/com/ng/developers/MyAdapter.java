package bkm.com.ng.developers;



import android.content.Context;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lenovo on 9/8/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    // THESE MUST BE INITIALIZWD  to different things AND MARKED AS FINAL
   // i guess thats why the guy said we must use packagename and shit in mohammed android tutorial "Intents"
    public static final String username = "a";
    public static final String address = "b";
    public static final String profilePic = "c";

    private List<DevelopersList> listItems;
    private Context context;

    public MyAdapter(List<DevelopersList> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_developers, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       final DevelopersList listItem = listItems.get(position);

        holder.textViewName.setText(listItem.getName());
        holder.textViewDesc.setText(listItem.getDesc());

        Picasso.with(context)
                .load(listItem.getImageUrl())
                .into(holder.imageView);



        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ProfileActivity.class);

                intent.putExtra(username, listItem.getName());
                intent.putExtra(address, listItem.getDesc());
                intent.putExtra(profilePic, listItem.getImageUrl());

                context.startActivity(intent);



                //Intent intent = new Intent(getContext(), ProfileActivity.class);
                //startActivity(intent);
                //m.toActivity();
                Toast.makeText(context, "You clicked " + listItem.getName() , Toast.LENGTH_LONG).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
        public TextView textViewDesc;
        public ImageView imageView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.name);
            textViewDesc = (TextView) itemView.findViewById(R.id.desc);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }

    }



}

