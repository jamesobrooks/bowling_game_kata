package bowling_game_kata

class Game {
    val rolls = mutableListOf<Int>()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0
        var i = 0
        for (frame in 0..9) {
            score += rolls[i] + rolls[i+1]
            i += 2
        }
        return score
    }
}