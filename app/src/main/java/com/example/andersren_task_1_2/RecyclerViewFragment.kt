package com.example.andersren_task_1_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andersren_task_1_2.databinding.RecyclerViewFragmentBinding
import java.util.Random

const val NUMBER_OF_ITEMS = 10

class RecyclerViewFragment : Fragment() {
    private val listOfImages = mutableListOf<Int>()
    private var _binding : RecyclerViewFragmentBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RecyclerViewFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOfImagesCreation()
        val adapter = RecyclerViewAdapter(listOfImages)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun listOfImagesCreation() {

       for (i in 0..NUMBER_OF_ITEMS) {
           listOfImages.add(i, findImage())
       }
    }

    private fun findImage():Int {
        val random = Random()
        val randomInt = random.nextInt(3)

        if(randomInt == 0) {
            return R.drawable.moon
        }

        if (randomInt == 1) {
            return R.drawable.sun
        }

        return R.drawable.snow
    }
}
