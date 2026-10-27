package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2374802010177

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvProfileEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var listViewSkills: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 1. Anh xa giao dien bang findViewById
        tvProfileEmail = findViewById(R.id.tvProfileEmail)
        btnLogout = findViewById(R.id.btnLogout)
        listViewSkills = findViewById(R.id.listViewSkills)

        // 2. Nhan Email tu LoginActivity
        val email = intent.getStringExtra("USER_EMAIL")
        tvProfileEmail.text = "Email: ${email ?: "Chưa có dữ liệu"}"

        // 3. Tao danh sach 5 mon hoc / ky nang
        val skills = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // 4. Gan ArrayAdapter vao ListView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            skills
        )

        listViewSkills.adapter = adapter

        // 5. Xu ly khi cham vao mot mon hoc
        listViewSkills.setOnItemClickListener {
                _, _, position, _ ->

            val selectedItem = skills[position]

            Toast.makeText(
                this,
                "Bạn đã chọn: $selectedItem",
                Toast.LENGTH_SHORT
            ).show()
        }

        // 6. Dang xuat
        btnLogout.setOnClickListener {
            finish()
        }
    }
}