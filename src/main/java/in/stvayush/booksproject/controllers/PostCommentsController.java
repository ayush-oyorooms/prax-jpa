package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.dtos.PostCommentDto;
import in.stvayush.booksproject.models.PostComment;
import in.stvayush.booksproject.services.PostCommentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
@Slf4j
public class PostCommentsController {
    private final PostCommentsService postCommentsService;

    @PostMapping("/add")
    public void addComment(@RequestBody PostComment postComment, @RequestParam Long postId) {
        postCommentsService.addComment(postComment, postId);
    }

//    public PostCommentDto retrieveComment(@RequestParam Long commentId) {
//        return postCommentsService.
//    }

    @PutMapping("/update")
    public ResponseEntity<PostCommentDto> updateComment(@RequestBody PostCommentDto postCommentDto, @RequestParam Long commentId) {
        postCommentDto.setId(commentId);
        ResponseEntity<PostCommentDto> postCommentResponseEntity = null;
        try {
            PostCommentDto comment = postCommentsService.updateComment(postCommentDto);
            postCommentResponseEntity = new ResponseEntity<>(comment, HttpStatus.OK);
        } catch (Exception exception) {
            log.error("An error {} occurred while updating the comment", exception.toString());
            postCommentResponseEntity = new ResponseEntity<>(new PostCommentDto(), HttpStatus.NOT_FOUND);
        }
        return postCommentResponseEntity;
    }

    @DeleteMapping("/remove")
    public void removeComment(@RequestParam Long commentId) {
        postCommentsService.removeCommentFromPost(commentId);
    }
}
