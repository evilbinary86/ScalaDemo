object Bread extends Enumeration {
    type Bread = Value
    val doberman = Value("Doberman Pinscher")
    val yorkie = Value("Yorkshire Terrier")
    val scottie = Value("Scottish Terrier")
    val dane = Value("Great Dane")
    val portie = Value("Portuguese Water Dog")
}

import Bread._

println("ID\tBread")

for (bread <- Bread.values) println(s"${bread.id}\t$bread")

println("\nJust Terriers: ")

Bread.values filter (_.toString.endsWith("Terries")) foreach println

def isTerrier(b: Bread) = b.toString.endsWith("Terrier")

println("\nTerries Again?")

Bread.values filter isTerrier foreach println