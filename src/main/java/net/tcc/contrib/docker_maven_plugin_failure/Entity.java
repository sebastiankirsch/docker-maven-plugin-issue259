package net.tcc.contrib.docker_maven_plugin_failure;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
public class Entity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;

    public String title;
}
