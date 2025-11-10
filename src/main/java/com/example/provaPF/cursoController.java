package com.example.provaPF;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class cursoController {
    @Autowired
    cursoService cursoService;

    @GetMapping("/curso")
    public List<curso> getCursos() {
        return cursoService.getCursos();
    }

    @PostMapping("/curso")
    public curso registerCurso(@RequestBody curso Curso) {
        cursoService.registCurso(Curso);
        return Curso;
    }

    @DeleteMapping("/curso/id")
    public curso deleteCurso(@PathVariable Integer id) {
        curso CursoDelete = cursoService.getUmCurso(id);
        if (CursoDelete != null){
            cursoService.deleteCurso(id);
            return CursoDelete;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso " + id + "não existe");
    }
}
