package org.example.url_shortener;

import io.javalin.Javalin;

import java.io.*;
import java.util.Scanner;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        String fileContent = getFileContent("/home/saten/Downloads/Forum-Website-master/url_shortener/src/main/java/org/example/url_shortener/index.html");
        Javalin app = Javalin.create().start(9000);
        app.get("/", context -> context.contentType("text/html").result(fileContent));
    }

    private static String getFileContent(String filePath) throws IOException {
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        scanner.close();
        reader.close();
        return builder.toString();
    }
}
