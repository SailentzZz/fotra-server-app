package repos.entities;

import javax.persistence.*;

@Entity(name = "Topic")
@Table(name = "\"Topic\"", schema = "public")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_topic;

    private String head;
    private String description;
    private String language;

    public Topic() {
    }
    public Topic(Integer id_topic, String head, String description, String language) {
        this.id_topic = id_topic;
        this.head = head;
        this.description = description;
        this.language = language;
    }

    public Integer getId_topic() {
        return id_topic;
    }
    public void setId_topic(Integer id_topic) {
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