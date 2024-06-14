package com.example.sinapsis_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/sinapsis")
public class UserController {

    @Autowired
    private SubestacaoRepository subestacaoRepository;

    @PostMapping(path="/add")
    @ResponseBody
    public String addNewUser (@RequestParam String codigo,
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
    public @ResponseBody Iterable<Subestacao> getAllUsers() {
        return subestacaoRepository.findAll();
    }
}
