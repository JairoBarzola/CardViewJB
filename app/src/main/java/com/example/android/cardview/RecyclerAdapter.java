package com.example.android.cardview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.cardview.*;
import java.util.List;


/**
 * Created by Jair Barzola on 10-Jan-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    /*definimos un lastPosition siempre en un array el ultimo tiene -1*/
    List<User> users;
    Context context;
    static   int lastPosition=-1;
    public RecyclerAdapter (List<User> users,Context context){
        this.users= users;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*se pone en el onBind la animacion*/
        holder.title.setText(users.get(position).title);
        holder.twiter.setText(users.get(position).twitter);
        holder.image.setImageResource(users.get(position).photoID);
        setAnimation(holder.cardView,position);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title,twiter;
        public ImageView image;
        public CardView cardView;

    public ViewHolder(View itemView) {
        super(itemView);
        cardView =(CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);
        twiter = (TextView) itemView.findViewById(R.id.twiter);
        image= (ImageView) itemView.findViewById(R.id.image);
    }
}
    private void setAnimation(View viewToAnimate,int position){
        if(position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.left);
            viewToAnimate.startAnimation(animation);
            lastPosition=position;
        }

    }
}

