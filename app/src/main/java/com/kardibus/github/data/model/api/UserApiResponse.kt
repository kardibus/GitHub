package com.example.githubapp.models

import java.util.*

data class UserApiResponse(val login:String,val id:String,val node_id:String,val avatar_url:String,val gravatar_id:String,
                      val url:String,val html_url:String,val followers_url:String,val following_url:String,val gists_url:String,val starred_url:String,
                      val subscriptions_url:String,val organizations_url:String,val repos_url:String,val events_url:String,val received_events_url:String,val type:String,
                      val site_admin:String,val name:String,val company:String,val blog:String,val location:String,val email:String,val hireable:String,val bio:String,
                      val public_repos:String,val public_gists:String,val followers:String,val following:String,val created_at:Date,val updated_at:Date) {
}