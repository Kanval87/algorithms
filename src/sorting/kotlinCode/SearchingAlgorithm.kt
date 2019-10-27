package sorting.kotlinCode

import java.util.*

class SearchingAlgorithm {
    private var sortingCode = SortingCode()
    fun run() {
        var numToSearch: Int = /*Random().nextInt(7)*/ 4
        var arrayToSearchIn = sortingCode.getSortedArray().clone()
        for ((index, value) in arrayToSearchIn.withIndex()) {
            var arrayToSearchIn = sortingCode.getSortedArray().clone()
            var result = binarySearch(value, arrayToSearchIn, 0, false)
            if (!result.hasFoundNum) {
                println("could not find $value in ${arrayToSearchIn.contentToString()}")
            } else {
                println("found $value at ${result.numberFoundAt} in ${arrayToSearchIn.contentToString()}")
            }
        }
//        var result = binarySearch(numToSearch, arrayToSearchIn, 0, false)
//        if (!result.hasFoundNum) {
//            println("could not find $numToSearch in ${arrayToSearchIn.contentToString()}")
//        } else {
//            println("found $numToSearch at ${result.numberFoundAt} in ${arrayToSearchIn.contentToString()}")
//        }
    }

    private fun binarySearch(numToSearch: Int, sortedArray: IntArray, midNumberParam: Int, isFromRight: Boolean): ResultAndIndex {
        println("Checking $numToSearch with indexTrack $midNumberParam in ${sortedArray.contentToString()} coming from Right -> $isFromRight")
        if (sortedArray.isNotEmpty()) {
            var midIndex = sortedArray.size / 2
            var midNum = sortedArray[midIndex]
            when {
                midNum > numToSearch -> return binarySearch(numToSearch, sortedArray.sliceArray((midIndex + 1) until sortedArray.size), midNumberParam + midIndex, true)
                midNum == numToSearch -> /*return ResultAndIndex(true, midNumberParam + midIndex)*/
                                        if (isFromRight) {
                                            return ResultAndIndex(true, midNumberParam + midIndex + 1)
                                        } else {
                                            return ResultAndIndex(true, midNumberParam + midIndex)
                                        }
                else -> return binarySearch(numToSearch, sortedArray.sliceArray(0 until midIndex), midNumberParam, false)
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
