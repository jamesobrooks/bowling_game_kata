package bowling_game_kata

class Game {
    val rolls = mutableListOf<Int>()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0
        for (roll in rolls) {
            score += roll
        }
        return score
    }
}