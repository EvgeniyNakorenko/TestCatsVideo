package com.example.serviseinfpartn.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.serviseinfpartn.MainActivity
import com.example.serviseinfpartn.databinding.FragmentUserInfoBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"
private const val ARG_PARAM5 = "param5"
private const val ARG_PARAM6 = "param6"
private const val ARG_PARAM7 = "param7"
private const val ARG_PARAM8 = "param8"
private const val ARG_PARAM9 = "param9"
private const val ARG_PARAM10 = "param10"
private const val ARG_PARAM11 = "param11"
private const val ARG_PARAM12 = "param12"
private const val ARG_PARAM13 = "param13"
private const val ARG_PARAM14 = "param14"

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null
    private var param5: String? = null
    private var param6: String? = null
    private var param7: String? = null
    private var param8: String? = null
    private var param9: String? = null
    private var param10: String? = null
    private var param11: String? = null
    private var param12: String? = null
    private var param13: String? = null
    private var param14: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
            param5 = it.getString(ARG_PARAM5)
            param6 = it.getString(ARG_PARAM6)
            param7 = it.getString(ARG_PARAM7)
            param8 = it.getString(ARG_PARAM8)
            param9 = it.getString(ARG_PARAM9)
            param10 = it.getString(ARG_PARAM10)
            param11 = it.getString(ARG_PARAM11)
            param12 = it.getString(ARG_PARAM12)
            param13 = it.getString(ARG_PARAM13)
            param14 = it.getString(ARG_PARAM14)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity
        binding.root.setOnClickListener {
            it.findNavController().popBackStack()
            mainActivity.setBottomNavigationVisibility(View.VISIBLE)
            mainActivity.supportActionBar?.show()
        }
        mainActivity.setBottomNavigationVisibility(View.GONE)
        mainActivity.supportActionBar?.hide()

        binding.textViewname.text = "Name: $param1"
        binding.textUsername.text = "Username: $param2"
        binding.textViewemail.text = "Email: $param3"
        binding.textViewphone.text = "Phone: $param4"
        binding.textViewwebsite.text = "Website: $param5"
        binding.textViewaddressStreet.text = "Street: $param6"
        binding.textViewaddressSuite.text = "Suite: $param7"
        binding.textViewaddressCity.text = "City: $param8"
        binding.textViewaddressZipcode.text = "Zipcode: $param9"
        binding.textViewGeoLat.text = "Latitude: $param10"
        binding.textViewGeoLng.text = "Longitude: $param11"
        binding.textViewCompanyName.text = "Name: $param12"
        binding.textViewCompanyCatch.text = "catchPhrase: $param13"
        binding.textViewCompanyBs.text = "Bs: $param14"

    }

}