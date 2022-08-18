package mary.dev.mypost2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mary.dev.mypost2.databinding.ActivityCommentBinding
import mary.dev.mypost2.databinding.PostListitemBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0
        fetchPost()
    }

    fun fetchPost() {
        var apiClient = APIClient.buildApiClient(APIinterface::class.java)
        var request = apiClient.getPostById(postId)

        request.enqueue(object : Callback<Post> {
            
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                var post = response.body()
                if (post!= null){
                    binding.tvPostBody.text = post.title
                    binding.tvPostTitle.text = post.body
                }

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }
        })
    }
}


private fun Any.enqueue(callback: Callback<Post>) {

}


