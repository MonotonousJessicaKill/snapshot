package jielin.snapshot.controller.backend;

import jielin.snapshot.common.Result;
import jielin.snapshot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/note")
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping(value = "/add")
    public Result addNote(@Param("msg") String msg, @Param("expired") int expired) {
        return noteService.add(msg, expired);
    }

    @GetMapping(value = "/notes")
    public Result getNotes() {
        return noteService.getNotes(7);
    }

    @GetMapping(value = "notes/latest")
    public Result getIndex() {

        return noteService.getNotes();

    }

}
