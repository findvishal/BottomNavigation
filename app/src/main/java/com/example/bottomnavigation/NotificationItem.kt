package com.example.bottomnavigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route: String, val label: String, val icons: ImageVector) {

    object Home : NavigationItem("Home", "Home", Icons.Default.Home)

    object MyContent : NavigationItem("My Content", "My Content", Icons.Default.Menu)

    object Doubts : NavigationItem("Doubts","Doubts",Icons.Default.ThumbUp)

    object Store: NavigationItem("Store","Store",Icons.Default.ShoppingCart)

}


