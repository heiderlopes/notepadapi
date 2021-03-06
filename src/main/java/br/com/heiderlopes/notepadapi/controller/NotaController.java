package br.com.heiderlopes.notepadapi.controller;

import br.com.heiderlopes.notepadapi.component.NotaComponent;
import br.com.heiderlopes.notepadapi.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    @Autowired
    private NotaComponent notaComponent;

    @GetMapping
    private List<Nota> findAll() {
        return notaComponent.findAll();
    }

    @GetMapping(value = "/titulo/{titulo}")
    private Nota findAll(@PathVariable(value = "titulo") String titulo) {
        return notaComponent.buscarNota(titulo);
    }

    @PostMapping
    private void save(@RequestBody Nota nota) {
        notaComponent.salvar(nota);
    }

    @DeleteMapping
    private void deleteAll() {
        notaComponent.deleteAll();
    }
}