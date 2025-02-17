    package sptech.school.aula_17_02_BD;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.tags.form.OptionsTag;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/livros")
    public class LivroController {

        @Autowired
        private LivroRepository repository;

        @PostMapping
        public Livro cadastro(@RequestBody Livro livro){
            Livro livroSalvo = repository.save(livro);
            return livroSalvo;
        }

        @GetMapping
        public List<Livro> listar(){
            List<Livro> todos = repository.findAll();
            return todos;
        }

        @GetMapping ("/{id}")
        public Livro buscarId(@PathVariable Integer id){
            Optional<Livro> possivelLivro = repository.findById(id);

            if (repository.findById(id).isPresent()){
                return possivelLivro.get();
            }else {
                return null;
            }
        }

        @PutMapping("/{id}")
        public Livro atualizar(@PathVariable Integer id, @RequestBody Livro paraAtualizar){


            if (repository.existsById(id)){
            paraAtualizar.setId(id);
            Livro livroParaAtualizar = repository.save(paraAtualizar);
            return livroParaAtualizar;
            }else{
                return null;
            }

        }
    }
