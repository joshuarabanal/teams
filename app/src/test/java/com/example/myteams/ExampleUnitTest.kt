package com.example.myteams

import com.example.API.TeamAPI
import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        //assertEquals(4, 2 + 2)
        var teamApi = TeamAPI();
        System.out.println(""+test()+"");

    }

    public fun test():Int{
        var integer = -1;
        var i = runBlocking {
            delay(500)
                integer = 0;

        }
        return integer;

    }
}
