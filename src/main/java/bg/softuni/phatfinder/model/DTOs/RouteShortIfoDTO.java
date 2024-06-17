package bg.softuni.phatfinder.model.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RouteShortIfoDTO {

    private long id;
    private String name;
    private String description;
    private String imageUrl;
}
