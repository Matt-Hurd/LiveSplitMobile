package livesplitcore

open class RunRefMut internal constructor(ptr: Long) : RunRef(ptr) {
    fun pushSegment(segment: Segment) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (segment.ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Run_pushSegment(ptr, segment.ptr)
        segment.ptr = 0
    }

    fun setGameName(game: String) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Run_setGameName(ptr, game)
    }

    fun setCategoryName(category: String) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Run_setCategoryName(ptr, category)
    }
}