for {
    x <- Seq(List(5.5, 5.6, 5.7), List("a", "b"))
} x match {
    case Nil => println("Nil")
    case head +: _ => head match {
        case _: Double => println("Double")
        case _: String => println("String")
        case _ => "Unmatched seq element"
    }
}

println("-------------")

def deSeqMatch[T](seq: Seq[T]): String = seq match {
    case Nil => "Nil"
    case head +: _ => head match {
        case _: Double => "Double"
        case _: String => "String"
        case _ => "Unmatced seq element"
    }
}

for {
    x <- Seq(List(5.5, 5.6, 5.7), List("a", "b"), Nil)
} yield {
    x match {
        case seq: Seq[_] => (s"seq ${deSeqMatch(seq)}", seq)
        case _ => ("unknown!", x)
    }
}