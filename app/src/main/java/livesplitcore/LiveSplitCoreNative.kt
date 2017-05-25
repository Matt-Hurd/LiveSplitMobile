package livesplitcore

object LiveSplitCoreNative {
    external fun Run_parseString(data: String): Long
    external fun Attempt_index(self: Long): Int
    external fun Attempt_time(self: Long): Long
    external fun HotkeySystem_new(sharedTimer: Long): Long
    external fun HotkeySystem_drop(self: Long)
    external fun PossibleTimeSaveComponent_new(): Long
    external fun PossibleTimeSaveComponent_drop(self: Long)
    external fun PossibleTimeSaveComponent_stateAsJson(self: Long, timer: Long): String
    external fun PossibleTimeSaveComponent_state(self: Long, timer: Long): Long
    external fun PossibleTimeSaveComponentState_drop(self: Long)
    external fun PossibleTimeSaveComponentState_text(self: Long): String
    external fun PossibleTimeSaveComponentState_time(self: Long): String
    external fun PreviousSegmentComponent_new(): Long
    external fun PreviousSegmentComponent_drop(self: Long)
    external fun PreviousSegmentComponent_stateAsJson(self: Long, timer: Long): String
    external fun PreviousSegmentComponent_state(self: Long, timer: Long): Long
    external fun PreviousSegmentComponentState_drop(self: Long)
    external fun PreviousSegmentComponentState_text(self: Long): String
    external fun PreviousSegmentComponentState_time(self: Long): String
    external fun Run_new(): Long
    external fun Run_parse(data: Long, length: Long): Long
    external fun Run_drop(self: Long)
    external fun Run_gameName(self: Long): String
    external fun Run_gameIcon(self: Long): String
    external fun Run_categoryName(self: Long): String
    external fun Run_extendedFileName(self: Long, useExtendedCategoryName: Boolean): String
    external fun Run_extendedName(self: Long, useExtendedCategoryName: Boolean): String
    external fun Run_extendedCategoryName(self: Long, showRegion: Boolean, showPlatform: Boolean, showVariables: Boolean): String
    external fun Run_attemptCount(self: Long): Int
    external fun Run_metadata(self: Long): Long
    external fun Run_offset(self: Long): Long
    external fun Run_len(self: Long): Long
    external fun Run_segment(self: Long, index: Long): Long
    external fun Run_attemptHistoryLen(self: Long): Long
    external fun Run_attemptHistoryIndex(self: Long, index: Long): Long
    external fun Run_saveAsLss(self: Long): String
    external fun Run_pushSegment(self: Long, segment: Long)
    external fun Run_setGameName(self: Long, game: String)
    external fun Run_setCategoryName(self: Long, category: String)
    external fun RunEditor_new(run: Long): Long
    external fun RunEditor_close(self: Long): Long
    external fun RunEditor_stateAsJson(self: Long): String
    external fun RunEditor_selectTimingMethod(self: Long, method: Byte)
    external fun RunEditor_unselect(self: Long, index: Long)
    external fun RunEditor_selectAdditionally(self: Long, index: Long)
    external fun RunEditor_selectOnly(self: Long, index: Long)
    external fun RunEditor_setGameName(self: Long, game: String)
    external fun RunEditor_setCategoryName(self: Long, category: String)
    external fun RunEditor_parseAndSetOffset(self: Long, offset: String): Boolean
    external fun RunEditor_parseAndSetAttemptCount(self: Long, attempts: String): Boolean
    external fun RunEditor_setGameIcon(self: Long, data: Long, length: Long)
    external fun RunEditor_insertSegmentAbove(self: Long)
    external fun RunEditor_insertSegmentBelow(self: Long)
    external fun RunEditor_removeSegments(self: Long)
    external fun RunEditor_moveSegmentsUp(self: Long)
    external fun RunEditor_moveSegmentsDown(self: Long)
    external fun RunEditor_selectedSetIcon(self: Long, data: Long, length: Long)
    external fun RunEditor_selectedSetName(self: Long, name: String)
    external fun RunEditor_selectedParseAndSetSplitTime(self: Long, time: String): Boolean
    external fun RunEditor_selectedParseAndSetSegmentTime(self: Long, time: String): Boolean
    external fun RunEditor_selectedParseAndSetBestSegmentTime(self: Long, time: String): Boolean
    external fun RunEditor_selectedParseAndSetComparisonTime(self: Long, comparison: String, time: String): Boolean
    external fun RunMetadata_runId(self: Long): String
    external fun RunMetadata_platformName(self: Long): String
    external fun RunMetadata_usesEmulator(self: Long): Boolean
    external fun RunMetadata_regionName(self: Long): String
    external fun Segment_new(name: String): Long
    external fun Segment_drop(self: Long)
    external fun Segment_name(self: Long): String
    external fun Segment_icon(self: Long): String
    external fun Segment_comparison(self: Long, comparison: String): Long
    external fun Segment_personalBestSplitTime(self: Long): Long
    external fun Segment_bestSegmentTime(self: Long): Long
    external fun Segment_segmentHistory(self: Long): Long
    external fun SegmentHistory_iter(self: Long): Long
    external fun SegmentHistoryElement_index(self: Long): Int
    external fun SegmentHistoryElement_time(self: Long): Long
    external fun SegmentHistoryIter_drop(self: Long)
    external fun SegmentHistoryIter_next(self: Long): Long
    external fun SharedTimer_drop(self: Long)
    external fun SharedTimer_share(self: Long): Long
    external fun SharedTimer_read(self: Long): Long
    external fun SharedTimer_write(self: Long): Long
    external fun SplitsComponent_new(): Long
    external fun SplitsComponent_drop(self: Long)
    external fun SplitsComponent_stateAsJson(self: Long, timer: Long): String
    external fun SplitsComponent_state(self: Long, timer: Long): Long
    external fun SplitsComponent_scrollUp(self: Long)
    external fun SplitsComponent_scrollDown(self: Long)
    external fun SplitsComponent_setVisualSplitCount(self: Long, count: Long)
    external fun SplitsComponent_setSplitPreviewCount(self: Long, count: Long)
    external fun SplitsComponent_setAlwaysShowLastSplit(self: Long, alwaysShowLastSplit: Boolean)
    external fun SplitsComponent_setSeparatorLastSplit(self: Long, separatorLastSplit: Boolean)
    external fun SplitsComponentState_drop(self: Long)
    external fun SplitsComponentState_finalSeparatorShown(self: Long): Boolean
    external fun SplitsComponentState_len(self: Long): Long
    external fun SplitsComponentState_iconChange(self: Long, index: Long): String
    external fun SplitsComponentState_name(self: Long, index: Long): String
    external fun SplitsComponentState_delta(self: Long, index: Long): String
    external fun SplitsComponentState_time(self: Long, index: Long): String
    external fun SplitsComponentState_color(self: Long, index: Long): String
    external fun SplitsComponentState_isCurrentSplit(self: Long, index: Long): Boolean
    external fun SumOfBestComponent_new(): Long
    external fun SumOfBestComponent_drop(self: Long)
    external fun SumOfBestComponent_stateAsJson(self: Long, timer: Long): String
    external fun SumOfBestComponent_state(self: Long, timer: Long): Long
    external fun SumOfBestComponentState_drop(self: Long)
    external fun SumOfBestComponentState_text(self: Long): String
    external fun SumOfBestComponentState_time(self: Long): String
    external fun Time_drop(self: Long)
    external fun Time_clone(self: Long): Long
    external fun Time_realTime(self: Long): Long
    external fun Time_gameTime(self: Long): Long
    external fun Time_index(self: Long, timingMethod: Byte): Long
    external fun TimeSpan_fromSeconds(seconds: Double): Long
    external fun TimeSpan_drop(self: Long)
    external fun TimeSpan_clone(self: Long): Long
    external fun TimeSpan_totalSeconds(self: Long): Double
    external fun Timer_new(run: Long): Long
    external fun Timer_intoShared(self: Long): Long
    external fun Timer_drop(self: Long)
    external fun Timer_currentTimingMethod(self: Long): Byte
    external fun Timer_currentComparison(self: Long): String
    external fun Timer_isGameTimeInitialized(self: Long): Boolean
    external fun Timer_isGameTimePaused(self: Long): Boolean
    external fun Timer_loadingTimes(self: Long): Long
    external fun Timer_currentPhase(self: Long): Byte
    external fun Timer_getRun(self: Long): Long
    external fun Timer_cloneRun(self: Long): Long
    external fun Timer_printDebug(self: Long)
    external fun Timer_split(self: Long)
    external fun Timer_skipSplit(self: Long)
    external fun Timer_undoSplit(self: Long)
    external fun Timer_reset(self: Long, updateSplits: Boolean)
    external fun Timer_pause(self: Long)
    external fun Timer_setCurrentTimingMethod(self: Long, method: Byte)
    external fun Timer_switchToNextComparison(self: Long)
    external fun Timer_switchToPreviousComparison(self: Long)
    external fun Timer_initializeGameTime(self: Long)
    external fun Timer_uninitializeGameTime(self: Long)
    external fun Timer_pauseGameTime(self: Long)
    external fun Timer_unpauseGameTime(self: Long)
    external fun Timer_setGameTime(self: Long, time: Long)
    external fun Timer_setLoadingTimes(self: Long, time: Long)
    external fun TimerComponent_new(): Long
    external fun TimerComponent_drop(self: Long)
    external fun TimerComponent_stateAsJson(self: Long, timer: Long): String
    external fun TimerComponent_state(self: Long, timer: Long): Long
    external fun TimerComponentState_drop(self: Long)
    external fun TimerComponentState_time(self: Long): String
    external fun TimerComponentState_fraction(self: Long): String
    external fun TimerComponentState_color(self: Long): String
    external fun TimerReadLock_drop(self: Long)
    external fun TimerReadLock_timer(self: Long): Long
    external fun TimerWriteLock_drop(self: Long)
    external fun TimerWriteLock_timer(self: Long): Long
    external fun TitleComponent_new(): Long
    external fun TitleComponent_drop(self: Long)
    external fun TitleComponent_stateAsJson(self: Long, timer: Long): String
    external fun TitleComponent_state(self: Long, timer: Long): Long
    external fun TitleComponentState_drop(self: Long)
    external fun TitleComponentState_iconChange(self: Long): String
    external fun TitleComponentState_game(self: Long): String
    external fun TitleComponentState_category(self: Long): String
    external fun TitleComponentState_attempts(self: Long): Int
}
