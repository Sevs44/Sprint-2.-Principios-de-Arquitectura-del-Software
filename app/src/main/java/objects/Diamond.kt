package objects

class Diamond private constructor(builder: Builder) : GeometricFigure(builder) {

    private val diagonal1: Double = builder.diagonal1 ?: 0.0
    private val diagonal2: Double = builder.diagonal2 ?: 0.0

    override fun calculateArea(): Double {
        return (diagonal1 * diagonal2) / 2.0
    }

    class Builder : GeometricFigure.Builder() {
        var diagonal1: Double? = null
        var diagonal2: Double? = null

        fun diagonal1(diagonal1: Double) = apply { this.diagonal1 = diagonal1 }
        fun diagonal2(diagonal2: Double) = apply { this.diagonal2 = diagonal2 }

        override fun build(): Diamond {
            return Diamond(this)
        }
    }
}