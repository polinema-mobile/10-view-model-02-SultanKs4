package id.putraprima.mvvmlogin.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.putraprima.mvvmlogin.R
import id.putraprima.mvvmlogin.databinding.FragmentSplashBinding
import id.putraprima.mvvmlogin.models.Splash
import id.putraprima.mvvmlogin.viewmodels.SplashViewModels
import id.putraprima.mvvmlogin.viewmodels.SplashViewModelsFactory

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var viewModels: SplashViewModels
    private lateinit var splash: Splash
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        splash = Splash(imageSplash = R.drawable.master_ninja_upper, textSplash = "MVVM Login Gaes")
        viewModels = ViewModelProvider(this, SplashViewModelsFactory(splash = splash)).get(SplashViewModels::class.java)
        binding.splashViewModel = viewModels
        binding.lifecycleOwner = this
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }, 3000)
        return binding.root
    }
}