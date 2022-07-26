package com.example.pocketchef.domain.interactor

interface HomeInteractor {
    suspend fun checkIfAuthentificated(): Boolean
}