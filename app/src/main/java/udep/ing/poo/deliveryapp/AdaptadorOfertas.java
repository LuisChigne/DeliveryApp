package udep.ing.poo.deliveryapp;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import udep.ing.poo.deliveryapp.ofertas.Oferta;
import udep.ing.poo.deliveryapp.utilidades.Utilidades;

public class AdaptadorOfertas extends RecyclerView.Adapter<AdaptadorOfertas.ViewHolderOfertas>
        implements View.OnClickListener {
    ArrayList<Oferta> listaOfertas;
    private View.OnClickListener listener;

    public AdaptadorOfertas(ArrayList<Oferta> listaOfertas){
        this.listaOfertas = listaOfertas;
    }



    @NonNull
    @Override
    public ViewHolderOfertas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        if(Utilidades.visualizacion == Utilidades.LIST){
            layout = R.layout.itemofertas;
        }else {
            layout = R.layout.item_grid_ofertas;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, null, false);

        view.setOnClickListener(this);

        return new ViewHolderOfertas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorOfertas.ViewHolderOfertas holder, int position) {
        holder.tvNombre.setText(listaOfertas.get(position).getNombre());
        if(Utilidades.visualizacion == Utilidades.LIST){
            holder.tvInformacion.setText(listaOfertas.get(position).getInfo());
        }
        holder.foto.setImageResource(listaOfertas.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaOfertas.size();
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public class ViewHolderOfertas extends RecyclerView.ViewHolder {
        TextView tvNombre,tvRestaurante, tvInformacion, tvPrecio;
        ImageView foto;

        public ViewHolderOfertas(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView)itemView.findViewById(R.id.idNombre);
            foto = (ImageView)itemView.findViewById(R.id.idImagen);

            if(Utilidades.visualizacion == Utilidades.LIST){
                tvRestaurante = (TextView)itemView.findViewById(R.id.idRestaurante);
                tvInformacion = (TextView)itemView.findViewById(R.id.idInfo);
                tvPrecio = (TextView)itemView.findViewById(R.id.idPrecio);
            }
        }
    }
    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }

    }
}
