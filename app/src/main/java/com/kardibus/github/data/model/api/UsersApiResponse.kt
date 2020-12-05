package com.example.githubapp.models

import com.google.gson.annotations.SerializedName

data class UsersApiResponse(val login:String,val id:Long,val node_id:String,val avatar_url:String,val gravatar_id:String,val url:String,
                     val html_url:String,val followers_url:String,val following_url:String,val gists_url:String,
                     val starred_url:String,val subscriptions_url:String,val organizations_url:String,
                     val repos_url:String,val events_url:String,val received_events_url:String,val type:String,
                     val site_admin:Boolean) {
}
class ResultUsers(val total_count:Long,val incomplete_results:Boolean,
             @SerializedName("items") val items:ArrayList<UsersApiResponse>?=null)