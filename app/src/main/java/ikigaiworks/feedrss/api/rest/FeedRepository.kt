package ikigaiworks.recipepuppyapi.api.rest

class FeedRepository {

/*
    fun getRecipeList(observableLiveData: MutableLiveData<Response>,query: String): MutableLiveData<Response>{
        FeedService.getClient().getRecipeList(query).enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>?, t: Throwable?) {
                observableLiveData.value = null
            }

            override fun onResponse(call: Call<Response>?, response: retrofit2.Response<Response>?) {
                observableLiveData.value = response?.body()
            }
        })
        return observableLiveData
    }*/

    companion object {
        fun newInstance(): FeedRepository{
            return FeedRepository()
        }
    }
}