package com.example.domain.entities

data class PosterImage(
    val large: String?=null,
    val medium: String?=null,
    val meta: MetaX?=null,
    val original: String?=null,
    val small: String?=null,
    val tiny: String?=null
)