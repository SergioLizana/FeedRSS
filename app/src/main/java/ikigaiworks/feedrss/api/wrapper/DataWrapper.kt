package ikigaiworks.feedrss.api.wrapper

class DataWrapper<T> {
     var apiException: Exception? = null
     var data: T? = null
}