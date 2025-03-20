package com.brume.mp5.portfolio.controller;


import com.brume.mp5.portfolio.entity.ProjectPreview;
import com.brume.mp5.portfolio.service.ProjectPreviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "preview", produces = APPLICATION_JSON_VALUE)
public class ProjectPreviewController {

    private ProjectPreviewService projectPreviewService;

    public ProjectPreviewController(ProjectPreviewService projectPreviewService) {
        this.projectPreviewService = projectPreviewService;
    }
    @ResponseStatus(CREATED)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void cree(@RequestBody ProjectPreview projectPreview) {
        this.projectPreviewService.cree(projectPreview);
    }
}
