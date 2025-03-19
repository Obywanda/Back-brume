package com.brume.mp5.portfolio.service;

import com.brume.mp5.portfolio.entity.Project;
import com.brume.mp5.portfolio.entity.User;
import com.brume.mp5.portfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private UserService userService;

    public ProjectService(ProjectRepository projectRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    public void cree(Project project){
        User user = this.userService.lireOuCreer(project.getUser());
        project.setUser(user);
        this.projectRepository.save(project);
    }

    public List<Project> rechercher() {
        return this.projectRepository.findAll();
    }

    public void supprimerProject(int id) {
        this.projectRepository.deleteById(id);
    }
}
