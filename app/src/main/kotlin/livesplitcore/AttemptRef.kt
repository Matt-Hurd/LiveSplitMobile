package livesplitcore

open class AttemptRef internal constructor(var ptr: Long) {
    fun index(): Int {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Attempt_index(ptr)
        return result
    }

    fun time(): TimeRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeRef(LiveSplitCoreNative.Attempt_time(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}