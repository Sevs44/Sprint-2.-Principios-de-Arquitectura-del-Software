package objects

import kotlin.math.PI

class Circle private constructor(builder: Builder) : GeometricFigure(builder) {

    private val radius: Double = builder.radius ?: 0.0

    override fun calculateArea(): Double {
        return PI * radius * radius
    }

    class Builder : GeometricFigure.Builder() {
        var radius: Double? = null

        fun radius(radius: Double) = apply { this.radius = radius }

        override fun build(): Circle {
            return Circle(this)
        }
    }
}