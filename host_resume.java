import io.javalin.Javalin;

void main() {
    Javalin app = Javalin.create().start(8080);

    app.post("/registers", ctx -> {
        String json = ctx.body();

        IO.println(json);

        ctx.status(200);
    });

    IO.println("i worked");
}