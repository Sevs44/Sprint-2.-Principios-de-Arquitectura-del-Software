package objects

import kotlin.math.sqrt

class Pentagon private constructor(builder: Builder) : GeometricFigure(builder) {

    private val sideLength: Double = builder.sideLength ?: 0.0

    override fun calculateArea(): Double {
        return 0.25 * sqrt(5.0 * (5.0 + 2.0 * sqrt(5.0))) * sideLength * sideLength
    }

    class Builder : GeometricFigure.Builder() {
        var sideLength: Double? = null

        fun sideLength(sideLength: Double) = apply { this.sideLength = sideLength }

        override fun build(): Pentagon {
            return Pentagon(this)
        }
    }
}