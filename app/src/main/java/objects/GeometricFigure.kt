package objects


abstract class GeometricFigure protected constructor(builder: Builder) {
    protected val description: String = builder.description ?: ""
    protected var data1: Double? = builder.data1
    protected val data2: Double? = builder.data2

    abstract fun calculateArea(): Double

    abstract class Builder {
        var description: String? = null
        var data1: Double? = null
        var data2: Double? = null

        fun description(description: String?) = apply { this.description = description }
        fun data1(data1: Double?) = apply { this.data1 = data1 }
        fun data2(data2: Double?) = apply { this.data2 = data2 }

        abstract fun build(): GeometricFigure
    }
}