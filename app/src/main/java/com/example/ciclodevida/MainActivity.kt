package com.example.ciclodevida

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController

class MainActivity : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer
    var ban = false // con la bandera evito que empiece a reproducirse la cancion desde que inicia, sino que al momento de darle play lo haga
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("Activity", "Se creó la actividad")
        //En la carpeta raw se encuenta la canción de Res
        mediaPlayer = MediaPlayer.create(this, R.raw.moster_shawn)

    }

    override fun onStart() {
        super.onStart()
        //Dejar que mande llamar al onStart del padr ey despues hacer lo que queramos
        Log.e("Activity", "Se inició la actividad")
        if(ban)
            playCancion()
    }

    override fun onResume() {
        super.onResume()
        Log.e("Activity", "Se continuó la actividad")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Activity", "Se pausó la actividad")
        pauseCancion()
    }

    override fun onStop() {
        super.onStop()
        Log.e("Activity", "Se detuvo la actividad")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Activity", "Se reinició la actividad")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Activity", "Se destruyó la actividad")
    }

    fun playCancionClick(v: View){
        ban= true
    playCancion()

    }

    fun pauseCancionClick(v: View){
        pauseCancion()

    }
    fun playCancion(){
    mediaPlayer.start()

    }
    fun pauseCancion(){
    mediaPlayer.pause()

    }
}