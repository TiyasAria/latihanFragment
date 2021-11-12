package com.tiyas.latihanfragment.latihanFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.tiyas.latihanfragment.R
import com.tiyas.latihanfragment.databinding.FragmentOptionDialogBinding


class OptionDialogFragment : DialogFragment() {

    private var _binding : FragmentOptionDialogBinding? = null
    private val optionDialogBinding get() = _binding!!
    private  var optionDialogListener : OnOptionDialogListener? = null

    interface OnOptionDialogListener {
        fun onOptionChoose(text : String?)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOptionDialogBinding.inflate(inflater, container,false)
        return  optionDialogBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnChoose = optionDialogBinding.btnChoose
        val btnClose = optionDialogBinding.btnClose
        val rgOptions =  optionDialogBinding.rgOptions
        val rbSaf = optionDialogBinding.rbSaf
        val rbLvg = optionDialogBinding.rbLvg
        val rbMou = optionDialogBinding.rbMou
        val rbMouyes = optionDialogBinding.rbMouyes


        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1){
                var coach : String? = null
                when(checkedRadioButtonId){
                    R.id.rb_saf -> coach = rbSaf.text.toString().trim()
                    R.id.rb_lvg -> coach = rbLvg.text.toString().trim()
                    R.id.rb_mou -> coach = rbMou.text.toString().trim()
                    R.id.rb_mouyes -> coach = rbMouyes.text.toString().trim()
                }
                optionDialogListener?.onOptionChoose(coach)
                dialog?.dismiss()
            }
        }

        btnClose.setOnClickListener {
            dialog?.cancel()
        }



    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailCategoryFragment){
            this.optionDialogListener = fragment.optionDialogListener
        }

    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener =  null
    }

}