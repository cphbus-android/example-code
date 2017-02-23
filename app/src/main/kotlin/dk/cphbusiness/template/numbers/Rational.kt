package dk.cphbusiness.template.numbers

data class Rational(val n: Int, val d: Int) {

    val gcd: Int by lazy {
        // println(" calculating gcd")
        gcd(n, d)
        }

//    private fun gcd(a: Int, b: Int) : Int {
//        if (b == 0) return a
//        else return gcd(b, a%b)
//        }

    private fun gcd(a: Int, b: Int) : Int =
        if (b == 0) a
        else gcd(b, a%b)

    val text: String
        get() = "${n/gcd}/${d/gcd}"


    operator fun times(other: Rational) =
            Rational(
                    this.n*other.n,
                    this.d*other.d
                    )
    operator fun div(other: Rational) =
            Rational(
                    this.n*other.d,
                    other.n*this.d
                    )
    operator fun plus(other: Rational) =
            Rational(
                    this.n*other.d + other.n*this.d,
                    this.d*other.d
                    )
    operator fun minus(other: Rational) =
            Rational(
                    this.n*other.d - other.n*this.d,
                    this.d*other.d
                    )
    // operator fun times(i: Int) = this*Rational(i, 1)
    operator fun times(i: Int) = Rational(i*n, d)
    }

operator fun Int.times(r: Rational) = Rational(this*r.n, r.d)

val Int.rational: Rational
    get() = Rational(this, 1)

fun main(args: Array<String>) {
    val a = Rational(8, 7)
    val b = Rational(56, 4)
    val c = Rational(13, 38)

    val r = a + b*c
    val q = b*b/a - c

    val pi = Rational(355, 113)
    val dpi = 2*pi

    println("4711 as ratinal ${4711.rational}")

    println("$r and $q")

    println("The gcd of $q is ${q.gcd} and it stays as ${q.gcd}")


    }