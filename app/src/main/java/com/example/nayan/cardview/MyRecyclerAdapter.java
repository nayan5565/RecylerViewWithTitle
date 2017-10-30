package com.example.nayan.cardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nayan on 10/30/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    //Header header;
    List<ListItem> list;

    public MyRecyclerAdapter(List<ListItem> headerItems) {
        this.list = headerItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            return new VHHeader(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
            return new VHItem(v);
        }
        // return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof VHHeader) {
            // VHHeader VHheader = (VHHeader)holder;
            Header currentItem = (Header) list.get(position);
            VHHeader VHheader = (VHHeader) holder;
            VHheader.txtTitle.setText(currentItem.getHeader());
        } else if (holder instanceof VHItem) {
            ContentItem currentItem = (ContentItem) list.get(position);
            VHItem VHitem = (VHItem) holder;
            VHitem.txtName.setText(currentItem.getName());
        }
    }

    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {

        return list.get(position) instanceof Header;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VHHeader extends RecyclerView.ViewHolder {
        TextView txtTitle;

        public VHHeader(View itemView) {
            super(itemView);
            this.txtTitle = (TextView) itemView.findViewById(R.id.txtHeader);
        }
    }

    class VHItem extends RecyclerView.ViewHolder {
        TextView txtName;

        public VHItem(View itemView) {
            super(itemView);
            this.txtName = (TextView) itemView.findViewById(R.id.txtName);
        }
    }
}
