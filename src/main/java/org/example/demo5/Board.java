package org.example.demo5;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    @Id
    String id;
    String BoardNm;
}
