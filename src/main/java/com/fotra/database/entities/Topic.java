package com.fotra.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Topic")
@Table(name = "\"Topic\"", schema = "public")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_topic")
    private String id_topic;

    private String head;
    private String description;
    private String language;

    public Topic() {
    }
    public Topic(String id_topic, String head, String description, String language) {
        this.id_topic = id_topic;
        this.head = head;
        this.description = description;
        this.language = language;
    }

    public String getId_topic() {
        return id_topic;
    }
    public void setId_topic(String id_topic) {
        this.id_topic = id_topic;
    }

    public String getHead() {
        return head;
    }
    public void setHead(String head) {
        this.head = head;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id_topic=" + id_topic +
                ", head='" + head + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}