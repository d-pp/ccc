import util.Problem
import java.io.PrintWriter

fun main() {
    val test = false
    
    if (test) {
        run(Problem(part = 0))
        return
    }
    
    Problem.allFromLevel().forEach {
        run(it)
    }
}

fun run(problem: Problem) {
    run(problem.input, problem.out)
    problem.out.close()
}    

fun run(input: List<String>, output: PrintWriter) {
    println(input)
}