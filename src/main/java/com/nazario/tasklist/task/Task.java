package com.nazario.tasklist.task;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "VW_TASKS")
public class Task implements Serializable {

    static final int MAX_DESCRICAO_STATUS_SIZE = 300;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "Title is required")
    @Size(min = 1, max = 50, message = "Title size must be between 1 and 50")
    @Column(name = "TITLE")
    private String title;

    @NotNull(message = "Description is required")
    @Size(min = 1, max = 50, message = "Description size must be between 1 and 50")
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.TO_DO;

    @NotNull
    @Column(name = "DH_CREATE")
    private LocalDateTime dhCreate = LocalDateTime.now();

    public enum Status {
        TO_DO,
        DOING,
        DONE,
        ARCHIVED
    }


}
