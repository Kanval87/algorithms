package kotlinCode

import kotlin.text.*
import java.util.Arrays
import java.util.Scanner

fun main() {
    val inputArray = arrayOf(1, 2, 3, 4, 5, 6)
    println("""Enter 1 for Insertion Sort
Enter 2 for Selection Sort
Enter 3 for Merge Sort
Please enter your choice ->""")

    var selection = 4
    var sortedArray = inputArray
    while(!(selection > 0 && selection < 4)){
        //val input = Scanner(System.`in`)
        val (input) = readLine().toString().split(' ')
        selection = input.toInt()
        when(selection){
            1 -> {
                println("Insertion sort input array -> " + Arrays.toString(inputArray))
                sortedArray = insertionSort(inputArray)
            }
            else -> println("Please enter number from 1 to 3")
        }
    }
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
