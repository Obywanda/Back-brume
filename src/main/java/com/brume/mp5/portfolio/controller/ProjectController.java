package com.brume.mp5.portfolio.controller;

import com.brume.mp5.portfolio.entity.Project;
import com.brume.mp5.portfolio.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "project", produces = APPLICATION_JSON_VALUE)
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void cree(@RequestBody Project project) {
        this.projectService.cree(project);
    }

    @GetMapping
    public @ResponseBody List<Project> rechercher(){
        return this.projectService.rechercher();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Project lireProject(@PathVariable("id") int id) {
        return this.projectService.lireProject(id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void supprimerProject(@PathVariable("id") int id) {
        this.projectService.supprimerProject(id);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifierProject(@PathVariable("id") int id, @RequestBody Project project) {
        this.projectService.modifierProject(id, project);

    }
}
