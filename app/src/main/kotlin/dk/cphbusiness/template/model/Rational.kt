package dk.cphbusiness.template.model

data class Rational(val n: Int, val d: Int) {
    operator fun times(other: Rational) =
            Rational(this.n*other.n, this.d*other.d)
    val gcd: Int by lazy { gcd(n, d) }

    private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a%b)

    }

fun main(arguments: Array<String>) {
    println(Rational(355, 113))
    val a = Rational(22, 7)
    val b = Rational(14, 3)
    val c = a*b
    println(c)
    println(c.gcd)
    }