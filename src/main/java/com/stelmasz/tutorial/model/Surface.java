package com.stelmasz.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Surface {
    private float wallsSurface;
    private float ceilingSurface;


    public float getSurface(){
        return wallsSurface + ceilingSurface;
    }
}
