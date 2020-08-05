package kg.attractor.demo.controller;

import kg.attractor.demo.form.TaskForm;
import kg.attractor.demo.service.PropertiesService;
import kg.attractor.demo.service.TaskService;
import kg.attractor.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@AllArgsConstructor
@RequestMapping("/tasks")
@Controller
public class TaskController {

    private final TaskService taskService;
    private final PropertiesService propertiesService;
    private final UserService userService;

    @GetMapping
    public String getTasksByUser(Model model,Pageable pageable, Principal principal, HttpServletRequest uriBuilder){

        userService.checkUserPresence(model, principal);
        PropertiesService.constructPageable(taskService.getAllByUser(pageable, principal), propertiesService.getDefaultPageSize(), model, uriBuilder.getRequestURI());
        return "tasks";
    }

    @GetMapping("/task/{id}")
    public String getTask(@PathVariable String id, Model model, Principal principal){

        userService.checkUserPresence(model, principal);
        model.addAttribute("task", taskService.getTaskById(Long.parseLong(id)));
        return "task";
    }

    @GetMapping("/add-task")
    public String addTask(Model model, Principal principal){
        userService.checkUserPresence(model, principal);
        return "add-task";
    }

    @PostMapping
    public String addTask(@Valid TaskForm taskForm,
                          BindingResult validationResult,
                          RedirectAttributes attributes,
                          Principal principal){

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/tasks/add-task";
        }

        taskService.addTask(taskForm, principal);
        return "redirect:/tasks";
    }


    @GetMapping("/task/{id}/delete")
    public String deleteTask(@PathVariable String id){


        taskService.deleteTaskById(Long.parseLong(id));
        return "redirect:/tasks";
    }

    @GetMapping("/task/{id}/edit")
    public String editTask(@PathVariable String id, Model model, Principal principal){

        userService.checkUserPresence(model, principal);
        model.addAttribute("task", taskService.getTaskById(Long.parseLong(id)));
        return "edit-task";
    }

    @PostMapping("/task/{id}/edit")
    public String editTask(@PathVariable String id, @Valid TaskForm taskForm,
                           BindingResult validationResult,
                           RedirectAttributes attributes){

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/tasks/task/{id}/edit";
        }

        taskService.editTaskById(Long.parseLong(id), taskForm);
        return "redirect:/tasks";
    }

    @GetMapping("/task/{id}/state")
    public String editTask(@PathVariable String id){

        taskService.changeTaskState(Long.parseLong(id));
        return "redirect:/tasks";
    }
}
