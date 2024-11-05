package com.example.odontovision.menu

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.example.odontovision.R
import com.example.odontovision.login.LoginActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Configurando o ícone de perfil para exibir o menu
        val profileIcon: ImageView = findViewById(R.id.icon)
        profileIcon.setOnClickListener { view ->
            showPopupMenu(view)
        }

        // Configurar os outros botões do menu
        val buttonMeuPlano: View = findViewById(R.id.buttonMeuPlano)
        buttonMeuPlano.setOnClickListener {
            val intent = Intent(this, MeuPlanoActivity::class.java)
            startActivity(intent)
        }

        val buttonAgenda: View = findViewById(R.id.buttonAgenda)
        buttonAgenda.setOnClickListener {
            val intent = Intent(this, AgendaActivity::class.java)
            startActivity(intent)
        }

        val buttonMeuPerfil: View = findViewById(R.id.buttonMeuPerfil)
        buttonMeuPerfil.setOnClickListener {
            val intent = Intent(this, MeuPerfilActivity::class.java)
            startActivity(intent)
        }

        val buttonBuscarDentista: View = findViewById(R.id.buttonBuscarDentista)
        buttonBuscarDentista.setOnClickListener {
            val intent = Intent(this, BuscarDentistaActivity::class.java)
            startActivity(intent)
        }

        val buttonFaleConosco: View = findViewById(R.id.buttonFaleConosco)
        buttonFaleConosco.setOnClickListener {
            val intent = Intent(this, FaleConoscoActivity::class.java)
            startActivity(intent)
        }
    }

    // Função para exibir o PopupMenu quando o ícone de perfil for clicado
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_profile, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.action_logout -> {
                    // Ação de logout - Voltar para a tela de login
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish() // Fechar o MenuActivity para não permitir o retorno
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
