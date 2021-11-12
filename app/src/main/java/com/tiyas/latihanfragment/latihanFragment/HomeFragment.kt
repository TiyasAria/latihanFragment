package com.tiyas.latihanfragment.latihanFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tiyas.latihanfragment.R
import com.tiyas.latihanfragment.databinding.FragmentHomeBinding


class HomeFragment : Fragment() , View.OnClickListener{

//    buatlah variable untuk view binding nya yang akan memanggil id dari XML , gunakan selaain findViewById
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory = _binding!!.btnCategory
        btnCategory.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_category){
//            deklarasikan fragment category
            val mCategoryFragment = CategoryFragment()
//            panggil fragmnet manager nya
            val mFragmentManager = parentFragmentManager
            mFragmentManager
                .beginTransaction()
                .apply {
//                     replace digunakan untuk mengganti backStage dari fragment sebelunnya jadi kalau di close , apk  gak langsung ke close tapi ke fragment sebelumnya
                    replace(R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
        }
    }


}