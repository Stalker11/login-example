package com.example.loginapp.ui.models

import android.os.Parcel
import android.os.Parcelable

data class UserModel(
    val userId: Int,
    val userEmail: String?,
    val firstName: String?,
    val secondName: String?,
    val userAvatar: String?,
    val supportUrl: String?,
    val supportDescription: String?,
    val totalPages:Int
): Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(userId)
        writeString(userEmail)
        writeString(firstName)
        writeString(secondName)
        writeString(userAvatar)
        writeString(supportUrl)
        writeString(supportDescription)
        writeInt(totalPages)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<UserModel> =
            object : Parcelable.Creator<UserModel> {
                override fun createFromParcel(parcel: Parcel): UserModel {
                    return UserModel(parcel)
                }

                override fun newArray(size: Int): Array<UserModel?> {
                    return arrayOfNulls(size)
                }
            }
    }
}
