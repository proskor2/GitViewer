package dev.proskor.myapplication.data

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.proskor.myapplication.R
import dev.proskor.myapplication.databinding.RepositoryBinding
import dev.proskor.myapplication.models.GitRepository

class AdapterRepositories : RecyclerView.Adapter<AdapterRepositories.MyViewHolder>() {
    var listRepositories = mutableListOf<GitRepository>()

    fun setReposList(listRepos: List<GitRepository>) {
        this.listRepositories = listRepos.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepositoryBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRepositories.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameRep.text = listRepositories[position].name
        holder.languageRep.text = listRepositories[position].language
        holder.descriptionRep.text = listRepositories[position].description
    }


    class MyViewHolder(val binding: RepositoryBinding) : RecyclerView.ViewHolder(binding.root) {
        val nameRep = itemView.findViewById<TextView>(R.id.textView_name_reps)
        val languageRep = itemView.findViewById<TextView>(R.id.textview_type_reps)
        val descriptionRep = itemView.findViewById<TextView>(R.id.textView_descrpiton_reps)
    }
}