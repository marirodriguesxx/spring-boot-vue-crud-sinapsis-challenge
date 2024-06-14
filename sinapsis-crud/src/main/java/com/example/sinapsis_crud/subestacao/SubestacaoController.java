package com.example.sinapsis_crud.subestacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/subestacao")
@CrossOrigin(origins = "http://localhost:5173/")
public class SubestacaoController {

    @Autowired
    private SubestacaoRepository subestacaoRepository;

    @PostMapping(path="/add")
    @ResponseBody
    public String addNewSubestacao (@RequestParam String codigo,
                                            @RequestParam String nome,
                                            @RequestParam Double latitude,
                                            @RequestParam Double longitude) {

        Subestacao subestacao = new Subestacao();
        subestacao.setCodigo(codigo);
        subestacao.setNome(nome);
        subestacao.setLatitude(latitude);
        subestacao.setLongitude(longitude);
        subestacaoRepository.save(subestacao);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Subestacao> getAllSubestacoes() {
        return subestacaoRepository.findAll();
    }
}
