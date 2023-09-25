package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {



    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var button : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        //The three assingments below grab ID of
        email = findViewById<EditText>(R.id.editTextText)
        password = findViewById<EditText>(R.id.editTextTextPassword)

        button = findViewById<Button>(R.id.button)

//        var UserImage = findViewById<>()
//        var signUp = findViewById<Button>()


        button.setOnClickListener {

            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

            val emailUse = email.text.toString().trim()
            val passwordUse = password.text.toString().trim()

            //Checking if
            if(emailUse.isEmpty()){
                email.error = "Email Required"
                return@setOnClickListener
            }
            else if(emailUse.length <8) {
                email.error = "Minimum 8 Characters"
                return@setOnClickListener
            }else if(!emailUse.matches(emailRegex.toRegex())){
                email.error = "Invalid Email"
                return@setOnClickListener }
            else if(passwordUse.isEmpty()){
                password.error = "Password Required"
                return@setOnClickListener}
            else if(!validatePassword(passwordUse)){
                password.error = "Invalid, Reenter Password"}
            //Email Validation
            else{
                startActivity(
                    Intent(
                        this, Rolling::class.java
                    ))
        }}

        }
    private fun validatePassword(password: String): Boolean {
        val passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&!])[A-Za-z\\d@#$%^&!]{8,}$")
        val passwordMatcher = passwordPattern.matcher(password)
        return passwordMatcher.matches()
    }}