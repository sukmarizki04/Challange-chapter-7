package com.dimasrizqi.challenge7.room

import com.dimasrizqi.challenge7.data.room.AppDatabase
import com.dimasrizqi.challenge7.data.room.dao.AccountDao
import com.dimasrizqi.challenge7.data.room.entity.AccountEntity
import com.dimasrizqi.challenge7.data.room.repository.AccountRepository
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class DatabaseTest {
    private lateinit var accountDao: AccountDao
    private lateinit var accountRepository: AccountRepository
    private lateinit var appDatabase: AppDatabase

    @Before
    fun setUp() {
        accountDao = mock()
        accountRepository = AccountRepository(accountDao)
    }

    @Test
    fun readAccountByUsername(): Unit = runBlocking {
        val respAccountEntity = mockk<AccountEntity>()
        Mockito.`when`(accountDao.readAccountByUsername(any())).thenReturn(respAccountEntity)
        val result = accountRepository.readAccountByUsername("test")
        assertEquals(result, respAccountEntity)
    }

    @Test
    fun readAccountById(): Unit = runBlocking {
        val respAccountEntity = mockk<AccountEntity>()
        Mockito.`when`(accountDao.readAccountById(any())).thenReturn(respAccountEntity)
        val result = accountRepository.readAccountById(1)
        assertEquals(result, respAccountEntity)
    }

    @Test
    fun readAccountByEmail(): Unit = runBlocking {
        val respAccountEntity = mockk<AccountEntity>()
        Mockito.`when`(accountDao.readAccountByEmail(any())).thenReturn(respAccountEntity)
        val result = accountRepository.readAccountByEmail("test")
        assertEquals(result, respAccountEntity)
    }

}