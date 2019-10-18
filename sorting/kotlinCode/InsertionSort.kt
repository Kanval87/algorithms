package kotlinCode

import kotlin.text.*
import java.util.Arrays

fun main() {
    var inputArray = arrayOf(1, 2, 3, 4, 5, 6)
    println("Insertion sort input array -> " + Arrays.toString(inputArray))
    var sortedArray = insertionSort(inputArray)
    println("sorted input array -> " + Arrays.toString(sortedArray))
}

fun insertionSort(array : Array<Int>): Array<Int> {
    for(index in array.indices){
        when(index){
            0 -> print("Skipping\n")
            else -> {
                var key = array[index]
                var i = index - 1
                while(i > -1 && key > array[i]){
                    array[i + 1] = array[i]
                    i = i - 1
                }
                array[i + 1] = key
            }
        }
    }
    return array
}
