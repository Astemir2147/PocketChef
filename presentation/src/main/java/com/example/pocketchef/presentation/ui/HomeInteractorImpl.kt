package com.example.pocketchef.presentation.ui

import com.example.pocketchef.data.db.repository.HomeRepositoryImpl
import javax.inject.Inject

class HomeInteractorImpl @Inject constructor(private val homeRepository: HomeRepositoryImpl) {
     suspend fun checkIfAuthentificated(): Boolean =
        homeRepository.getCookieFromPreferences().userMail.isNotEmpty()
}