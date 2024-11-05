package com.example.odontovision.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.odontovision.R
import com.example.odontovision.menu.MenuActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Referência ao botão "Acessar"
        val buttonAcessar: Button = findViewById(R.id.buttonLogin)
        // Referência ao botão "Primeiro Acesso"
        val buttonPrimeiroAcesso: Button = findViewById(R.id.buttonPrimeiroAcesso)
        // Referência aos campos de email e senha
        val emailEditText: EditText = findViewById(R.id.editTextText)
        val senhaEditText: EditText = findViewById(R.id.editTextText2)

        // Configurando o clique do botão para iniciar a MenuActivity
        buttonAcessar.setOnClickListener {
            val email = emailEditText.text.toString()
            val senha = senhaEditText.text.toString()

            // Carregar dados de login de SharedPreferences
            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val savedEmail = sharedPreferences.getString("email", null)
            val savedSenha = sharedPreferences.getString("senha", null)

            // Verificar se o usuário está cadastrado
            if (email == savedEmail && senha == savedSenha) {
                // Usuário autenticado, redireciona para o MenuActivity
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish() // Para não permitir voltar à tela de login
            } else {
                // Exibe mensagem de erro se as credenciais não forem válidas
                Toast.makeText(this, "Usuário não tem cadastro ou credenciais incorretas.", Toast.LENGTH_LONG).show()
            }
        }

        // Configurando o clique do botão para iniciar a PrimeiroAcessoActivity
        buttonPrimeiroAcesso.setOnClickListener {
            val intent = Intent(this, PrimeiroAcessoActivity::class.java)
            startActivity(intent)  // Inicia a tela de primeiro acesso
        }
    }
}
