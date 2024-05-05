package objects

abstract class GeometricFigure protected constructor(builder: Builder) {
    protected val description: String = builder.description ?: ""

    abstract fun calculateArea(): Double

    class Builder {
        var description: String? = null

        fun description(description: String?) = apply { this.description = description }

        fun build(): GeometricFigure {
            return object : GeometricFigure(this) {
                override fun calculateArea(): Double {
                    return 0.0
                }
            }
        }
    }
}