package org.iesch.a07_recyclerview_rock.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.iesch.a07_recyclerview_rock.R
import org.iesch.a07_recyclerview_rock.databinding.ItemAlbumBinding
import org.iesch.a07_recyclerview_rock.model.Album

// 4 Modificamos el ViewHolder
class AlbumViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemAlbumBinding.bind(view)

    fun render(albumModel: Album){
        binding.tvTitulo.text = albumModel.titulo
        binding.tvAnio.text = albumModel.anio.toString()
        binding.tvAutor.text = albumModel.autor

        Glide.with(binding.imgAlbum.context).load(albumModel.portada).into(binding.imgAlbum)
//        binding.imgAlbum.setOnClickListener {
//            Toast.makeText(binding.imgAlbum.context, albumModel.autor, Toast.LENGTH_SHORT).show()
//            Toast.makeText(binding.imgAlbum.context, albumModel.titulo, Toast.LENGTH_SHORT).show()
//        }
    }
}