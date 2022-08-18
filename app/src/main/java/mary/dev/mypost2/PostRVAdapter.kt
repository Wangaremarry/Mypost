package mary.dev.mypost2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mary.dev.mypost2.databinding.PostListitemBinding

class PostAdapter(var postlist:List<Post>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding =
            PostListitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = postlist.get(position)

        var context = holder.itemView.context
        holder.binding.cvPost.setOnClickListener {
            val  intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("POST_ID", currentPost.id)
            context.startActivity(intent)
        }

        with(holder.binding){

            tvUser.text = currentPost.userId.toString()
            tvId.text = currentPost.id.toString()
            tvTitle.text = currentPost.title
            tvBody.text = currentPost.body
        }

    }

    override fun getItemCount(): Int {
        return postlist.size
    }
}

    class PostViewHolder(var binding: PostListitemBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }
