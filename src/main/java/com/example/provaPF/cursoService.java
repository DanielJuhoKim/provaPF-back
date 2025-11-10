package com.example.provaPF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cursoService {
    @Autowired
    private cursoRepository CursoRepository;

    public List<curso> getCursos() {
        return CursoRepository.findAll();
    }

    public curso getUmCurso(Integer Id) {
        return CursoRepository.findById(Id).get();
    }

    public void registCurso(curso Curso) {
        CursoRepository.save(Curso);
    }

    public void deleteCurso(Integer iD) {
        CursoRepository.deleteById(iD);
    }

}
