package com.example.odontovision.login

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.odontovision.R

class PrimeiroAcessoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_acesso)

        // Referências para os campos de texto e botões
        val botaoVoltar: ImageView = findViewById(R.id.botaovoltar)
        val nomeEditText: EditText = findViewById(R.id.editTextNome)
        val emailEditText: EditText = findViewById(R.id.editTextEmail)
        val senhaEditText: EditText = findViewById(R.id.editTextSenha)
        val botaoRegistrar: Button = findViewById(R.id.buttonRegistrar)

        // Configurando o botão de voltar
        botaoVoltar.setOnClickListener {
            finish()
        }

        // Ação de registrar o usuário
        botaoRegistrar.setOnClickListener {
            // Captura os valores digitados
            val nome = nomeEditText.text.toString()
            val email = emailEditText.text.toString()
            val senha = senhaEditText.text.toString()

            // Verifica se os campos não estão vazios
            if (nome.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty()) {
                // Salvar o cadastro usando SharedPreferences
                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("email", email)
                editor.putString("senha", senha)
                editor.apply()

                // Exibe mensagem de sucesso
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()

                // Limpa os campos
                nomeEditText.text.clear()
                emailEditText.text.clear()
                senhaEditText.text.clear()

                // (Opcional) Voltar para a tela de login
                finish()
            } else {
                // Exibe mensagem de erro se algum campo estiver vazio
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
