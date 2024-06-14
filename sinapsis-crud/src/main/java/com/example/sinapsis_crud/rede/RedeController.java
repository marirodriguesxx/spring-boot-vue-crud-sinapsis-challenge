package com.example.sinapsis_crud.rede;

import com.example.sinapsis_crud.subestacao.Subestacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/rede")
@CrossOrigin(origins = "http://localhost:5173/")
public class RedeController {

    @Autowired
    private RedeRepository redeRepository;

    @PostMapping(path="/add")
    @ResponseBody
    public ResponseEntity<String> addNewRede(@RequestParam Subestacao subestacao,
                                             @RequestParam String codigo,
                                             @RequestParam String nome,
                                             @RequestParam Double tensaoNominal) {
        try {
            Rede rede = new Rede();
            rede.setSubestacao(subestacao);
            rede.setCodigo(codigo);
            rede.setNome(nome);
            rede.setTensaoNominal(tensaoNominal);
            redeRepository.save(rede);
            return new ResponseEntity<>("Rede salva :)", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path="/all")
    public ResponseEntity<Iterable<Rede>> getAllRedes() {
        try {
            return new ResponseEntity<>(redeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="/update/{id}")
    @ResponseBody
    public ResponseEntity<String> updateRede(@PathVariable Integer id,
                                             @RequestParam Subestacao subestacao,
                                             @RequestParam String codigo,
                                             @RequestParam String nome,
                                             @RequestParam Double tensaoNominal) {
        try {
            Optional<Rede> optionalRede = redeRepository.findById(id);
            if (optionalRede.isPresent()) {
                Rede rede = optionalRede.get();
                rede.setSubestacao(subestacao);
                rede.setCodigo(codigo);
                rede.setNome(nome);
                rede.setTensaoNominal(tensaoNominal);
                redeRepository.save(rede);
                return new ResponseEntity<>("Rede updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Rede not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteRede(@PathVariable Integer id) {
        try {
            if (redeRepository.existsById(id)) {
                redeRepository.deleteById(id);
                return new ResponseEntity<>("Rede deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Rede not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
