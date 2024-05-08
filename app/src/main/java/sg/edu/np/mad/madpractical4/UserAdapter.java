package sg.edu.np.mad.madpractical4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> list_objects;
    // private ListActivity activity;
    public UserAdapter(ArrayList<User> list_objects, ListActivity activity){
        this.list_objects = list_objects;
        //this.activity = activity;
    }
    //Method to create a view holder for a username
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }

    // Method to bind username to a viewholder
    public void onBindViewHolder(UserViewHolder holder, int position){
        // get position of a username
        User list_items = list_objects.get(position);
        // set username to the view hodler based on custom_activity_list.xml
        holder.name.setText(list_items.getName());
        //set description to the view holder based on custom_activity_list.xml
        // configure SetOnClickListener for the the small image on the view holder based on custom_activity_list.xml
        holder.smallImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
    }

    public int getItemCount(){return list_objects.size();}
}