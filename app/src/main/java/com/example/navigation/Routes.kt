package com.example.navigation

object Routes {
    const val Login = "login"
    const val Main = "main"
    const val Home = "home"
    const val History = "history"
    const val Profile = "profile"
    
    fun gameTopUp(gameName: String): String = "topup_game/$gameName"
    const val PulsaTopUp = "topup_pulsa"
}
