package lcqjoyce.bbs.controller;

import lcqjoyce.bbs.dto.CommentDTO;
import lcqjoyce.bbs.dto.QuestionDTO;
import lcqjoyce.bbs.service.CommentService;
import lcqjoyce.bbs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        QuestionDTO questionDTO = questionService.selectByPrimaryKey(id);

        List<CommentDTO> commentDTOS = commentService.findAllByParentIdAndType(id);

        /*增加阅读数*/
        questionService.inView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", commentDTOS);

        return "question";
    }
}
