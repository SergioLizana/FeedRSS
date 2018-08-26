package ikigaiworks.feedrss.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class FeedResponse(
        val feed: @RawValue FeedItem? = null,
        val items: @RawValue List<ItemsItem>? = null,
        val status: String? = null
): Parcelable
