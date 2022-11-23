package com.c22_067.whatdishtoday.network.responses

import com.google.gson.annotations.SerializedName

data class RecipesResponse(
	@field:SerializedName("method")
	val method: String? = null,

	@field:SerializedName("results")
	val results: List<ResultsRecipesItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class ResultsRecipesItem(

	@field:SerializedName("difficulty")
	val difficulty: String? = null,

	@field:SerializedName("times")
	val times: String? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("serving")
	val serving: String? = null
)
