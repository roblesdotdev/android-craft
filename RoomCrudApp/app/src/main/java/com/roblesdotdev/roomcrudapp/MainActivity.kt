package com.roblesdotdev.roomcrudapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.roblesdotdev.roomcrudapp.ui.theme.RoomCrudAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomCrudAppTheme {
                Text(text = "Hello, World!")
            }
        }
    }
}
