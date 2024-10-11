package com.example.webtooninfoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class HomeFragment : Fragment() {

    lateinit var soloImg: ImageView
    lateinit var towerImg: ImageView
    lateinit var hardImg: ImageView
    lateinit var nobleesImg: ImageView
    lateinit var soloHead: TextView
    lateinit var towerHead: TextView
    lateinit var hardHead: TextView
    lateinit var nobleesHead: TextView
    lateinit var soloDesc: TextView
    lateinit var towerDesc: TextView
    lateinit var hardDesc: TextView
    lateinit var nobleesDesc: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        soloImg = view.findViewById(R.id.soloImg)
        towerImg = view.findViewById(R.id.towerImg)
        hardImg = view.findViewById(R.id.hardImg)
        nobleesImg = view.findViewById(R.id.nobleesImg)
        soloHead = view.findViewById(R.id.soloHead)
        towerHead = view.findViewById(R.id.towerHead)
        hardHead = view.findViewById(R.id.hardHead)
        nobleesHead = view.findViewById(R.id.nobleesHead)
        soloDesc = view.findViewById(R.id.soloDesc)
        towerDesc = view.findViewById(R.id.towerDesc)
        hardDesc = view.findViewById(R.id.hardDesc)
        nobleesDesc = view.findViewById(R.id.nobleesDesc)

        val commonClick = View.OnClickListener { view ->
            when(view.id){
                R.id.soloImg, R.id.soloDesc, R.id.soloHead -> onClick(0)
                R.id.towerImg, R.id.towerDesc, R.id.towerHead -> onClick(1)
                R.id.hardImg, R.id.hardDesc, R.id.hardHead -> onClick(2)
                R.id.nobleesImg, R.id.nobleesDesc, R.id.nobleesHead -> onClick(3)
            }
        }
        soloImg.setOnClickListener(commonClick)
        towerImg.setOnClickListener(commonClick)
        hardImg.setOnClickListener(commonClick)
        nobleesImg.setOnClickListener(commonClick)
        soloHead.setOnClickListener(commonClick)
        towerHead.setOnClickListener(commonClick)
        hardHead.setOnClickListener(commonClick)
        nobleesHead.setOnClickListener(commonClick)
        soloDesc.setOnClickListener(commonClick)
        towerDesc.setOnClickListener(commonClick)
        hardDesc.setOnClickListener(commonClick)
        nobleesDesc.setOnClickListener(commonClick)

        return view
    }

    private fun onClick(para: Int){
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putInt("detailPara", para)
        detailFragment.arguments = bundle
        parentFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.main, detailFragment).commit()
    }
}