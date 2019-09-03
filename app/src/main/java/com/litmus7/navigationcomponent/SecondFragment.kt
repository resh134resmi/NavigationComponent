package com.litmus7.navigationcomponent


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.navigation_second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Toast.makeText(
            activity!!.applicationContext, "Bundle args " + FirstFragmentArgs.fromBundle(
                arguments).getTestString(), Toast.LENGTH_SHORT).show()

        val button: Button = view.findViewById(R.id.button_frag2)
        button.setOnClickListener(View.OnClickListener {
            val navController = Navigation.findNavController(activity!!, R.id.navhost_fragment)
            navController.navigateUp()

            navController.addOnNavigatedListener { controller, destination ->
                Log.d(
                    "TAG",
                    destination.label!!.toString() + " "
                )
            }
        })
    }

}