package com.example.ngo
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ngo.databinding.ActivityRegisterNgoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class RegisterNgo : AppCompatActivity() {
    var binding: ActivityRegisterNgoBinding? = null
    var name: String? = null
    var type: String? = null
    var location: String? = null
    var contact: String? = null
    var mission: String? = null
    var history: String? = null
    var db: FirebaseDatabase? = null
    var reference: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterNgoBinding.inflate(layoutInflater)
        setContentView(binding!!.getRoot())
        binding!!.register.setOnClickListener(View.OnClickListener {
            name = binding!!.name.getText().toString()
            type = binding!!.location.getText().toString()
            location = binding!!.type.getText().toString()
            contact = binding!!.contact.getText().toString()
            mission = binding!!.contact.getText().toString()
            history= binding!!.contact.getText().toString()


            if (!name!!.isEmpty() && !type!!.isEmpty() && !location!!.isEmpty() && !contact!!.isEmpty()) {
                val users = User(name, type, location, contact,mission,history)
                db = FirebaseDatabase.getInstance()
                reference = db!!.getReference("User")
                reference!!.child("User").setValue(users).addOnCompleteListener {
                    binding!!.name.setText("")
                    binding!!.type.setText("")
                    binding!!.location.setText("")
                    binding!!.contact.setText("")
                    binding!!.mission.setText("")
                    binding!!.history.setText("")
                    Toast.makeText(this@RegisterNgo, "Successfuly Updated", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
}