import java.io._

abstract class BulkReader {
    type In
    val source: In
    def read: String // 读进一个source, 返回一个String
}

class StringBulkReader(val source: String) extends BulkReader{
    type In = String
    def read: String = source
}

class FileBulkReader(val source: File) extends BulkReader {
    type In = File
    def read: String = {
        val in = new BufferedInputStream(new FileInputStream(source))
        val numBytes = in.available()
        val bytes = new Array[Byte](numBytes)
        in.read(bytes, 0, numBytes)
        new String(bytes)
    }
}

println(new StringBulkReader("Hello Scala").read)
println(new FileBulkReader(new File("E:\\work\\ScalaDemo\\src\\main\\scala\\progscala2\\typelessdomore\\abstract-types.sc")).read)