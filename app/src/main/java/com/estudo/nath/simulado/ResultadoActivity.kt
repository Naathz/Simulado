package com.estudo.nath.simulado

import android.app.Service
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.estudo.nath.simulado.api.ServiceAPI
import com.estudo.nath.simulado.model.Usuario
import kotlinx.android.synthetic.main.activity_pesquisa.*
import kotlinx.android.synthetic.main.activity_resultado.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val buscarDaOutraTela = intent.getStringExtra("DADOS")

        val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(ServiceAPI::class.java)
        service.buscarUsuario(buscarDaOutraTela)
                .enqueue(object : Callback<Usuario> {
                    override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                        Toast.makeText(this@ResultadoActivity, "não foi", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                        val usuario = response?.body()
                        tvNome.text = usuario?.nome
                        tvCabelo.text = usuario?.cabelo
                        tvPele.text = usuario?.pele
                        tvNacimento.text = usuario?.nascimento
                        tvGenero.text = usuario?.genero
                    }
                })
    }
}
