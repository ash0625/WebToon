package com.example.webtooninfoapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailFragment : Fragment() {

    private var para: Int = 0
    lateinit var detailImg: ImageView
    lateinit var detailHead: TextView
    lateinit var detailDesc: TextView
    lateinit var writer: TextView
    lateinit var reads: TextView
    lateinit var btn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        para = arguments?.getInt("detailPara") ?: 0
        detailImg = view.findViewById(R.id.detailImg)
        detailHead = view.findViewById(R.id.detailHead)
        detailDesc = view.findViewById(R.id.detailDesc)
        writer = view.findViewById(R.id.writer)
        reads = view.findViewById(R.id.reads)
        btn = view.findViewById(R.id.btn)

        when(para){
            0 -> {
                detailImg.setImageResource(R.drawable.solo)
                detailHead.text = "Solo Leveling"
                detailDesc.text = "A best action fantasy manhwa and the most talked about adaptation in recent times is undoubtedly Solo Leveling. It is set in a world where humans have discovered supernatural skills, while our protagonist, Sung Jin-Woo, is a nobody with his E-Rank hunting skills. Things will take an interesting turn for him when he becomes the sole survivor of a dungeon raid. Awakened with strange new powers, Sung Jin-Woo will level up from being the weakest Hunter and eventually become the most powerful entity in the universe."
                writer.text = "Writer: Chugong"
                reads.text = "2.5B"
            }
            1 -> {
                detailImg.setImageResource(R.drawable.tower)
                detailHead.text = "Tower of God"
                detailDesc.text = "Even if you are not a manhwa fan, you must have heard of Tower of God. This action fantasy manhwa became especially popular after its anime adaptation. Tower of God focuses on Twenty-Fifth Bam, the young protagonist of the manhwa, who is determined to climb a mysterious Tower to find his friend Rachel. It is to be noted that the titular tower has different floors, and each floor has different obstacles. His quest is not going to be an easy one, and whether or not he will be able to meet his friend remains to be seen. Tower of God Season 2 has also been recently released."
                writer.text = "Creator: SIU (Lee Jong Hui)"
                reads.text = "1.2B"
            }
            2 -> {
                detailImg.setImageResource(R.drawable.hard)
                detailHead.text = "Hardcore Leveling Warrior"
                detailDesc.text = "Gong Won-Ho is the top player of Lucid Adventure because he uses his alias, Hardcore Leveling Warrior, to stay on top. However, one day, the unimaginable happens – he gets defeated, and now he has to get back on the top from the bottom. The most fascinating aspect of this action fantasy manhwa is how he climbed his way to the top in the first place."
                writer.text = "Creator: Sehoon Kim"
                reads.text = "233.3M"
            }
            3 -> {
                detailImg.setImageResource(R.drawable.noblees)
                detailHead.text = "Noblees"
                detailDesc.text = "After being in a slumber for over 800 years, Cadis Etrama Di Raizel, aka Rai, wakes up in an unfamiliar modern world. Fortunately, he meets his loyal servant Frankenstein, who is now the owner of a high school. After attending the school, Rai tries to live an ordinary life, concealing his true identity; however, that won’t happen for long. This supernatural action fantasy manhwa will keep you engaged with its beautiful illustration and unique narrative till the end. It also has its anime adaptation.\n"
                writer.text = "Written by: Jeho Son"
                reads.text = "439.7M"
            }
        }

        btn.setOnClickListener {
            val sharedPreferences = requireContext().getSharedPreferences("webtoon", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("webtoon", detailHead.text.toString())
            editor.apply()
            Toast.makeText(requireContext(), "Added to Favorite", Toast.LENGTH_SHORT).show()
        }
    }
}