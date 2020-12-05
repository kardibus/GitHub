package com.kardibus.github.ui.users

import android.os.Parcel
import android.os.Parcelable

class UsersDataItem(
        val login: String?,
        val imageUrl: String?,
        val title: String?,
        val total_count: String?,
        val content: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeString(imageUrl)
        parcel.writeString(title)
        parcel.writeString(total_count)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsersDataItem> {
        override fun createFromParcel(parcel: Parcel): UsersDataItem {
            return UsersDataItem(parcel)
        }

        override fun newArray(size: Int): Array<UsersDataItem?> {
            return arrayOfNulls(size)
        }
    }
}