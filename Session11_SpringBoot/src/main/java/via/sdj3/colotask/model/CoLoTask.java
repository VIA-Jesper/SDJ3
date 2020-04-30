package via.sdj3.colotask.model;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CoLoTask {

    @NotNull
    private String id;

    @NotNull
    @NotBlank
    private String description;

    private LocalDateTime dateCreated;

    private LocalDateTime dateModified;

    private boolean isCompleted;

    public CoLoTask() {
        this.id = UUID.randomUUID().toString();
        this.dateCreated = LocalDateTime.now();

    }

    public CoLoTask(@NotNull @NotBlank String description) {
        this(); // Call our first constructor
        this.description = description;
    }
}
