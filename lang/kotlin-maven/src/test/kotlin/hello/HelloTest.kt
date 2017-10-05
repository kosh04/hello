package hello.tests

import hello.Hello
import kotlin.test.assertEquals
import org.junit.Test

class HelloWorldTest {
        @Test fun testAssert() {
                val hello = Hello()
                assertEquals(hello.text, "Hello, world!")
                hello.print()
        }
}
