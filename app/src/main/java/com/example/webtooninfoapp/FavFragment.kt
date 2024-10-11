package com.example.webtooninfoapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FavFragment : Fragment() {
    lateinit var xyz: TextView
    lateinit var remove: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        xyz = view.findViewById(R.id.xyz)
        remove = view.findViewById(R.id.remove)

        val sharedPreferences = requireContext().getSharedPreferences("webtoon", Context.MODE_PRIVATE)
        val webtoon = sharedPreferences.getString("webtoon", "")
        xyz.text = webtoon

        remove.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.remove("webtoon")
            editor.apply()
            xyz.text = ""
            Toast.makeText(requireContext(), "Removed All", Toast.LENGTH_SHORT).show()
        }
    }
}