package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()

                }
            }
        }
    }
}


@Composable
fun Home() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Home")


    }

}

@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        composable(NavigationItem.Home.route) {
            Home()
        }

        composable(NavigationItem.MyContent.route) {
            MyContent()
        }

        composable(NavigationItem.Doubts.route) {
            Doubts()
        }

        composable(NavigationItem.Store.route) {
           Store()
        }

    }


}


@Composable
fun Navigation() {

    val navController = rememberNavController()

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Doubts,
        NavigationItem.MyContent,
        NavigationItem.Store
    )


    Scaffold(topBar = { TopAppBar(title = { Text(text = "Bottom Navigation VIew") }) },
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.background) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                items.forEach {
                    BottomNavigationItem(selected = currentRoute == it.route,
                        label = {
                            Text(
                                text = it.label,
                                color = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = it.icons, contentDescription = null,
                                tint = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                            )

                        },

                        onClick = {
                            if(currentRoute!=it.route){

                                navController.graph?.startDestinationRoute?.let {
                                    navController.popBackStack(it,true)
                                }

                                navController.navigate(it.route){
                                    launchSingleTop = true
                                }

                            }

                        })

                }


            }


        }) {

        NavigationController(navController = navController)

    }

}

@Composable
fun MyContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "My Content")

        }
    }
}

@Composable
fun Doubts() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Doubts")

        }
    }
}

@Composable
fun Store() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Store")

        }
    }
}

