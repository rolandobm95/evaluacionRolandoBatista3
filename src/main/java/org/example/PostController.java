package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/store")
    public String storePosts() {
        postService.savePostsToDatabase();
        return "Datos almacenados en la base de datos.";
    }

    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/find")
    public ResponseEntity<String> buscarPost(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String title) {
        if (id == null && title == null) {
            return ResponseEntity.badRequest().body("Debes proporcionar al menos un ID o un Título.");
        }

        Optional<Post> postEncontrado;
        if (id != null && title != null) {
            postEncontrado = postRepository.findByIdAndTitle(id, title);
        } else if (id != null) {
            postEncontrado = postRepository.findById(id);
        } else {
            postEncontrado = postRepository.findByTitle(title);
        }

        if (postEncontrado.isPresent()) {
            return ResponseEntity.ok("Datos encontrados:" + postEncontrado.get().getTitle());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
