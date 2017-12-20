package arias.pablo.empezando.lay.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import arias.pablo.empezando.lay.R;
import arias.pablo.empezando.lay.models.Find;

/**
 * Created by Pablo Arias on 19/12/2017.
 */

public class FindsAdapter  extends RecyclerView.Adapter<FindsAdapter.ViewHolder>{




    private ArrayList<Find> datos;
    private Context context;

    public FindsAdapter(Context context) {
        datos = new ArrayList<Find>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_find, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Find p = datos.get(position);
        holder.nameTextView.setText(p.getName());
        Glide.with(context).load(p.getFlagURL()).into(holder.flagImageView);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void colocarDatos(ArrayList<Find> datos) {
        this.datos = datos;
        notifyDataSetChanged();
    }

    public void addFind(Find f) {
        datos.add(f);
        notifyDataSetChanged();
    }

    public void clear() {
        datos.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        ImageView flagImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            flagImageView = (ImageView) itemView.findViewById(R.id.flagImageView);
        }
    }
}
