package progscala2.rounding

object TryCatch {

    /**
     * Usage : Scala rounding. Try Catch filename1 filename2 ...
     */

     def main(args: Array[String]) = {
        args foreach (arg => countLines(arg))
     }

     import scala.io.Source
     import scala.util.control.NonFatal

     def countLines(fileName: String) = {
        println()
        val source: Option[Source] = None
        try {
            source = Some(Source.fromFile(fileName))
            val size = source get getLines size
            println(s"file $fileName has $size lines")
        } catch {
            case NonFatal(ex) => println(s"Non Fatal exception! $ex")
        } finally {
            for (s <- source) {
                println(s"Closing $fileName...")
                s.close()
            }
        }
     }
}