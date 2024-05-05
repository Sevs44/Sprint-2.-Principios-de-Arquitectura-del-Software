package objects

class Pentagon private constructor(builder: Builder) : GeometricFigure(builder) {

    private var side: Double = builder.side ?: 0.0
    private var height: Double = builder.height ?: 0.0

    override fun calculateArea(): Double {
        return (5 * side * height) / 2
    }

    fun setSide(side: Double) = apply { this.data1 = side }
    fun setHeight(height: Double) = apply { this.data1 = height }

    class Builder : GeometricFigure.Builder() {
        var side: Double? = null
        var height: Double? = null

        fun side(side: Double) = apply { this.side = side }
        fun height(height: Double) = apply { this.height = height }

        override fun build(): Pentagon {
            return Pentagon(this)
        }
    }
}