package objects

import kotlin.math.PI

class Circle private constructor(builder: Builder) : GeometricFigure(builder) {

    private val radius: Double = builder.data1 ?: 0.0
    private val pi: Double = builder.data2 ?: PI

    override fun calculateArea(): Double {
        return pi * radius * radius
    }

    fun setRadius(radius: Double) = apply { this.data1 = radius }

    class Builder : GeometricFigure.Builder() {
        fun radius(radius: Double) = apply { this.data1 = radius }

        override fun build(): Circle {
            return Circle(this)
        }
    }

}