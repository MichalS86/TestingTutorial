package com.stelmasz.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Surface {
    private float walls;
    private float ceiling;

    public float getSurface(){
        return walls + ceiling;
    }
}
