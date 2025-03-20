package com.brume.mp5.portfolio.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "PROJECT_PREVIEW")
public class ProjectPreview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String previewurl;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    public ProjectPreview() {
    }

    public ProjectPreview(int id, String previewurl, Project project) {
        this.id = id;
        this.previewurl = previewurl;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreviewurl() {
        return previewurl;
    }

    public void setPreviewurl(String previewurl) {
        this.previewurl = previewurl;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
