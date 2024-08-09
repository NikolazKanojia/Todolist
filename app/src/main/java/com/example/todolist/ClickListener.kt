package com.example.todolist

import android.icu.text.Transliterator.Position

interface ClickListener {
    fun delete(position: Int)
    fun edit(position: Int)
}