package com.brume.mp5.portfolio.service;

import com.brume.mp5.portfolio.entity.ProjectPreview;
import com.brume.mp5.portfolio.repository.ProjectPreviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectPreviewService {

    private ProjectPreviewRepository projectPreviewRepository;

    public ProjectPreviewService(ProjectPreviewRepository projectPreviewRepository) {
        this.projectPreviewRepository = projectPreviewRepository;
    }

    public void cree(ProjectPreview projectPreview) {
        this.projectPreviewRepository.save(projectPreview);
    }
}
