package com.dimasrizqi.challenge7.data.room.repository

import com.dimasrizqi.challenge7.data.room.dao.AccountDao
import com.dimasrizqi.challenge7.data.room.entity.AccountEntity
import javax.inject.Inject

class AccountRepository @Inject constructor(private val accountDao: AccountDao) {
    suspend fun readAccountByUsername(userName: String): AccountEntity {
        return accountDao.readAccountByUsername(userName)
    }

    suspend fun readAccountById(id: Long): AccountEntity? {
        return accountDao.readAccountById(id)
    }

    suspend fun readAccountByEmail(email: String): AccountEntity {
        return accountDao.readAccountByEmail(email)
    }

    suspend fun insertAccount(accountEntity: AccountEntity) {
        accountDao.insertAccount(accountEntity)
    }

    suspend fun updateAccount(accountEntity: AccountEntity) {
        accountDao.updateAccount(accountEntity)
    }

    suspend fun deleteAccount(accountEntity: AccountEntity) {
        accountDao.deleteAccount(accountEntity)
    }

}