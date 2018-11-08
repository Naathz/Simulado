package com.estudo.nath.simulado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        btPesquisar.setOnClickListener(){
            val mandarProximaTela = Intent(this, ResultadoActivity::class.java)
            mandarProximaTela.putExtra("DADOS", etDigitar.text.toString())
            startActivity(mandarProximaTela)
        }
    }
}
