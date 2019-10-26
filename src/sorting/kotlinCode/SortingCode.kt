package sorting.kotlinCode

import java.util.*

class SortingCode {

    private val arrays: Array<IntArray> = arrayOf(
            intArrayOf(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6),
            intArrayOf(7, 2, 4, 3, 1),
            intArrayOf(9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6, 9, 4, 2, 4, 5, 6),
            intArrayOf(11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62, 11, 12, 63, 74, 51, 62),
            intArrayOf(3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6, 3, 2, 1, 4, 5, 6),
            intArrayOf(7, 2, 8, 10, 5, 6, 7, 2, 8, 10, 5, 6, 7, 2, 8, 10, 5, 6, 7, 2, 8, 10, 5, 6, 7, 2, 8, 10, 5, 7, 2, 8, 10, 5, 6, 7, 2, 8, 10, 5, 6, 7, 2, 8, 10, 5, 6, 7, 2, 8, 10, 5, 6, 7, 2, 8, 10, 5, 6)
    )
    var selectionLimit = 5

    public fun run() {
        var selection = -1
        println("""
Enter 1 for Insertion Sort
Enter 2 for Selection Sort
Enter 3 for Merge Sort
Enter 4 for Progressive insertion sort
Enter 5 for Recursive insertion sort
Enter 9 to Exit
Please enter your choice ->
    """)

        while (selection != 9) {
//        val inputArray = arrays[3].clone()
            val inputArray = arrays[Random().nextInt(arrays.size)].clone()
            var sortedArray = inputArray
            val (input) = readLine().toString().split(' ')
            selection = input.toInt()
            println("Input array to Sort-> " + inputArray.contentToString())
            var currentTime = System.nanoTime()
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
                4 -> {
                    sortedArray = (progressiveInsertion(LinkedList<Int>(inputArray.toList())))
                }
                5 -> {
                    sortedArray = (insertionRecursiveSort(LinkedList<Int>(inputArray.toList()))).toIntArray()
                }
                9 -> {
                    println("Entered 9 to Exit")
                    return
                }
                else -> println("Please enter number from 1 to $selectionLimit to  perform sorting")
            }
            println("Time took -> " + (System.nanoTime() - currentTime))
            println("Sorted input array -> " + sortedArray.contentToString())
        }
    }


    fun insertionSort(array: IntArray): IntArray {
        for (index in array.indices) {
            when (index) {
                0 -> print("\n")
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

    fun insertionRecursiveSort(array: LinkedList<Int>): LinkedList<Int> {
        if (array.size == 2) {
            val valueToInsert = array.removeFirst()
            if (array[0] > valueToInsert) {
                array.addLast(valueToInsert)
            } else {
                array.addFirst(valueToInsert)
            }
            return array
        } else {
            val valueToInsert: Int = array.removeFirst()
            insertionRecursiveSort(array)
            var hasValueAdded = false
            for ((index, value) in array.withIndex()) {
                if (value < valueToInsert) {
                    array.add(index, valueToInsert)
                    hasValueAdded = true;
                    break
                }
            }
            if (!hasValueAdded) {
                array.addLast(valueToInsert)
            }
            return array
        }
    }

    fun progressiveInsertion(array: LinkedList<Int>): IntArray {
        var list: LinkedList<Int> = LinkedList()
        for (index in 0 until array.size) {
            var elementToAdd: Int = array[(array.size - (index + 1))]
            progressiveInsertionSort(elementToAdd, list)
            // println(" $elementToAdd | $list ")
        }
        return list.toIntArray()
    }

    private fun progressiveInsertionSort(elementToAdd: Int, list: LinkedList<Int>): LinkedList<Int> {
        if (list.size == 0) {
            list.add(elementToAdd)
        } else {
            for (index in list.indices) {
                if (list[index] < elementToAdd) { // < for descending and > for ascending
                    list.add(index, elementToAdd)
                    return list
                }
            }
            list.addLast(elementToAdd)
        }
        return list
    }

    fun selectionSort(array: IntArray): IntArray {
        for (index in array.indices) {
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
        if ((r - p) > 0) {
            var q = ((r - p) / 2) + p
            mergeSort(p, q, array)
            mergeSort(q + 1, r, array)
            merge(p, q, r, array)
        }
        return array
    }

    private fun merge(p: Int, q: Int, r: Int, array: IntArray): IntArray {
        var arrayLeft: IntArray = array.sliceArray(p..q)
        var arrayRight: IntArray = array.sliceArray((q + 1)..r)
        var localP = 0
        var localQ = 0
        for (index in p..r) {
            if (localQ >= arrayRight.size || (localP < arrayLeft.size && arrayLeft[localP] > arrayRight[localQ])) {
                array[index] = arrayLeft[localP]
                localP += 1
            } else if (localP >= arrayLeft.size || localQ < arrayRight.size) {
                array[index] = arrayRight[localQ]
                localQ += 1
            }
        }
        return array
    }

    fun getSortedArray(): IntArray {
        var unsortedArray = arrays[Random().nextInt(arrays.size)].clone()
//        var unsortedArray = arrays[2].clone()
        return (insertionRecursiveSort(LinkedList(unsortedArray.toList()))).toIntArray()
    }
}

fun main() {
    var sortingCode = SortingCode()
    sortingCode.run()
}


