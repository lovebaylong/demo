package demo.controller;

import demo.exception.UserNotFoundException;
import demo.model.User;
import demo.repo.UserJpaRepository;
import demo.validate.CompleteInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {
    private final UserJpaRepository userJpaRepository;
    private final Validator validator;

    public UserController(UserJpaRepository userJpaRepository, Validator validator) {
        this.userJpaRepository = userJpaRepository;
        this.validator = validator;
    }

    @GetMapping("list")
    public ModelAndView list(@RequestParam(required = false, value = "name") String name) {
        User probe = new User();
        probe.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        return new ModelAndView("user/user-list")
                .addObject("name", name)
                .addObject("userList", userJpaRepository.findAll(Example.of(probe, matcher), Sort.by(Sort.Order.asc("name"))));
    }

    @GetMapping("add")
    public String add() {
        return "user/user-add";
    }

    @PostMapping("save")
    public String save(@Validated(CompleteInfo.class) User user, BindingResult bindingResult, Model model) {
        /*Set<ConstraintViolation<User>> violationSet = validator.validate(user, CompleteInfo.class);
        if (!CollectionUtils.isEmpty(violationSet)) {
            List<String> errorMessages = new ArrayList<>();
            violationSet.forEach(each -> {
                errorMessages.add(each.getMessage());
            });
            String failMessage = "用户保存失败，原因：" + StringUtils.join(errorMessages, "; ");
            log.info(failMessage);
            model.addAttribute("message", failMessage);
            model.addAttribute("user", user);
            return (null == user.getId()) ? "user/user-add" : "user/user-edit";
        }*/
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessages.add(fieldError.getDefaultMessage());
            }
            String failMessage = "用户保存失败，原因：" + StringUtils.join(errorMessages, ";");
            log.info(failMessage);
            model.addAttribute("message", failMessage);
            model.addAttribute("user", user);
            return (null == user.getId()) ? "user/user-add" : "user/user-edit";
        } else {
            userJpaRepository.save(user);
            return "redirect:/user/list";
        }
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        userJpaRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return new ModelAndView("user/user-edit").addObject("user", userJpaRepository.findById(id).orElse(null));
    }

    @GetMapping("view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        userJpaRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return new ModelAndView("user/user-view").addObject("user", userJpaRepository.findById(id).orElse(null));
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        userJpaRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userJpaRepository.deleteById(id);
        return "redirect:/user/list";
    }
}
