package bowling_game_kata

class Game {
    val rolls = mutableListOf<Int>()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0
        var frameIndex = 0
        for (frame in 0..9) {
            if (isSpare(frameIndex)) {
                score += 10 + rolls[frameIndex+2]
                frameIndex += 2
            } else {
                score += rolls[frameIndex] + rolls[frameIndex+1]
                frameIndex += 2
            }
        }
        return score
    }

    private fun isSpare(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1] == 10
}