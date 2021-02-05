package com.example.myappchecker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppInfoAdapter extends RecyclerView.Adapter<AppInfoAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<AppInfo> appInfos;

    AppInfoAdapter(Context context, List<AppInfo> appInfo) {
        this.appInfos = appInfo;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public AppInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppInfoAdapter.ViewHolder holder, int position) {
        AppInfo appInfo = appInfos.get(position);
        holder.textViewAppName.setText(appInfo.applicationLabel);
        holder.textViewHash.setText(appInfo.hash_file);
    }

    @Override
    public int getItemCount() {
        return appInfos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewAppName, textViewHash;
        ViewHolder(View view){
            super(view);
            textViewHash = (TextView) view.findViewById(R.id.textViewHash);
            textViewAppName = (TextView) view.findViewById(R.id.textViewAppName);
        }
    }
}