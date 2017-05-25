package livesplitcore

open class SplitsComponentStateRef internal constructor(internal var ptr: Long) {
    fun finalSeparatorShown(): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SplitsComponentState_finalSeparatorShown(ptr)
        return result
    }

    fun len(): Long {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SplitsComponentState_len(ptr)
        return result
    }

    fun iconChange(index: Long): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SplitsComponentState_iconChange(ptr, index)
        return result
    }

    fun name(index: Long): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SplitsComponentState_name(ptr, index)
        return result
    }

    fun delta(index: Long): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SplitsComponentState_delta(ptr, index)
        return result
    }

    fun time(index: Long): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SplitsComponentState_time(ptr, index)
        return result
    }

    fun color(index: Long): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SplitsComponentState_color(ptr, index)
        return result
    }

    fun isCurrentSplit(index: Long): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .SplitsComponentState_isCurrentSplit(ptr, index)
        return result
    }
}