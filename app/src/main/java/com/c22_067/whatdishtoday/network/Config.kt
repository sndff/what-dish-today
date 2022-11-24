package com.c22_067.whatdishtoday.network

object Config {
    var BASEURL = "https://masak-apa-tomorisakura.vercel.app"
    var PAGE = "/api/recipes/{page}"
    var CATEGORIES = "/api/category/recipes"
    var LIST_CATEGORIES = "/api/category/recipes/{key}"
    var DETAIL_RECIPES = "/api/recipe/{key}"
    var SEARCH_RECIPES = "/api/search/?q={query}"
}