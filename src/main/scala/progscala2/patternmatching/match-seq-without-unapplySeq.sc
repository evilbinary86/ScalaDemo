val nonEmptyList = List(1, 2, 3, 4, 5)
val emptyList = Nil
val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)

def windows[T](seq: Seq[T]): String = seq match {
    case head1 +: head2 +: tail => s"($head1, $head2), " + windows(seq.tail)
    case head1 +: tail => s"($head1, _)" + windows(seq.tail)
    case Nil => "Nil"
}

for (seq <- Seq(nonEmptyList, emptyList, nonEmptyMap.toSeq)) println(windows(seq))