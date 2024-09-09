package com.aura.service

import com.aura.model.Account
import com.aura.model.User
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult
import com.aura.model.transfer.Transfer
import com.aura.model.transfer.TransferResult

/**
 * A local implementation of the ApiService interface.
 */
class LocalApiService : ApiService {

    /**
     * A list of all users.
     */
    private val users = listOf(
        User("1234", "Pierre", "Brisette", "p@sswOrd",
            listOf(
                Account("1", true, 2354.23),
                Account("2", false, 235.22),
            )
        ),
        User("5678", "Gustave", "Charbonneau", "T0pSecr3t",
            listOf(
                Account("3", false, 24.53),
                Account("4", true, 10032.21),
            )
        )
    )

    override fun login(credentials: Credentials): CredentialsResult {
        val user = getUserById(credentials.id)
        return CredentialsResult(user?.password == credentials.password)
    }

    override fun accounts(id: String): List<Account> {
        val user = getUserById(id)
        return user?.accounts ?: emptyList()
    }

    override fun transfer(transfer: Transfer): TransferResult {
        val sender = getUserById(transfer.senderId) ?: throw IllegalArgumentException("The sender cannot be found")
        val recipient = getUserById(transfer.recipientId) ?: throw IllegalArgumentException("The recipient cannot be found")
        println("TESTXtransfer $sender, $recipient, ${transfer.amount} ")
        if( transfer.amount < 0 ) {
            println("TESTXtransfer: The amount to send cannot be negative ")
            throw IllegalArgumentException("The amount to send cannot be negative")

        }

        val mainAccountSender = sender.accounts.firstOrNull { it.main == true }
        val recipientAccountSender = recipient.accounts.firstOrNull { it.main == true }

        println("TESTXtransfer: mainAccountSender: $mainAccountSender, recipientAccountSender: $recipientAccountSender")


        return if(mainAccountSender == null || recipientAccountSender == null || mainAccountSender.balance - transfer.amount < 0)
        {
            TransferResult(false)
        }
        else {
            mainAccountSender.balance -= transfer.amount
            recipientAccountSender.balance += transfer.amount

            println("TESTXtransfer:: mainAccountSender.balance: ${mainAccountSender.balance} recipientAccountSender.balance: ${recipientAccountSender.balance}")

            TransferResult(true)
        }
    }

    /**
     * Gets a user by their ID.
     * @param id The user's ID.
     * @return The user, or null if the user cannot be found.
     */
    private fun getUserById(id: String): User? {
        return users.firstOrNull { it.id == id }
    }

}