package com.example.pianko

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.pianko.ui.theme.PiankoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContent {
            PiankoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val context= LocalContext.current
                    Row(modifier = Modifier.fillMaxSize()
                        .padding(innerPadding), horizontalArrangement = Arrangement.Center) {
                        WhitePianoButton("C", mediaPlayer = MediaPlayer.create(context, R.raw.c_note))
                        WhitePianoButton("D", mediaPlayer = MediaPlayer.create(context, R.raw.d_note))
                        WhitePianoButton("E", mediaPlayer = MediaPlayer.create(context, R.raw.e_note))
                        WhitePianoButton("F", mediaPlayer = MediaPlayer.create(context, R.raw.f_note))
                        WhitePianoButton("G", mediaPlayer = MediaPlayer.create(context, R.raw.g_note))
                        WhitePianoButton("A", mediaPlayer = MediaPlayer.create(context, R.raw.a_note))
                        WhitePianoButton("B", mediaPlayer = MediaPlayer.create(context, R.raw.b_note))
                    }
                    Row(modifier = Modifier.fillMaxSize()
                        .padding(innerPadding), horizontalArrangement = Arrangement.Center) {
                        BlackPianoButton(mediaPlayer = MediaPlayer.create(context, R.raw.cm_note))
                        BlackPianoButton(mediaPlayer = MediaPlayer.create(context, R.raw.dm_note))
                        Spacer(modifier = Modifier.width(100.dp))
                        BlackPianoButton(mediaPlayer = MediaPlayer.create(context, R.raw.fm_note))
                        BlackPianoButton(mediaPlayer = MediaPlayer.create(context, R.raw.gm_note))
                        BlackPianoButton(mediaPlayer = MediaPlayer.create(context, R.raw.am_note))
                    }
                }
            }
        }
    }
}
@Composable
fun WhitePianoButton (noteName: String, mediaPlayer:MediaPlayer){
    var play by remember { mutableStateOf(false) }
    Box(modifier = Modifier.background(color = Color(243, 237, 255))
        .zIndex(1f)
        .border(3.dp, color = Color(69, 14, 42))
        .clickable(onClick = {
            play = !play
        })
        .width(100.dp)
        .fillMaxHeight()
        , contentAlignment = Alignment.BottomCenter
    )
    { Text(text= noteName, modifier= Modifier.padding(16.dp), fontSize = 20.sp,
        color= Color(69, 14, 42)) }

    LaunchedEffect(play) {
//        if(!mediaPlayer.isPlaying){
//            mediaPlayer.start()
//        }
        mediaPlayer.start()
    }

}

@Composable
fun BlackPianoButton (mediaPlayer:MediaPlayer) {
    var play by remember { mutableStateOf(false) }
    Box(modifier = Modifier
            .width(100.dp)
            .fillMaxHeight()
            .padding( end = 25.dp, start = 25.dp, bottom = 130.dp)
            .zIndex(2f)
            .border(3.dp, color = Color.Black)
            .background(color = Color(69, 14, 42))
            .clickable(onClick = {
                 play = !play
            })
    ){
        LaunchedEffect(play) {
//            if(!mediaPlayer.isPlaying){
//                mediaPlayer.start()
//            }
            mediaPlayer.start()
        }
    }

}

