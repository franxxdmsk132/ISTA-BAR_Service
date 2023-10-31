    package com.ista.service.controller;

    import org.springframework.web.bind.annotation.*;

    import com.ista.service.entity.Cliente;
    import com.ista.service.service.ClienteService;
    import com.ista.service.utlis.GenericResponse;

    import javax.validation.Valid;
    import java.util.List;
    @CrossOrigin(origins=("http://localhost:4200"))
    @RestController
    @RequestMapping("api/cliente")
    public class ClienteController {
        private final ClienteService service;

        public ClienteController(ClienteService service) {
            this.service = service;
        }

        @GetMapping
        public GenericResponse listarClientes(){
            return this.service.listarClientes();
        }

        @PostMapping
        public GenericResponse save(@Valid @RequestBody Cliente c){
            return this.service.save(c);
        }

        @PutMapping("/{id}")
        public GenericResponse update(@PathVariable int id, @Valid @RequestBody Cliente c){
            c.setId(id);
            return this.service.save(c);
        }
    }
