package ikigaiworks.feedrss.api.observer

import android.arch.lifecycle.Observer

import ikigaiworks.feedrss.api.wrapper.DataWrapper
import ikigaiworks.feedrss.utils.ApiErrorHandler

open class ApiObserver<T>(val changeListener: ChangeListener<T>) : Observer<DataWrapper<T>> {

    override fun onChanged(tDataWrapper: DataWrapper<T>?) {
        if (tDataWrapper != null) {
            if (tDataWrapper.apiException != null) {
                changeListener.onException(tDataWrapper.apiException)
            } else {
                changeListener.onSuccess(tDataWrapper.data)
            }
            return
        }else {
            changeListener.onException(ApiErrorHandler.validationAPIException(ERROR_CODE))
        }
    }

    interface ChangeListener<T> {
        fun onSuccess(dataWrapper: T?)
        fun onException(exception: Exception?)
    }

    companion object {
        private val ERROR_CODE = -1
    }
}