package ikigaiworks.feedrss.utils

import retrofit2.Response

class ApiErrorHandler {
    companion object {
        fun <R> getErrorData(response: Response<R>): Exception? {
            return Exception();
        }

        fun validationAPIException(error_code: Int): Exception? {
            return Exception();
        }


    }
}