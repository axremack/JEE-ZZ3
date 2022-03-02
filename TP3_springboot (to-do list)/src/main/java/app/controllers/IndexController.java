package app.controllers;

import app.entities.Category;
import app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import app.entities.Task;
import app.repositories.TaskRepository;

@Controller
public class IndexController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path="/")
    public String  getIndex(Model model) {
        return "redirect:/tasks";
    }

    @GetMapping(path="/tasks")
    public String  getAllTasks(Model model) {
        model.addAttribute("title", "To-do list");
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "allTasks";
    }

    @PostMapping(path="/tasks", params="add")
    public String createTask(@Validated Task task) {
        taskRepository.save(task); // Enregistrer la nouvelle tâche
        return "redirect:/tasks"; // Permet de passer par la fonction pour que le Model soit créé
    }

    @GetMapping(value = "/tasks/{id}")
    public String getTask(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", "Tâche " + id);
        model.addAttribute("task", taskRepository.findById(Long.valueOf(id)).get());
        return "task";
    }

    @GetMapping(value = "/tasks/{id}/edit")
    public String modifyTaskForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", "Modification de tâche " + id);
        model.addAttribute("task", taskRepository.findById(Long.valueOf(id)).get());
        model.addAttribute("categories", categoryRepository.findAll());
        return "modifyTask";
    }

    @PostMapping(path="/tasks/{id}", params="modify")
    public String modifyTask(@Validated Task task) {
        taskRepository.save(task); // Enregistrer la nouvelle tâche
        return "redirect:/tasks/{id}"; // Permet de passer par la fonction pour que le Model soit créé
    }

    @DeleteMapping(path="/tasks/{id}")
    public String deleteTask(@PathVariable("id") int id) throws Exception {
        Task t = taskRepository.findById(Long.valueOf(id)).orElseThrow(() -> new Exception("Task not found"));
        taskRepository.delete(t);
        return "redirect:/tasks";
    }

    @GetMapping(path="/tasks/new")
    public String newTask(@ModelAttribute("task") Task task, Model model) {
        model.addAttribute("title", "Ajout de tâche");
        model.addAttribute("categories", categoryRepository.findAll());
        return "createTask";
    }

}
