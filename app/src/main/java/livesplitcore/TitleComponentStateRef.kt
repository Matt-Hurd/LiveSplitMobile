package livesplitcore

open class TitleComponentStateRef internal constructor(internal var ptr: Long) {
    fun iconChange(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TitleComponentState_iconChange(ptr)
        return result
    }

    fun game(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TitleComponentState_game(ptr)
        return result
    }

    fun category(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TitleComponentState_category(ptr)
        return result
    }

    fun attempts(): Int {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TitleComponentState_attempts(ptr)
        return result
    }
}