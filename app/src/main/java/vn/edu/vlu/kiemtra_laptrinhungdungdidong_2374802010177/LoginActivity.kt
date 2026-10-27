package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2374802010177

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vn.edu.vlu.kiemtra_laptrinhungdungdidong_2374802010177.R

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() && password.isEmpty() -> {
                    tvStatus.text =
                        "Lỗi: Vui lòng nhập Email và mật khẩu!"
                }

                email.isEmpty() -> {
                    tvStatus.text =
                        "Lỗi: Email không được để trống!"
                }

                password.isEmpty() -> {
                    tvStatus.text =
                        "Lỗi: Mật khẩu không được để trống!"
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.text =
                        "Lỗi: Email không đúng định dạng!"
                }

                password.length < 6 -> {
                    tvStatus.text =
                        "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
                }

                else -> {
                    tvStatus.text = "Xác thực thành công!"

                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("USER_EMAIL", email)
                    startActivity(intent)
                }
            }
        }
    }
}
