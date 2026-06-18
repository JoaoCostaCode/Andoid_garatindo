package com.example.firstaplication // package da mionha aplicação que eu defini lá no começo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat // imports gerais
import com.example.firstaplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() { // essa classe AppCompatActivity sabe gerenciar o ciclo de vida dentro do andoid e a minha classe MainActivity() está herdando os poderes dela
    override fun onCreate(savedInstanceState: Bundle?) { // esse daqui é o primeiro metodo que o andoid irá executar
        super.onCreate(savedInstanceState) // esse metodo faz com que o OS rode o código padrão antes de rodar o meu
        enableEdgeToEdge() // função para que o app ocupe a tela inteira

        val binding = ActivityMainBinding.inflate(layoutInflater) //criamos uma variavel binding que contem o "mapa" que criamos (ActivityMainBinding) e queremos a parti desse mapa contruir, ou "inflar", nosso app inflate(layoutInflater)
        setContentView(binding.root) // aqui pegamos tudo que está guardado dentro do "mapa" e mostramos na tela, esse root é de raiz então ele pega como se fossse a caixa principal do binding

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets -> // aqui é um bloco de "ajustes de segurança"
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // meu código irá começar aqui -----------------------

        val lista = resources.getStringArray(R.array.Frases)

        binding.btnGeradoMusica.setOnClickListener { // aqui eu peguei o meu objetio binding dele eu busquei meu botão e dentro das funções peguei a que quando o usuaprio clicar irá acontecr algo
            // tudo dentro desse bloco irá disparar depois que eu der o touch no botão
            val indice = Random.nextInt(lista.size) // o indece será gerando de maneira aleatoria com no maximo o tamanho da nossa lista
            binding.txtMusica.text = lista[indice]
        }
    } // fim do Oncreate (que roda a parte inicial)
} // fim do MainActivity que tem os poderes de gerenciar o android