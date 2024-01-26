package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.models.PostComment;
import in.stvayush.booksproject.services.PostCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class PostCommentsController {
    private final PostCommentsService postCommentsService;

    @PostMapping("/add")
    public void addComment(@RequestBody PostComment postComment, @RequestParam Long postId) {
        postCommentsService.addComment(postComment, postId);
    }

    @DeleteMapping("/remove")
    public void removeComment(@RequestParam Long commentId) {
        postCommentsService.removeCommentFromPost(commentId);
    }
}
