package com.example.kursakademiaandroida.features.episodes.di

import com.example.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.example.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.example.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import com.example.kursakademiaandroida.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


var episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}