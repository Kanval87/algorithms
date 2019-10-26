package sorting.kotlinCode

import java.util.*

class SearchingAlgorithm {
    private var sortingCode = SortingCode()
    fun run() {
        var numToSearch: Int = /*Random().nextInt(7)*/ 2
        var arrayToSearchIn = sortingCode.getSortedArray()
        var result = binarySearch(numToSearch, arrayToSearchIn, 0)
        if (!result.hasFoundNum) {
            println("could not find $numToSearch in ${arrayToSearchIn.contentToString()}")
        } else {
            println("found $numToSearch at ${result.numberFoundAt} in ${arrayToSearchIn.contentToString()}")
        }
    }

    private fun binarySearch(numToSearch: Int, sortedArray: IntArray, midNumberParam: Int): ResultAndIndex {
        println("Checking $numToSearch in ${sortedArray.contentToString()}")
        if (sortedArray.isNotEmpty()) {
            var midIndex = sortedArray.size / 2
            var midNum = sortedArray[midIndex]
            when {
                midNum > numToSearch -> return binarySearch(numToSearch, sortedArray.sliceArray((midIndex + 1) until sortedArray.size), midNumberParam + midIndex)
                midNum == numToSearch -> return ResultAndIndex(true, midNumberParam + midIndex)
                else -> return binarySearch(numToSearch, sortedArray.sliceArray(0 until midIndex), midNumberParam)
            }
        } else {
            return ResultAndIndex(false, 0)
        }
    }

    /*  Supporting classes  */

    class ResultAndIndex {
        var hasFoundNum: Boolean = false
        var numberFoundAt: Int = -1

        constructor(hasFound: Boolean, atIndex: Int) {
            hasFoundNum = hasFound
            numberFoundAt = atIndex
        }
    }
}

fun main() {
    var searchingAlgorithm = SearchingAlgorithm()
    searchingAlgorithm.run()
}
