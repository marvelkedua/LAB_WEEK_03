package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // A list of all your clickable coffee views
        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte)
        )

        // Loop through each view and set its click listener
        coffeeList.forEach { coffeeView ->

            // This is the correct way ✅
            coffeeView.setOnClickListener {
                // This code now runs ONLY when the coffeeView is clicked
                val fragmentBundle = Bundle()

                // Pass the unique ID of the clicked view to the next fragment
                fragmentBundle.putInt(COFFEE_ID, coffeeView.id)

                // Navigate using the action and the data bundle
                findNavController().navigate(R.id.coffee_id_action, fragmentBundle)
            }
        }
    }
    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
