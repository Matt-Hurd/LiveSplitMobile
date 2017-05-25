package livesplitcore.util

import livesplitcore.TimerRef

fun <String> stateAsJsonHelper(timer: TimerRef, ptr: Long, func: (self: Long, timer: Long) -> String): String {
    if (ptr.equals(0) || timer.ptr.equals(0))
        throw RuntimeException()

    return func(ptr, timer.ptr)
}