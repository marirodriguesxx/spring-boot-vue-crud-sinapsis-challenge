package com.example.sinapsis_crud.subestacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/subestacao")
@CrossOrigin(origins = "http://localhost:5173/")
public class SubestacaoController {

    @Autowired
    private SubestacaoRepository subestacaoRepository;

    @PostMapping(path="/add")
    @ResponseBody
    public ResponseEntity<String> addNewSubestacao (@RequestParam String codigo,
                                                    @RequestParam String nome,
                                                    @RequestParam Double latitude,
                                                    @RequestParam Double longitude) {
        try {
            Subestacao subestacao = new Subestacao();
            subestacao.setCodigo(codigo);
            subestacao.setNome(nome);
            subestacao.setLatitude(latitude);
            subestacao.setLongitude(longitude);
            subestacaoRepository.save(subestacao);
            return new ResponseEntity<>("Saved", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path="/all")
    public ResponseEntity<Iterable<Subestacao>> getAllSubestacoes() {
        try {
            return new ResponseEntity<>(subestacaoRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="/update/{id}")
    @ResponseBody
    public ResponseEntity<String> updateSubestacao(@PathVariable Integer id,
                                                   @RequestParam String codigo,
                                                   @RequestParam String nome,
                                                   @RequestParam Double latitude,
                                                   @RequestParam Double longitude) {
        try {
            Optional<Subestacao> optionalSubestacao = subestacaoRepository.findById(id);
            if (optionalSubestacao.isPresent()) {
                Subestacao subestacao = optionalSubestacao.get();
                subestacao.setCodigo(codigo);
                subestacao.setNome(nome);
                subestacao.setLatitude(latitude);
                subestacao.setLongitude(longitude);
                subestacaoRepository.save(subestacao);
                return new ResponseEntity<>("Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Subestacao not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteSubestacao(@PathVariable Integer id) {
        try {
            if (subestacaoRepository.existsById(id)) {
                subestacaoRepository.deleteById(id);
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Subestacao not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
