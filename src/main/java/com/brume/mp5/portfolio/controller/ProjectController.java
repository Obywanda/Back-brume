package com.brume.mp5.portfolio.controller;

import com.brume.mp5.portfolio.entity.Project;
import com.brume.mp5.portfolio.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "project", produces = APPLICATION_JSON_VALUE)
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void cree(@RequestBody Project project) {
        this.projectService.cree(project);
    }

    @GetMapping
    public @ResponseBody List<Project> rechercher(){
        return this.projectService.rechercher();
    }

    @DeleteMapping(path = "{id}")
    public void supprimerProject(@PathVariable("id") int id) {
        this.projectService.supprimerProject(id);
    }
}
