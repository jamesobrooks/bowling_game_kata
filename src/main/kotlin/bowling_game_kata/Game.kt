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
            when {
                isStrike(frameIndex) -> {
                    score += 10 + strikeBonus(frameIndex)
                    frameIndex++
                }
                isSpare(frameIndex) -> {
                    score += 10 + spareBonus(frameIndex)
                    frameIndex += 2
                }
                else -> {
                    score += framePins(frameIndex)
                    frameIndex += 2
                }
            }
        }
        return score
    }

    private fun isStrike(frameIndex: Int) = rolls[frameIndex] == 10

    private fun isSpare(frameIndex: Int) = framePins(frameIndex) == 10

    private fun framePins(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1]

    private fun strikeBonus(frameIndex: Int) = rolls[frameIndex+1] + rolls[frameIndex+2]

    private fun spareBonus(frameIndex: Int) = rolls[frameIndex+2]
}