package com.nca.testandroid.hw6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nca.testandroid.R;
import com.nca.testandroid.classwork6.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PeopleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<People> itemList = new ArrayList<>();
    private List<People> itemOriginalList = new ArrayList<>();
    private List<People> itemListFiltred = new ArrayList<>();
    private OnUserClickListener listener;

    public void setListener(OnUserClickListener listener) {
        this.listener = listener;

    }

    public void setPeopleList(List<People> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        if (itemOriginalList.size() == 0) {
            itemOriginalList.addAll(itemList);
        }
        // метод заставлят перерисовать элементы
        notifyDataSetChanged();
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        itemListFiltred = new ArrayList<>();
        if (charText.length() == 0) {
            itemListFiltred.addAll(itemOriginalList);
        } else {
            for (People item : itemOriginalList) {
                if (item.getName().toLowerCase(Locale.getDefault()).contains(charText) || item.getSurname().toLowerCase(Locale.getDefault()).contains(charText)) {
                    itemListFiltred.add(item);
                }
            }
        }
        setPeopleList(itemListFiltred);
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
        final People people = itemList.get(position);

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onClick(people, position);
                }
            }
        });

        //holder1.imageView.set //FIXME impliment Glide
        if (people.isDegree()) {
            myHolder.imageView.setImageResource(R.drawable.sova_anmation_1);
        } else {
            myHolder.imageView.setImageResource(R.drawable.sova_anmation_3);
        }

        myHolder.nameTextView.setText(people.getName());
        myHolder.surnameTextView.setText(people.getSurname());
        myHolder.ageTextView.setText(people.getAge().toString());
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
        TextView ageTextView;

        public Holder(View itemView) {
            super(itemView);
            Log.e("UserAdapter", "Holder");
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            surnameTextView = itemView.findViewById(R.id.surnameTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e("El", "onClick");
//                }
//            });
        }
    }
    interface OnUserClickListener {
         void onClick(People people, int position);
    }
}
