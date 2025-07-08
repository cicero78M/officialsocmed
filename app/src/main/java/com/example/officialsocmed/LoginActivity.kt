package com.example.officialsocmed

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val instagramLoginButton = findViewById<Button>(R.id.instagramLoginButton)
        instagramLoginButton.setOnClickListener {
            startInstagramLogin()
        }
    }

    private fun startInstagramLogin() {
        val clientId = "YOUR_INSTAGRAM_APP_CLIENT_ID"
        val redirectUri = "YOUR_REDIRECT_URI"
        val scope = "user_profile,user_media"
        val authUri = Uri.parse("https://api.instagram.com/oauth/authorize")
            .buildUpon()
            .appendQueryParameter("client_id", clientId)
            .appendQueryParameter("redirect_uri", redirectUri)
            .appendQueryParameter("scope", scope)
            .appendQueryParameter("response_type", "code")
            .build()

        val customTabsIntent = CustomTabsIntent.Builder().build()
        customTabsIntent.launchUrl(this, authUri)
    }
}
