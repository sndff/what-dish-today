package com.c22_067.whatdishtoday.network.responses

import com.google.gson.annotations.SerializedName

data class DetailRecipeResponse(

	@field:SerializedName("method")
	val method: String? = null,

	@field:SerializedName("results")
	val results: ResultsDetail? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class ResultsDetail(

	@field:SerializedName("difficulty")
	val difficulty: String? = null,

	@field:SerializedName("servings")
	val servings: String? = null,

	@field:SerializedName("times")
	val times: String? = null,

	@field:SerializedName("ingredient")
	val ingredient: List<String?>? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("step")
	val step: List<String?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("needItem")
	val needItem: List<NeedItemItem?>? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)

data class NeedItemItem(

	@field:SerializedName("thumb_item")
	val thumbItem: String? = null,

	@field:SerializedName("item_name")
	val itemName: String? = null
)

data class Author(

	@field:SerializedName("datePublished")
	val datePublished: String? = null,

	@field:SerializedName("user")
	val user: String? = null
)
