package ikigaiworks.feedrss.api.requesthandler

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

import ikigaiworks.feedrss.api.callback.ApiCallback
import ikigaiworks.feedrss.api.wrapper.DataWrapper
import ikigaiworks.feedrss.utils.ApiErrorHandler
import retrofit2.Call
import retrofit2.Response

abstract class GenericRequestHandler<R> {
    protected abstract fun makeRequest(): Call<R>
    fun doRequest(): LiveData<DataWrapper<R>> {
        val liveData = MutableLiveData<DataWrapper<R>>()
        val dataWrapper = DataWrapper<R>()
        makeRequest().enqueue(object : ApiCallback<R>() {
            override fun handleResponseData(data: R?) {
                dataWrapper.data = data
                liveData.setValue(dataWrapper)
            }

            override fun handleError(response: retrofit2.Response<R>) {
                dataWrapper.apiException = ApiErrorHandler.getErrorData(response)
                liveData.setValue(dataWrapper)
            }

            override fun handleException(t: Exception) {
                dataWrapper.apiException = t
                liveData.setValue(dataWrapper)
            }
        })
        return liveData
    }
}