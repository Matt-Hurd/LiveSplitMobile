package livesplitcore

open class SharedTimerRef internal constructor(internal var ptr: Long) {
    fun share(): SharedTimer? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = SharedTimer(LiveSplitCoreNative.SharedTimer_share(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun read(): TimerReadLock? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimerReadLock(LiveSplitCoreNative.SharedTimer_read(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun write(): TimerWriteLock? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimerWriteLock(LiveSplitCoreNative.SharedTimer_write(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun readWith(action: java.util.function.Consumer<TimerRef>) {
        read()!!.use { timerLock ->
            when (timerLock.timer() == null) {
                true -> throw IllegalArgumentException("yell at Abahbob")
                false -> action.accept(timerLock.timer()!!)
            }
        }
    }

    fun writeWith(action: java.util.function.Consumer<TimerRefMut>) {
        write()!!.use { timerLock ->
            when (timerLock.timer() == null) {
                true -> throw IllegalArgumentException("yell at Abahbob")
                false -> action.accept(timerLock.timer()!!)
            }
        }
    }
}