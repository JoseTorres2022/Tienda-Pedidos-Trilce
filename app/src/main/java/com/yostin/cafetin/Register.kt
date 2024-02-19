package com.yostin.cafetin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Register : AppCompatActivity() {

    private lateinit var txtNombApell : EditText
    private lateinit var txtEmail : EditText
    private lateinit var txtPhone: EditText
    private lateinit var txtPassword : EditText
    private lateinit var btnRegister: Button

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance()

        txtNombApell = findViewById(R.id.txtNombApell)
        txtEmail = findViewById(R.id.txtEmail)
        txtPhone = findViewById(R.id.txtPhone)
        txtPassword = findViewById(R.id.txtPassword)

        btnRegister = findViewById(R.id.btnRegister)


        btnRegister.setOnClickListener {
            val email = txtEmail.text.toString()
            val password = txtPassword.text.toString()

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("MainActivity", "Registro exitoso")
                        val user: FirebaseUser? = firebaseAuth.currentUser
                    } else {
                        Log.w("MainActivity", "Error en el registro", task.exception)
                    }
                }
        }
    }
}