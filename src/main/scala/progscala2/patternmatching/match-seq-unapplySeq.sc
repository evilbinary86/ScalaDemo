val nonEmptyList = List(1, 2, 3, 4, 5)
val nonEmptyList2 = List(1, 2, 3)
val emptyList = Nil
val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)

def windows[T](seq: Seq[T]): String = seq match {
    case Seq(head1, head2, _*) => s"case_1 ($head1, $head2), " + windows(seq.tail)
    case Seq(head, _*) => s"case_2 $head, _" + windows(seq.tail)
    case Nil => "Nil"
}

for (seq <- Seq(nonEmptyList, nonEmptyList2, emptyList, nonEmptyMap.toSeq)) println(windows(seq))