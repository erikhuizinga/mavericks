package com.airbnb.mvrx.sample.features.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.sample.R
import com.airbnb.mvrx.sample.views.Marquee
import com.airbnb.mvrx.withState

class HelloWorldFragment : Fragment(), MvRxView {
    private val viewModel: HelloWorldViewModel by fragmentViewModel()

    private lateinit var marquee: Marquee

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_hello_world, container, false).apply {
            findViewById<Toolbar>(R.id.toolbar).setupWithNavController(findNavController())
            marquee = findViewById(R.id.marquee)
        }

    override fun invalidate() = withState (viewModel) { state ->
        marquee.setTitle(state.title)
    }
}