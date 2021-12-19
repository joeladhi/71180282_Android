package com.example.uas_andro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.uas_andro.databinding.ActivityLoginBinding
import com.example.uas_andro.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityLoginBinding

    private  lateinit var googleSignInClient: GoogleSignInClient
    private  lateinit var firebaseAuth: FirebaseAuth

    private companion object{
        private const val RC_SIGN_IN = 100
        private const val TAG = "GOOGLE_SIGN_IN_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //konfigurasi sign in
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //click to sign in

        binding.btnLogin.setOnClickListener{
            Log.d(TAG, "onCreate: Sign in")
            val intent = googleSignInClient.signInIntent
//            getResultSign.launch(intent)
            startActivityForResult(intent, RC_SIGN_IN)
        }
    }


    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            //user logged in
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            Log.d(TAG, "onActivityResult: Sign in result")
            val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                //sign success
                val account = accountTask.getResult(ApiException::class.java)
                firebaseAuthWithGoogleAccount(account)
            } catch (e: Exception) {
                //failed google sign in
                Log.d(TAG, "onActivityResult : ${e.message} ")
            }
        }
    }
//    private val getResultSign =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            result ->
//            if (result.resultCode == RC_SIGN_IN) {
//                Log.d(TAG, "onActivityResult: Sign in result")
//                val data = result.data
//                val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
//                try {
//                    //sign success
//                    val account = accountTask.getResult(ApiException::class.java)
//                    firebaseAuthWithGoogleAccount(account)
//                } catch (e: Exception) {
//                    //failed google sign in
//                    Log.d(TAG, "onActivityResult : ${e.message} ")
//                }
//            }
//    }

    private fun firebaseAuthWithGoogleAccount(account: GoogleSignInAccount?) {
        Log.d(TAG, "firebaseAuthWithGoogleAccount: begin firebase auth with google account")

        val credential =  GoogleAuthProvider.getCredential(account!!.idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                //login success
                Log.d(TAG, "firebaseAuthWithGoogleAccount: loggedIn")

                //get loggedIn user
                val firebaseUser = firebaseAuth.currentUser
                val uid = firebaseAuth!!.uid
                val email = firebaseUser!!.email

                Log.d(TAG, "firebaseAuthWithGoogleAccount: Uid: $uid")
                Log.d(TAG, "firebaseAuthWithGoogleAccount: Email: $email")

                //check user new or exist
                if (authResult.additionalUserInfo!!.isNewUser){
                    //user new
                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Account created")
                    Toast.makeText(this, "Account created \n$email", Toast.LENGTH_SHORT).show()
                }
                else{
                    //user exist
                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Existing User")
                    Toast.makeText(this, "Existing User \n$email", Toast.LENGTH_SHORT).show()
                }
                //activity
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()
            }
            .addOnFailureListener{ e ->
                Log.d(TAG, "firebaseAuthWithGoogleAccount: Loggin Failed ${e.message}")
                Toast.makeText(this, "Loggin Failed ${e.message}", Toast.LENGTH_SHORT).show()

            }
    }
}