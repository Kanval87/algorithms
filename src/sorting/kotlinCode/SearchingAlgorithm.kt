package sorting.kotlinCode

class SearchingAlgorithm {
    private var sortingCode = SortingCode()
    fun run() {
        var numToSearch: Int = 4
        var arrayToSearchIn = sortingCode.getSortedArray()
        var foundAt = binarySearch(numToSearch, arrayToSearchIn)
        if (foundAt == -1) {
            println("could not find $numToSearch in ${arrayToSearchIn.contentToString()}")
        } else {
            println("found $numToSearch in ${arrayToSearchIn.contentToString()}")
        }
    }

    private fun binarySearch(numToSearch: Int, sortedArray: IntArray): Int {
        if (sortedArray.isNotEmpty()) {
            var midIndex = sortedArray.size / 2
            var midNum = sortedArray[midIndex]
            if (midNum > numToSearch) {
                return binarySearch(numToSearch, sortedArray.sliceArray((midIndex + 1) until sortedArray.size))
            } else if (midNum == numToSearch) {
                return 1
            } else {
                return binarySearch(numToSearch, sortedArray.sliceArray(0..midIndex))
            }
        } else {
            return -1
        }
    }
}

fun main() {
    var searchingAlgorithm = SearchingAlgorithm()
    searchingAlgorithm.run()
}
