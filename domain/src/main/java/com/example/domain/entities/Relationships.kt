package com.example.domain.entities

data class Relationships(
    val castings: Castings?=null,
    val categories: Categories?=null,
    val chapters: Chapters?=null,
    val characters: Characters?=null,
    val genres: Genres?=null,
    val installments: Installments?=null,
    val mangaCharacters: MangaCharacters?=null,
    val mangaStaff: MangaStaff?=null,
    val mappings: Mappings?=null,
    val mediaRelationships: MediaRelationships?=null,
    val productions: Productions?=null,
    val quotes: Quotes?=null,
    val reviews: Reviews?=null,
    val staff: Staff?=null
)