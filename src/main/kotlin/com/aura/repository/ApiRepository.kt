package com.aura.repository

import com.aura.model.Account
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult
import com.aura.model.transfer.Transfer
import com.aura.model.transfer.TransferResult
import com.aura.service.ApiService
import com.aura.service.LocalApiService

/**
 * An object that provides a single point of access to the API.
 */
object ApiRepository: ApiService {

    /**
     * The API service.
     */
    private val apiService: ApiService = LocalApiService()

    override fun login(credentials: Credentials): CredentialsResult {
        return apiService.login(credentials)
    }

    override fun accounts(id: String): List<Account> {
        return apiService.accounts(id)
    }

    override fun transfer(transfer: Transfer): TransferResult {
        return apiService.transfer(transfer)
    }

}