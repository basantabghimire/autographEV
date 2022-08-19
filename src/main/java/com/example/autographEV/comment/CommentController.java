package com.example.autographEV.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment){
        System.out.println("Comment added");
        return commentService.saveComment(comment);
    }

    @GetMapping
    public List<Comment> getAllComments(){
        System.out.println("All comments shows");
        return commentService.getAllComments();
    }
    @GetMapping("/{commentId}")
    public Comment getById(@RequestParam("commentId") String commentId){
        System.out.println("Comment get by Id");
        return commentService.getCommentById(commentId);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public String noSuchElementError(){
        return "No such element found";
    }

    @PutMapping
    public Comment updateComment (@RequestBody @Valid Comment comment){
        System.out.println("Edie your comment");
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable String commentId){
        System.out.println("Delete your comment");
        commentService.deleteComment(commentId);
    }

}
