package homework

import kotlin.system.measureTimeMillis

fun main() {
    val iterationCount = 10_000_000

    // --- Вспомогательные функции для замеров времени выполнения ---
    val smallFunctionTime = measureTimeMillis {
        var resultSum = 0
        for (i in 0 until iterationCount) {
            resultSum += executeOperation(i, 1) { a, b -> a + b }
        }
    }

    val inlineSmallFunctionTime = measureTimeMillis {
        var resultSum = 0
        for (i in 0 until iterationCount) {
            resultSum += inlineExecuteOperation(i, 1) { a, b -> a + b }
        }
    }


    val bigFunctionTime = measureTimeMillis {
        var resultTotal = 0
        for (i in 0 until iterationCount) {
            resultTotal += performComplexCalculation(i)
        }
    }

    val inlineBigFunctionTime = measureTimeMillis {
        var resultTotal = 0
        for (i in 0 until iterationCount) {
            resultTotal += inlinePerformComplexCalculation(i)
        }
    }
    println("Используйте `inline` только там, где это оправданно:\nдля маленьких, часто вызываемых функций с лямбдами.\nНе злоупотребляйте — избыточное использование может раздувать байткод и усложнять оптимизацию.")
}

/**
 * Маленькая функция высшего порядка (без inline).
 * Выполняет переданную лямбду operation над двумя числами.
 */
fun executeOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

/**
 * Маленькая inline функция высшего порядка.
 * Выполняет переданную лямбду operation над двумя числами.
 */
inline fun inlineExecuteOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

/**
 * "Большая" функция без inline.
 * Выполняет сложные вычисления с использованием массива и циклов.
 */
fun performComplexCalculation(value: Int): Int {
    var accumulator = value
    val factors = IntArray(10) { it * accumulator }
    for (i in factors.indices) {
        accumulator += (factors[i] + i) * 3 - (accumulator % 5)
        if (accumulator % 7 == 0) {
            accumulator -= i
        }
    }
    return if (accumulator % 2 == 0) {
        accumulator / 2
    } else {
        accumulator * 2
    }
}

/**
 * "Большая" inline функция.
 * Выполняет сложные вычисления с использованием массива и циклов.
 */
inline fun inlinePerformComplexCalculation(value: Int): Int {
    var accumulator = value
    val factors = IntArray(10) { it * accumulator }
    for (i in factors.indices) {
        accumulator += (factors[i] + i) * 3 - (accumulator % 5)
        if (accumulator % 7 == 0) {
            accumulator -= i
        }
    }
    return if (accumulator % 2 == 0) {
        accumulator / 2
    } else {
        accumulator * 2
    }
}