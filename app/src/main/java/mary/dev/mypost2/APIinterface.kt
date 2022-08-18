package mary.dev.mypost2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIinterface {
    @GET("/post")
    fun getPosts(): Call<List<Post>>
    @GET("POST/{postId}")
    fun getPostById(@Path("postId")postId: Int)


}