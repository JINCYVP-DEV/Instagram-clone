package com.nj.instagramclone.navigation

import android.graphics.drawable.Icon
import com.nj.instagramclone.R

sealed class BottomNavScreens(val title: String,val icon:Int,val route : String) {
    object Home:BottomNavScreens(title = BottomNavRoutes.HOME.route, icon = R.drawable.home,route=BottomNavRoutes.HOME.route )
    object Search:BottomNavScreens(title = BottomNavRoutes.SEARCH.route, icon = R.drawable.search,route=BottomNavRoutes.SEARCH.route )
    object Add:BottomNavScreens(title = BottomNavRoutes.ADD.route, icon = R.drawable.add,route=BottomNavRoutes.ADD.route )
    object Reels:BottomNavScreens(title = BottomNavRoutes.REELS.route, icon = R.drawable.reels,route=BottomNavRoutes.REELS.route )
    object Profile:BottomNavScreens(title = BottomNavRoutes.PROFILE.route, icon = R.drawable.home,route=BottomNavRoutes.PROFILE.route )
}
enum class BottomNavRoutes(val route: String)
{
    HOME("home"),
    SEARCH("search"),
    ADD("add"),
    REELS("reels"),
    PROFILE("profile")
}