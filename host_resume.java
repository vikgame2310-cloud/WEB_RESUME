import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;


void main()throws Exception{


    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/registers", x -> {

        if (x.getRequestMethod().equals("OPTIONS")) {

            x.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            x.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, OPTIONS");
            x.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

            x.sendResponseHeaders(204, -1);
        } else {
            
            byte[] data = x.getRequestBody().readAllBytes();
            String rez = new String(data);

            IO.println(rez);

            x.sendResponseHeaders(200, -1);
        }
        x.close();
    });


    server.start();
    IO.println("i worked");
}
