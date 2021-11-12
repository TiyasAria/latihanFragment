package com.tiyas.latihanfragment.latihanFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tiyas.latihanfragment.databinding.FragmentDetailCategoryBinding


class DetailCategoryFragment : Fragment() {

    private var _binding : FragmentDetailCategoryBinding? = null
    private  val  binding get() = _binding!!

    var description : String? = null

    companion object{
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailCategoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvCategory = binding.tvCategoryName
        val tvDesc = binding.tvCategoryDescription
        val btnProfile = binding.btnProfile
        val btnDialog = binding.btnDialog

        if (savedInstanceState != null){
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if(arguments != null){
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategory.text = categoryName
            tvDesc.text = description
        }

        btnDialog.setOnClickListener {
            val mOptionDialogFragment = OptionDialogFragment()

            val mFragmentManager = childFragmentManager
            mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment::class.java.simpleName)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(activity, ActivityProfile::class.java)
            startActivity(intent)
        }

    }

    internal  val optionDialogListener : OptionDialogFragment.OnOptionDialogListener = object :
        OptionDialogFragment.OnOptionDialogListener {
        override fun onOptionChoose(text: String?) {
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        }
    }


}