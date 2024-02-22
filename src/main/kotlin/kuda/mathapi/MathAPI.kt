package kuda.mathapi

class MathAPI {
    companion object{

        /**
         * Calculate the arc cosine of the input argument.
         */
        @JvmStatic
        external fun acos(x : Double) : Double

        /**
         * Calculate the nonnegative inverse hyperbolic cosine of the input argument.
         */
        @JvmStatic
        external fun acosh(x : Double) : Double

        /**
         * Calculate the arc sine of the input argument.
         */
        @JvmStatic
        external fun asin(x : Double) : Double


        /**
         * Calculate the inverse hyperbolic sine of the input argument.
         */
        @JvmStatic
        external fun asinh(x : Double) : Double

        /**
         * Calculate the arc tangent of the input argument.
         */
        @JvmStatic
        external fun atan(x : Double) : Double

        /**
         * Calculate the arc tangent of the ratio of first and second input arguments.
         */
        @JvmStatic
        external fun atan2(y : Double, x : Double) : Double

        /**
         * Calculate the inverse hyperbolic tangent of the input argument.
         */
        @JvmStatic
        external fun atanh(x: Double): Double

        /**
         * Calculate the cube root of the input argument.
         */
        @JvmStatic
        external fun cbrt(x: Double): Double

        /**
         * Calculate ceiling of the input argument.
         */
        @JvmStatic
        external fun ceil(x: Double): Double

        /**
         * Create value with given magnitude, copying sign of second value.
         */
        @JvmStatic
        external fun copysign(x: Double, y: Double): Double

        /**
         * Calculate the cosine of the input argument.
         */
        @JvmStatic
        external fun cos(x: Double): Double

        /**
         * Calculate the hyperbolic cosine of the input argument.
         */
        @JvmStatic
        external fun cosh(x: Double): Double

        /**
         * Calculate the cosine of the input argument * pi.
         */
        @JvmStatic
        external fun cospi(x: Double): Double

        /**
         *	Calculate the error function of the input argument.
         */
        @JvmStatic
        external fun erf(x: Double): Double

        /**
         * Calculate the complementary error function of the input argument.
         */
        @JvmStatic
        external fun erfc(x: Double): Double

        /**
         * Calculate the inverse complementary error function of the input argument.
         */
        @JvmStatic
        external fun erfcinv(x: Double): Double

        /**
         * Calculate the scaled complementary error function of the input argument.
         */
        @JvmStatic
        external fun erfcx(x: Double): Double

        /**
         * Calculate the inverse error function of the input argument.
         */
        @JvmStatic
        external fun erfinv(x: Double): Double

        /**
         * Calculate the base exponential of the input argument.
         */
        @JvmStatic
        external fun exp(x: Double): Double

        /**
         * Calculate the base 10 exponential of the input argument.
         */
        @JvmStatic
        external fun exp10(x: Double): Double

        /**
         * Calculate the base 2 exponential of the input argument.
         */
        @JvmStatic
        external fun exp2(x: Double): Double

        /**
         * Calculate the base exponential of the input argument, minus 1.
         */
        @JvmStatic
        external fun expm1(x: Double): Double

        /**
         * Calculate the absolute value of the input argument.
         */
        @JvmStatic
        external fun fabs(x: Double): Double

        /**
         * Compute the positive difference between x and y.
         */
        @JvmStatic
        external fun fdim(x: Double, y: Double): Double

        /**
         * Calculate the largest integer less than or equal to x.
         */
        @JvmStatic
        external fun floor(x: Double): Double

        /**
         * Compute x * y + z as a single operation.
         */
        @JvmStatic
        external fun fma(x: Double, y: Double, z: Double): Double

        /**
         * Determine the maximum numeric value of the arguments.
         */
        @JvmStatic
        external fun fmax(x: Double, y: Double): Double

        /**
         * Determine the minimum numeric value of the arguments.
         */
        @JvmStatic
        external fun fmin(x: Double, y: Double): Double

        /**
         * Calculate the double-precision floating-point remainder of x / y.
         */
        @JvmStatic
        external fun fmod(x: Double, y: Double): Double

        /**
         * Calculate the base logarithm of the input argument x
         */
        @JvmStatic
        external fun log(x : Double) : Double

        private var isLibraryLoaded = false

        init {
            loadLibraryIfNotLoaded()
        }

        @Synchronized
        private fun loadLibraryIfNotLoaded() {
            if (!isLibraryLoaded) {
                System.loadLibrary("kudadll")
                isLibraryLoaded = true
            }
        }
    }
}