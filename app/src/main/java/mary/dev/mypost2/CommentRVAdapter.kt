package mary.dev.mypost2

import mary.dev.mypost2.databinding.PostListitemBinding

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class CommentRvAdapter (var commentlist: List<Post>):
    RecyclerView.Adapter<CommentRvAdapter.CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder{
        var bindingView = PostListitemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentPost = commentlist.get(position)

        var context = holder.itemView.context
        holder.bindingView.cvPost.setOnClickListener {
            val  intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("COMMENT_ID", currentPost.id)
            context.startActivity(intent)
        }

        with(holder.bindingView){

            tvId.text = currentPost.userId.toString()
            tvBody.text = currentPost.body.toString()
            tvTitle.text = currentPost.id.toString()
            tvTitle.text=currentPost.title.toString()

        }

    }

    override fun getItemCount(): Int {
        return commentlist.size
    }


    class CommentViewHolder(var bindingView: PostListitemBinding):
        RecyclerView.ViewHolder(bindingView.root){

    }
}






