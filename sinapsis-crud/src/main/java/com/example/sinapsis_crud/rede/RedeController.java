package com.example.sinapsis_crud.rede;

import com.example.sinapsis_crud.subestacao.Subestacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/rede")
public class RedeController {

    @Autowired
    private RedeRepository redeRepository;

    @PostMapping(path="/add")
    @ResponseBody
    public String addNewRede (@RequestParam Subestacao subestacao,
                              @RequestParam String codigo,
                              @RequestParam String nome,
                              @RequestParam Double tensaoNominal) {

        Rede rede = new Rede();
        rede.setSubestacao(subestacao);
        rede.setCodigo(codigo);
        rede.setNome(nome);
        rede.setTensaoNominal(tensaoNominal);
        redeRepository.save(rede);
        return "rede salva :)";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Rede> getAllRedes() {
        return redeRepository.findAll();
    }
}
