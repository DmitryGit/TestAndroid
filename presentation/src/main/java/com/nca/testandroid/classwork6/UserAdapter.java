package com.nca.testandroid.classwork6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.nca.testandroid.R;
import com.nca.testandroid.classwork1.Classwork1Activity;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> itemList = new ArrayList<>();
    private OnUserClickListener listener;

    public void setListener(OnUserClickListener listener) {
        this.listener = listener;

    }

    public void setUserList(List<User> userList) {
        this.itemList.clear();
        this.itemList.addAll(userList);
        // метод заставлят перерисовать элементы
        notifyDataSetChanged();
    }

    // зоздает холдер который содержит layout - xml, н кешируетс, т.е. для разных позиций может использоваться один и тот же холдер
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new Holder(view);
    }

    // вызывается для каждого эелемента, используется для заполнения данных item - один элемент
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        Holder myHolder = (Holder)holder;
        final User user = itemList.get(position);

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onClick(user, position);
                }
            }
        });

        //holder1.imageView.set //FIXME impliment Glide
        myHolder.nameTextView.setText(user.getName());
        myHolder.surnameTextView.setText(user.getSurname());
    }

    // возвращет размер
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // технический клас для хранаения item и ссылок на элменты
    private static class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameTextView;
        TextView surnameTextView;

        public Holder(View itemView) {
            super(itemView);
            Log.e("UserAdapter", "Holder");
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            surnameTextView = itemView.findViewById(R.id.surnameTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("El", "onClick");
                }
            });
        }
    }
    interface OnUserClickListener {
         void onClick(User user, int position);
    }
}
