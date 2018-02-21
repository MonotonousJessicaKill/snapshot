package jielin.snapshot.service;

import jielin.snapshot.common.Result;

public interface NoteService {
    Result add(String msg, int expired);
    Result getNotes(int days);
}
