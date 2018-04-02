package com.nca.presentation.base;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nca.testandroid.classwork8.PublishContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

public abstract class BaseAdapter<Model, ViewModel extends BaseItemViewModel<Model>> extends RecyclerView.Adapter<BaseItemViewHolder<Model, ViewModel, ?>> {

    private List<Model> items = new ArrayList<>();
    private PublishSubject<ItemEntity> clickSubject = PublishSubject.create();
    protected boolean isClicable = false;

    public void setItems(List<Model> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();

    }

    public PublishSubject<ItemEntity> observeClick() {
        return clickSubject;
    }

    @Override
    public void onBindViewHolder(BaseItemViewHolder<Model, ViewModel, ?> holder, int position) {
        Model item = items.get(position);
        holder.bindTo(item, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    @Override
    public void onViewAttachedToWindow(final BaseItemViewHolder<Model, ViewModel, ?> holder) {
        super.onViewAttachedToWindow(holder);

        if(isClicable) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    clickSubject.onNext(new ItemEntity(items.get(position), position));
                }
            });
        }
    }

    @Override
    public void onViewDetachedFromWindow(BaseItemViewHolder<Model, ViewModel, ?> holder) {
        super.onViewDetachedFromWindow(holder);
        if(isClicable) {
            holder.itemView.setOnClickListener(null);
        }
    }

    public static class ItemEntity<Model> {

        public Model model;
        public int position;

        public ItemEntity(Model model, int position) {
            this.model = model;
            this.position = position;
        }
    }
}
