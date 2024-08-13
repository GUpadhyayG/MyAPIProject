package com.example.apiproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    ThirdActivity thirdActivity;
    List<UserModel> allUserList;

    public UserAdapter(ThirdActivity thirdActivity, List<UserModel> allUserList) {
        this.thirdActivity=thirdActivity;
        this.allUserList=allUserList;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(thirdActivity).inflate(R.layout.item_user,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.itemText.setText(allUserList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return allUserList.size();
    }

    class UserHolder extends RecyclerView.ViewHolder{
        TextView itemText;

        public UserHolder(@NonNull View itemView) {
            super(itemView);

            itemText=itemView.findViewById(R.id.itmText);
        }
    }
}
