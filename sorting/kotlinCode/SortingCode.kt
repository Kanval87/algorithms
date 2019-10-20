package kotlinCode

import kotlin.text.*
import java.util.Random
import java.util.Arrays
import java.util.Scanner

fun main() {
    val arrays : Array<IntArray> = arrayOf(
        intArrayOf(1, 2, 3, 4, 5, 6),
        intArrayOf(7, 2, 3, 8, 5, 6),
        intArrayOf(9, 4, 2, 4, 5, 6),
        intArrayOf(11, 12, 63, 74, 51, 62),
        intArrayOf(3, 2, 1, 4, 5, 6),
        intArrayOf(7, 2, 8, 10, 5, 6)
    )
    
    val inputArray = arrays[2]
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
        println("Input array -> " + Arrays.toString(inputArray))
        when(selection){
            1 -> {
                sortedArray = insertionSort(inputArray)
            }
            2 -> {
                sortedArray = selectionSort(inputArray)
            }
            else -> println("Please enter number from 1 to 3")
        }
    }
    println("Sorted input array -> " + Arrays.toString(sortedArray))
}

fun insertionSort(array : Array<Int>): Array<Int> {
    for(index in array.indices){
        when(index){
            0 -> print("---------------------------\n")
            else -> {
                var key = array[index]
                var i = index - 1
                while(i > -1 && key > array[i]){ // key ">" array[i]
                    // > to sort in decending order we can switch it to < for ascending order
                    array[i + 1] = array[i]
                    i = i - 1
                }
                array[i + 1] = key
            }
        }
    }
    return array
}

fun selectionSort(array : Array<Int>) : Array<Int>{
    for(index in array.indices){
        println("${index} -> ${array[index]}" )
        var variableA = array[index]
        var variableB = array[index]
        var i = index + 1
        for(indexA in i .. array.size){
            if(variableA < array[indexA - 1]){
                variableB = variableA
                variableA = array[indexA - 1]
                array[indexA - 1] = variableB
            }
        }
        array[index] = variableA
    }
    return array
}