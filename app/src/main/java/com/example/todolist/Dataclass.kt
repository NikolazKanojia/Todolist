package com.example.todolist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dataclass(var title:String,var descr:String):Parcelable{}

