
package org.example.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class User {


    public Long id;
    public String username;
    public String email;
    private List<Post> posts;

    }

