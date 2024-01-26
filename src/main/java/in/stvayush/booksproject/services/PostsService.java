package in.stvayush.booksproject.services;

import in.stvayush.booksproject.dtos.PostCommentDto;
import in.stvayush.booksproject.dtos.PostDto;
import in.stvayush.booksproject.models.Post;
import in.stvayush.booksproject.models.PostComment;
import in.stvayush.booksproject.repository.PostsRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostsService {
    private final PostsRepository postsRepository;

    public void addPost(Post post) {
        try {
            postsRepository.save(post);
        } catch (Exception e) {
            log.error("An exception {} occurred while persisting Post entity {}", e, post);
        }
    }

    public void removePost(Long postId) {
        try {
            postsRepository.deleteById(postId);
        } catch (Exception exception) {
            log.error("An error {} occurred while deleting post with id {}", exception, postId);
        }
    }

    private List<PostCommentDto> retrieveCommentsFromPost(Post post) {
        List<PostCommentDto> postComments = new ArrayList<>();
        post.getComments().forEach(comment -> postComments.add(new PostCommentDto(comment.getId(), comment.getCommentContent())));
        return postComments;
    }

    public List<PostDto> getAllPosts() {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> allPosts =  postsRepository.findAll();
        allPosts.forEach(post -> postDtos.add(new PostDto(post.getId(), post.getTitle(), retrieveCommentsFromPost(post))));
        return postDtos;
    }
}
