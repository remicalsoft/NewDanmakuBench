package net.dixq.ryujinrokumobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.dixq.ryujinrokumobile.theme.MyApplicationTheme

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            val intent = Intent(this@MenuActivity, GameActivity::class.java)
                            startActivity(intent)
                        }) {
                            Text(text = "ベンチマーク開始")
                        }
                        Spacer(modifier = Modifier.height(16.dp)) // 16dpのスペースを追加
                        Button(onClick = { /* ランキングボタンの処理 */ }) {
                            Text("ランキング")
                        }
                    }
                }
            }
        }
    }
}