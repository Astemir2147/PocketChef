package home.Interactor

import Interactor.Interactor
import com.example.pocketchef.data.db.model.Cookie

class InteractorImpl : Interactor {
    override suspend fun checkIfAuthentificated(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun saveCookieFromPreferences(cookie: Cookie) {
        TODO("Not yet implemented")
    }
}