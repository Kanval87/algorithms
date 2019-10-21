package sorting.kotlinCode

import java.util.*

fun main() {
    val arrays: Array<IntArray> = arrayOf(
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(7, 2, 3, 8, 5, 6),
            intArrayOf(9, 4, 2, 4, 5, 6),
            intArrayOf(11, 12, 63, 74, 51, 62),
            intArrayOf(3, 2, 1, 4, 5, 6),
            intArrayOf(7, 2, 8, 10, 5, 6)
    )

    val inputArray = arrays[Random().nextInt(arrays.size)]
    println("""Enter 1 for Insertion Sort
Enter 2 for Selection Sort
Enter 3 for Merge Sort
Please enter your choice ->""")

    var selection = 4
    var sortedArray = inputArray
    while (selection !in 1..3) {
        // val input = Scanner(System.`in`)
        val (input) = readLine().toString().split(' ')
        selection = input.toInt()
        println("Input array -> " + Arrays.toString(inputArray))
        when (selection) {
            1 -> {
                sortedArray = insertionSort(inputArray)
            }
            2 -> {
                sortedArray = selectionSort(inputArray)
            }
            3 -> {
                sortedArray = mergeSort(0, inputArray.size - 1, inputArray)
            }
            else -> println("Please enter number from 1 to 3")
        }
    }
    println("Sorted input array -> " + Arrays.toString(sortedArray))
}

fun insertionSort(array: IntArray): IntArray {
    for (index in array.indices) {
        when (index) {
            0 -> print("---------------------------\n")
            else -> {
                var key = array[index]
                var i = index - 1
                while (i > -1 && key > array[i]) { // key ">" array[i]
                    // > to sort in decending order we can switch it to < for ascending order
                    array[i + 1] = array[i]
                    i -= 1
                }
                array[i + 1] = key
            }
        }
    }
    return array
}

fun selectionSort(array: IntArray): IntArray {
    for (index in array.indices) {
        println("$index -> ${array[index]}")
        var variableA = array[index]
        var variableB: Int
        var i = index + 1
        for (indexA in i..array.size) {
            if (variableA < array[indexA - 1]) {
                variableB = variableA
                variableA = array[indexA - 1]
                array[indexA - 1] = variableB
            }
        }
        array[index] = variableA
    }
    return array
}

fun mergeSort(p: Int, r: Int, array: IntArray): IntArray {
    if ((r - p) > 1) {
        var q = ((r - p) / 2) + p
        mergeSort(p, q, array)
        mergeSort(q + 1, r, array)
        merge(p, q, r, array)
    }
    return array
}

fun merge(p: Int, q: Int, r: Int, array: IntArray): IntArray {
    var arrayLeft: IntArray = array.sliceArray(p..q)
    var arrayRight: IntArray = array.sliceArray((q + 1)..r)
    var localP = 0
    var localQ = 0
    for (index in p..r) {
        if (localQ >= arrayRight.size || (localP < arrayLeft.size && arrayLeft[localP] > arrayRight[localQ])) {
            array[index] = arrayLeft[localP]
            localP += 1
        } else if ( localP >= arrayLeft.size || localQ < arrayRight.size) {
            array[index] = arrayRight[localQ]
            localQ += 1
        }
    }
    return array
}

