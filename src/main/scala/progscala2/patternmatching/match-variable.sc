for {
    x <- Seq(1, 2, 2.7, "one", "two", 'four)
} {
    val str = x match {
        case 1 => "int 1"
        case i: Int => s"other int : $i"
        case d: Double => s"a double: $x"
        case "one" => "string one"
        case s: String => s"other string: $s"
        case unexpected => s"unexpected value: $unexpected"

    }
    println(str)
}
println("--------------------------------------------------")

for {
    x <- Seq(1, 2, 2.7, "one", "two", 'for)
} {
    val str = x match {
        case 1 => "int 1"
        case _: Int => s"other int: $x"
        case _: Double => s"a double: $x"
        case "one" => s"string one"
        case _: String => s"other string $x"
        case _ => s"unexpected value: $x"
    }
    println(str)
}
println("--------------------------------------------------")
for {
    x <- Seq(1, 2, 2.7, "one", "two", 'four)
} {
    val str = x match {
        case _: Int | _: Double => s"a number: $x"
        case "one" => "string one"
        case _: String => s"other string: $x"
        case _ => s"unexpected value: $x"
    }
    println(str)
}
println("--------------------------------------------------")
