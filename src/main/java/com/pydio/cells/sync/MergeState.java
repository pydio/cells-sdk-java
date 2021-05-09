package com.pydio.cells.sync;

import com.pydio.cells.sync.fs.Fs;

import java.util.List;

public interface MergeState {
    void updateSeq(Watch w);
    List<Watch> watches(List<Fs> fsList);
}
