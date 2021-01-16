package com.kardibus.github.ui.userdetails

import android.os.Parcel
import android.os.Parcelable

class UserDetailDataItem (
    val login: String?,
    val avatar_url: String?,
    val email:String?,
    val bio: String?,
    val public_repos:String?,
    val created_at:String?,
    val updated_at:String?,
    val public_gists:String?,
    val name:String?,
    val location:String?,
    val followers: String?,
    val following: String?):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeString(avatar_url)
        parcel.writeString(email)
        parcel.writeString(bio)
        parcel.writeString(public_repos)
        parcel.writeString(created_at)
        parcel.writeString(updated_at)
        parcel.writeString(public_gists)
        parcel.writeString(name)
        parcel.writeString(location)
        parcel.writeString(followers)
        parcel.writeString(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDetailDataItem> {
        override fun createFromParcel(parcel: Parcel): UserDetailDataItem {
            return UserDetailDataItem(parcel)
        }

        override fun newArray(size: Int): Array<UserDetailDataItem?> {
            return arrayOfNulls(size)
        }
    }
}