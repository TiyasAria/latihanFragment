package com.tiyas.latihanfragment.latihanFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tiyas.latihanfragment.R
import com.tiyas.latihanfragment.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment(), View.OnClickListener {

//    membuat view binding dalam fragment , untuk menggantikan findViewById
    private   var  categoryBinding : FragmentCategoryBinding? = null
//    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        categoryBinding  = FragmentCategoryBinding.inflate(inflater, container, false)
        return categoryBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory = categoryBinding!!.btnDetailCategory
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_detail_category -> {
                val mDetailFragment = DetailCategoryFragment()
                val mbundle = Bundle()
                mbundle.putString(DetailCategoryFragment.EXTRA_NAME, "lifestyle")
                val description = "Kategori ini bersifat produk lifestyle"

                mDetailFragment.arguments = mbundle
                mDetailFragment.description = description

                val mFragmnetManager = parentFragmentManager
                mFragmnetManager.beginTransaction().apply {
                    replace(R.id.frame_container, mDetailFragment, DetailCategoryFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }

}