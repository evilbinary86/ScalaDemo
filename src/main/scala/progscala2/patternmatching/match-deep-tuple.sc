val itemsCosts = Seq(("Pencil", 0.52), ("Paper", 1.35), ("NoteBook", 2.43))
val itemsCostsIndices = itemsCosts.zipWithIndex
for (itemCostIndex <- itemsCostsIndices) itemCostIndex match {
    case ((item, cost), index) => println(s"$index: $item cost $cost each")
}