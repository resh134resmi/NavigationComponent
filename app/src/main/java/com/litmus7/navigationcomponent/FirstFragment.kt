package com.litmus7.navigationcomponent


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation



class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.navigation_first_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle()
        bundle.putBoolean("test_boolean", true)

        val navController = Navigation.findNavController(activity!!, R.id.navhost_fragment)


        val button: Button = view.findViewById(R.id.button_frag1)

        button.setOnClickListener(View.OnClickListener {
            navController.navigate(
                R.id.action_firstFragment_to_secondFragment,
                bundle
            )
        })

    }
}
