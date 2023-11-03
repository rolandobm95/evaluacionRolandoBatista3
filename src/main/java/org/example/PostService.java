package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {
    private final String API_URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate;

    @Autowired
    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Post[] fetchPosts() {
        return restTemplate.getForObject(API_URL, Post[].class);
    }

    @Autowired
    private PostRepository postRepository;

    public void savePostsToDatabase() {
        Post[] posts = fetchPosts();
        for (Post post : posts) {
            postRepository.save(post);
        }
    }

}
