package util

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.PrintWriter

class Problem(level: Int = newest(), part: Int) {
    companion object {
        fun newest(prefix: String = "level"): Int {
            return File(".").listFiles(File::isDirectory)!!
                .map { it.name }
                .filter { it.contains(prefix) }
                .maxOf { it.split(prefix)[1].toInt() }
        }

        fun allFromLevel(level: Int = newest(), parts: Int = 5): List<Problem> {
            return (0..parts).map { Problem(level, it) }
        }
    }

    val input: List<String>
    val out: PrintWriter
    
    init {
        val folder = "level$level"
        val filePrefix = "level${level}_${if (part == 0) "example" else part}"

        val reader = BufferedReader(FileReader("$folder/$filePrefix.in"))
        input = reader.readLines()
        reader.close()
        
        out = PrintWriter("$folder/out/$filePrefix.out")
    }
}