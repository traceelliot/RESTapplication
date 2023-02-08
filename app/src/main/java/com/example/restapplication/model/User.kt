package com.example.restapplication.model

import kotlinx.serialization.Serializable


@Serializable
data class User(
     val id: Int,
     val name: String,
     val email: String,
     val gender: String,
     val status: String
)
