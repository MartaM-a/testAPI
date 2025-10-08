
package org.example.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Post {
        private Long id;
        private String title;
        private String content;
        private User user;
    }

