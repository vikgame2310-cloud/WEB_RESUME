package org.example;

import org.eclipse.jetty.util.IO;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

public class Host {

    public static void host(DataBase dataBase) {

        ObjectMapper mapper =
                new ObjectMapper();

        Javalin.create(config -> {

            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> {
                    it.anyHost();
                });
            });

            config.routes.post("/registers", ctx -> {

                String json =
                        ctx.body();

                JsonNode data =
                        mapper.readTree(json);

                String email =
                        data.get("email").asText();

                String password =
                        data.get("password").asText();

                dataBase.save(
                        email,
                        password
                );

                System.out.println(json);

                ctx.status(200);
            });

        }).start(8080);

        System.out.println("Server started");
    }
}