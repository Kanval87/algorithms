package sorting.kotlinCode

import java.util.*

class SearchingAlgorithm {
    private var sortingCode = SortingCode()
    fun run() {
        var numToSearch: Int = /*Random().nextInt(7)*/ 2
        var arrayToSearchIn = sortingCode.getSortedArray().clone()

        for ((index, value) in arrayToSearchIn.withIndex()) {
            var arrayToSearchIn = sortingCode.getSortedArray().clone()
            var result = binarySearchWithIndex(value, arrayToSearchIn, 0, false)
//            var result = binarySearch(value, arrayToSearchIn, 0, false)
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

    private fun binarySearch() : ResultAndIndex{
        return ResultAndIndex( true , 0)
    }

    private fun binarySearchWithIndex(numToSearch: Int, sortedArray: IntArray, midNumberParam: Int, isFromRight: Boolean): ResultAndIndex {
        println("Checking $numToSearch with indexTrack $midNumberParam in ${sortedArray.contentToString()} coming from Right -> $isFromRight")
        if (sortedArray.isNotEmpty()) {
            var midIndex: Int
            if (sortedArray.size % 2 == 0) {
                midIndex = (sortedArray.size / 2) - 1
                if (sortedArray.size > 2) {
                    when {
                        sortedArray[midIndex] <= numToSearch -> {
                            var slicedArray = sortedArray.sliceArray(0 until midIndex + 1)
//                            return binarySearch(numToSearch, slicedArray, midNumberParam, false)
                            return binarySearchWithIndex(numToSearch, slicedArray, midNumberParam, false)
                        }
                        sortedArray[midIndex + 1] >= numToSearch -> {
                            var slicedArray = sortedArray.sliceArray(midIndex + 1 until sortedArray.size)
                            if (isFromRight)
                                return binarySearchWithIndex(numToSearch, slicedArray, midNumberParam + midIndex, true)
                            else
                                return binarySearchWithIndex(numToSearch, slicedArray, midNumberParam + midIndex + 1, true)
                        }
                    }
                } else {
                    var valueToAdd = 0
                    if (isFromRight) {
                        valueToAdd = 1
                    }
                    when {
                        sortedArray[midIndex] == numToSearch -> {
                            return ResultAndIndex(true, midNumberParam + midIndex)
                        }
                        sortedArray[midIndex + 1] == numToSearch -> {
                            return ResultAndIndex(true, midNumberParam + midIndex + valueToAdd + 1)
                        }
                    }
                }
            } else {
                midIndex = sortedArray.size / 2
                when {
                    sortedArray[midIndex] == numToSearch -> return ResultAndIndex(true, midNumberParam + midIndex)
                    sortedArray[midIndex] <= numToSearch -> return binarySearchWithIndex(numToSearch, sortedArray.sliceArray(0 until midIndex), midNumberParam, false)
                    sortedArray[midIndex] >= numToSearch -> return binarySearchWithIndex(numToSearch, sortedArray.sliceArray(midIndex + 1 until sortedArray.size), midNumberParam + midIndex, true)
                }
            }
        }
        return ResultAndIndex(false, 0)
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
