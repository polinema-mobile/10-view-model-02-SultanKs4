package id.putraprima.mvvmlogin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.putraprima.mvvmlogin.models.Splash

class SplashViewModelsFactory(private var splash: Splash) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModels::class.java)) {
            return SplashViewModels(splash = splash) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}