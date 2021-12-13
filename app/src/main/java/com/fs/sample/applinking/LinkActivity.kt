package com.fs.sample.applinking

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fs.sample.applinking.ui.theme.AppLinkingSampleTheme
import com.huawei.agconnect.applinking.AGConnectAppLinking

class LinkActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AGConnectAppLinking.getInstance().getAppLinking(this).addOnSuccessListener {
            //manage the deeplink
            Log.d(TAG, "deeplink: ${it.deepLink}")
        }

        setContent {
            AppLinkingSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Red) {
                    LinkComposable("AppLinking")
                }
            }
        }
    }

    companion object {
        private const val TAG = "AppLinkingSample"
    }
}

@Composable
fun LinkComposable(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(16.dp),
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }
}