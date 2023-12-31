package com.musicplayer.nubt.Model1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.musicplayer.nubt.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DevelopersAdapter extends RecyclerView.Adapter<com.musicplayer.nubt.Model1.DevelopersAdapter.ViewHolder> {


    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    // we define a list from the DevelopersList java class

    private List<com.musicplayer.nubt.Model1.DevelopersList> developersLists;
    private Context context;

    public DevelopersAdapter(List<com.musicplayer.nubt.Model1.DevelopersList> developersLists, Context context) {

        // generate constructors to initialise the List and Context objects

        this.developersLists = developersLists;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method will be called whenever our ViewHolder is created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.developers_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        // this method will bind the data to the ViewHolder from whence it'll be shown to other Views

        final com.musicplayer.nubt.Model1.DevelopersList developersList = developersLists.get(position);
        holder.login.setText(developersList.getLogin());

        Picasso.get()
                .load(developersList.getAvatar_url())
                .into(holder.avatar_url);



       holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DevelopersList developersList1 = developersLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), ProfileActivity.class);
                skipIntent.putExtra(KEY_NAME, developersList1.getLogin());
                skipIntent.putExtra(KEY_URL, developersList1.getHtml_url());
                skipIntent.putExtra(KEY_IMAGE, developersList1.getAvatar_url());
                v.getContext().startActivity(skipIntent);
            }
        });

/*        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.musicplayer.nubt.Model1.DevelopersList developersList1 = developersLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), com.musicplayer.nubt.Model1.ProfileActivity.class);
                skipIntent.putExtra(KEY_NAME, developersList1.getLogin());
                skipIntent.putExtra(KEY_URL, developersList1.getHtml_url());
                skipIntent.putExtra(KEY_IMAGE, developersList1.getAvatar_url());
                v.getContext().startActivity(skipIntent);
            }
        });*/

    }

    @Override

    //return the size of the listItems (developersList)

    public int getItemCount() {
        return developersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        // define the View objects

        public TextView login;
        public ImageView avatar_url;
       // public TextView html_url;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            // initialize the View objects

            login = (TextView) itemView.findViewById(R.id.username);
            avatar_url = (ImageView) itemView.findViewById(R.id.imageView);
           // html_url = (TextView) itemView.findViewById(R.id.htmUrl);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }

    }
}
