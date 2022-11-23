package com.c22_067.whatdishtoday.network.responses

import com.google.gson.annotations.SerializedName

data class SearchRecipeResponse(

	@field:SerializedName("method")
	val method: String? = null,

	@field:SerializedName("results")
	val results: List<ResultsSearchItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class ResultsSearchItem(

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
