package com.example.SpringThembnil;

import java.io.File;
import java.io.IOException;

public class   Course {
    private static String UPLOADED_FOLDER = "src/main/resources/static/image1s.jpg";
    public static void main(String[] args) {
        File file = new File(UPLOADED_FOLDER);
file.delete();
    }


    }

