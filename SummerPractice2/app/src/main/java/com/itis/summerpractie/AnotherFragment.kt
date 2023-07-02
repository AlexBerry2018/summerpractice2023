package com.itis.summerpractie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itis.summerpractie.databinding.FragmentAnotherBinding

class AnotherFragment : Fragment(R.layout.fragment_another) {

    private var binding: FragmentAnotherBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnotherBinding.bind(view)

        val className = arguments?.getString("CLASS_NAME")
        Snackbar.make(binding!!.root, className.toString(), Snackbar.LENGTH_LONG).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {
        fun createBundle(className: String): Bundle{
            val bundle = Bundle()
            bundle.putString("CLASS_NAME", className)
            return bundle
        }
    }
}