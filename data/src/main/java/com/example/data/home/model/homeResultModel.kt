package com.example.data.home.model

data class HomeResultModel(
    var status: String? = "",
    var message: String? = "",
    var data: LogoResult? = null,
)

data class LogoResult(
    var logo: List<LogoItem>? = null,
    var layout: List<LayoutItem>? = null
)

data class LogoItem(
    var type: String? = "",
    var image: String? = "",
    var link: String? = ""
)

data class LayoutItem(
    var type: String? = "",
    var banner: List<BannerItem>? = null,
    var privilege: Privilege? = null,
    var title: String? = "",
    var dramas: List<DarmasItem>? = null,
)

data class BannerItem(
    var id: Int? = 0,
    var image: String? = "",
    var title: String? = "",
    var rating: Int? = 0,
    var year: String? = "",
    var rate: String? = "",
    var link: String? = "",
    var action: List<ActionItem>? = null,
)

data class ActionItem(
    var type: String? = "",
    var link: String? = ""
)

data class Privilege(
    var type: String? = "",
    var privilege: PrivilegeItem? = null,

)

data class PrivilegeItem(
    var title: String? = "",
    var sub_title: String? = "",
    var icons: List<IconsPrivilegeItem>? = null,
    var action: List<ActionPrivilegeItem>? = null
)

data class IconsPrivilegeItem(
    var icon: String? = "",
    var title: String? = "",
    var link: String? = ""
)

data class ActionPrivilegeItem(
    var type: String? = "",
    var title: String? = "",
    var link: String? = ""
)

data class DarmasItem(
    var id: Int? = 0,
    var image: String? = "",
    var title: String? = "",
    var new_episode: String? = ""
)