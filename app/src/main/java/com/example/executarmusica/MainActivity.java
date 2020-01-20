package com.example.executarmusica;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button botao;
    private MediaPlayer mediaplayer1;

    //padronizando botao para ver a codificacao
    private Button codBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = findViewById(R.id.ID_BUTTON1);

        mediaplayer1 = MediaPlayer.create(MainActivity.this,R.raw.musica);
        //Acao para tocar ou pausar a musica , primeiro verifica se esta tocando se sim pausa a musica se não toca a musica
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaplayer1.isPlaying()) {

                    pausarMusica();
                }
                else{
                    TocarMusica();
                }

            }
        });
        codBotao = findViewById(R.id.ID_COD);

        codBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(MainActivity.this,codificanDo.class);
                startActivity(intencao);
            }
        });


    }
    //metodo para Tocar a música
    private void TocarMusica(){
        if (mediaplayer1 != null){
            mediaplayer1.start();
            botao.setText("Pausar");

        }

    }
    // metodo para pausar música
    private void pausarMusica(){
        if (mediaplayer1 != null){
            mediaplayer1.pause();
            botao.setText("Tocar");
        }
    }
    @Override
    //metodo para liberar o player da memoria do celular
    protected void onDestroy() {
        if (mediaplayer1 != null && mediaplayer1.isPlaying()) {
            mediaplayer1.stop();
            mediaplayer1.release();
            mediaplayer1 = null;

        }
        super.onDestroy();
    }
}
