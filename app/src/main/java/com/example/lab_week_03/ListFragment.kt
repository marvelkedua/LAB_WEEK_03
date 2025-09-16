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

        // A list of all your clickable coffee views, now with 5 items
        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.cappuccino), // Added
            view.findViewById(R.id.espresso)    // Added
        )

        // This loop handles all five items without any other changes needed
        coffeeList.forEach { coffeeView ->
            coffeeView.setOnClickListener {
                val fragmentBundle = Bundle()
                fragmentBundle.putInt(COFFEE_ID, coffeeView.id)
                findNavController().navigate(R.id.coffee_id_action, fragmentBundle)
            }
        }
    }
    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
