package util

fun Map<String, Int>.orderDescendingByValue(): Map<String, Int> {
    return this.toList().sortedByDescending { it.second }.toMap()
}