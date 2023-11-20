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

class RecyclerViewFragment : Fragment(), OnItemClickListener {
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
        val adapter = RecyclerViewAdapter(listOfImages, onItemClickListener = this)
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(position : Int) {
        val args = Bundle()
        val showItemNumberFragment = ShowItemNumberFragment.newInstance()

        when(position) {
            0 -> args.putString("number", "1 (first)")
            1 -> args.putString("number", "2 (second)")
            2 -> args.putString("number", "3 (third)")
            3 -> args.putString("number", "4 (fourth)")
            4 -> args.putString("number", "5 (fifth)")
            5 -> args.putString("number", "6 (sixth)")
            6 -> args.putString("number", "7 (seventh)")
            7 -> args.putString("number", "8 (eighth)")
            8 -> args.putString("number", "9 (ninth)")
            9 -> args.putString("number", "10 (tenth)")
        }

        showItemNumberFragment.arguments = args
        showItemNumberFragment.show(childFragmentManager, TAG)
    }
}
