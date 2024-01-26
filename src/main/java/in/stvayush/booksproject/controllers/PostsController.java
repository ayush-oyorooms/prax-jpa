package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.dtos.PostDto;
import in.stvayush.booksproject.models.Post;
import in.stvayush.booksproject.services.PostsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @PostMapping("/add")
    public void addPost(@RequestBody Post post) {
        postsService.addPost(post);
    }

    @DeleteMapping("/remove")
    public void removePost(@RequestParam Long postId) {
        postsService.removePost(postId);
    }

    @GetMapping("/all")
    public List<PostDto> getAllPosts() {
        return postsService.getAllPosts();
    }
}
