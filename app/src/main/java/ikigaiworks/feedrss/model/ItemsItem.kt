package ikigaiworks.feedrss.model

data class ItemsItem(
        val thumbnail: String? = null,
        val enclosure: EnclosureItem? = null,
        val author: String? = null,
        val link: String? = null,
        val guid: String? = null,
        val description: String? = null,
        val categories: List<String?>? = null,
        val title: String? = null,
        val pubDate: String? = null,
        val content: String? = null
)
