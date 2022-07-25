package com.example.autographEV.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment saveComment(@RequestBody Comment comment){
        System.out.println("Comment added");
        return commentService.saveComment(comment);
    }

    @GetMapping
    public List<Comment> getAllComments(){
        System.out.println("All comments shows");
        return commentService.getAllComments();
    }
    @GetMapping("/commentId")
    public Optional<Comment> getById(@RequestParam(name = "commentId")String commentId){
        System.out.println("Comment get by Id");
        return commentService.getCommentById(commentId);
    }

    @PutMapping
    public Comment updateComment (@RequestBody Comment comment){
        System.out.println("Edie your comment");
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/commentId")
    public void deleteComment(@RequestParam(name="commentId")String commentId){
        System.out.println("Delete your comment");
        commentService.deleteComment(commentId);
    }

}
