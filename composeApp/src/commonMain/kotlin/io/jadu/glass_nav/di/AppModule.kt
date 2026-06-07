package io.jadu.glass_nav.di

import io.jadu.glass_nav.ui.viewmodel.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun appModule(): Module = module {


    viewModel { HomeViewModel() }
}

val appModule = listOf(
    appModule(),
    platformModule()
)
