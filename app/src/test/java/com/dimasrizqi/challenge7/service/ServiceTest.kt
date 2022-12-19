package com.dimasrizqi.challenge7.service

import com.bumptech.glide.load.engine.Resource
import com.dimasrizqi.challenge7.models.Data
import com.dimasrizqi.challenge7.models.MovieResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Call

class ServiceTest {
    lateinit var service : TheMovieDBApiInterface

    @Before
    fun setUp(){
        service = mockk()
    }

    @Test
    fun getPopularMoviesTest(): Unit = runBlocking {
        val respAllPopularMovies = mockk <Call<MovieResponse>>()

        every {
            runBlocking {
                service.getPopularMovies()
            }
        } returns respAllPopularMovies

        val result = service.getPopularMovies()

        verify {
            runBlocking {
                service.getPopularMovies()
            }
        }
        assertEquals(result, respAllPopularMovies)
    }

    @Test
    fun getDetailsMoviesTest(): Unit = runBlocking {
        val respAllDetailsMovies = mockk <Call<Data>>()

        every {
            runBlocking {
                service.getDetailsMovies(326372)
            }
        } returns respAllDetailsMovies

        val result = service.getDetailsMovies(326372)

        verify {
            runBlocking {
                service.getDetailsMovies(326372)
            }
        }
        assertEquals(result, respAllDetailsMovies)
    }
}