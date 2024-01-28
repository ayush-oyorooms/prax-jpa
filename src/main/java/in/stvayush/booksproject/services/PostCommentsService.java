package in.stvayush.booksproject.services;

import in.stvayush.booksproject.dtos.PostCommentDto;
import in.stvayush.booksproject.models.Post;
import in.stvayush.booksproject.models.PostComment;
import in.stvayush.booksproject.repository.PostCommentsRepository;
import in.stvayush.booksproject.repository.PostsRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostCommentsService {

    private final PostCommentsRepository postCommentsRepository;
    private final PostsRepository postsRepository;

    public void addComment(PostComment postComment, Long postId) {
        Optional<Post> referencedPost = postsRepository.findById(postId);
        if (referencedPost.isPresent()) {
            Post post = referencedPost.get();
            post.getComments().add(postComment);
            postsRepository.save(post);
//            postComment.setReferencedPost(post);
        } else {
            log.error("Post with id {} not found in db", postId);
        }
        postCommentsRepository.save(postComment);
    }

    public PostCommentDto updateComment(PostCommentDto postCommentDto)
        throws IllegalAccessException {
        Optional<PostComment> postComment = postCommentsRepository.findById(postCommentDto.getId());
        if (postComment.isPresent()) {
            PostComment comment = postComment.get();
            comment.setCommentContent(postCommentDto.getCommentContent());
            postCommentsRepository.save(comment);
        } else {
            log.info("No PostComment with id {} found in db", postCommentDto.getId());
            throw new IllegalAccessException(
                "An attempt to update non-existing data was made, aborted");
        }
        return postCommentDto;
    }

    public void removeCommentFromPost(Long commentId) {
        Optional<PostComment> postComment = postCommentsRepository.findById(commentId);
        if (postComment.isPresent()) {
            PostComment comment = postComment.get();
//            Post post = comment.getReferencedPost();
//            post.getComments().remove(comment);
//            postsRepository.save(post); // remove this comment from the post first
            postCommentsRepository.deleteById(commentId); // delete the comment from table
        } else {
            log.info("No PostComment with id {} found in db", commentId);
        }
    }
}
