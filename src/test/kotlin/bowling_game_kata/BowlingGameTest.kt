/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package bowling_game_kata

import kotlin.test.Test
import kotlin.test.assertEquals

class BowlingGameTest {
    @Test
    fun testGutterGame() {
        val game = Game()
        rollMany(game, 20, 0)
        assertEquals(0, game.score())
    }

    @Test
    fun testAllOnes() {
        val game = Game()
        rollMany(game, 20, 1)
        assertEquals(20, game.score())
    }

    @Test
    fun testOneSpare() {
        val game = Game()
        rollSpare(game)
        game.roll(3)
        rollMany(game, 17, 0)
        assertEquals(16, game.score())
    }

    @Test
    fun testOneStrike() {
        val game = Game()
        rollStrikes(game, 1)
        game.roll(3)
        game.roll(4)
        rollMany(game, 16, 0)
        assertEquals(24, game.score())
    }

    @Test
    fun testPerfectGame() {
        val game = Game()
        rollStrikes(game, 12)
        assertEquals(300, game.score())
    }

    private fun rollStrikes(game: Game, num: Int) {
        for (i in 1..num) {
            game.roll(10)
        }
    }

    private fun rollSpare(game: Game) {
        game.roll(5)
        game.roll(5)
    }

    private fun rollMany(game: Game, rolls: Int, pins: Int) {
        for (i in 1..rolls) {
            game.roll(pins)
        }
    }
}
