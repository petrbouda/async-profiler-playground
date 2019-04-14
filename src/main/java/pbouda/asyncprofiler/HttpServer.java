package pbouda.asyncprofiler;

import io.helidon.webserver.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class HttpServer {

    private static final Logger LOG = LoggerFactory.getLogger(HttpServer.class);

    private static Routing createRouting() {
        StringGenerator generator = new StringGenerator();
        SafeStringGenerator safeGenerator = new SafeStringGenerator();

        return Routing.builder()
                .get("/greet", (req, resp) -> resp.send("Greetings, Helidon!"))
                .get("/generate", (req, resp) -> measure(resp, generator))
                .get("/generate-lock", (req, resp) -> measure(resp, safeGenerator))
                .build();
    }

    public static void main(final String[] args) {
        ServerConfiguration serverConfig =
                ServerConfiguration.builder()
                        .port(8080)
                        .build();

        WebServer.create(serverConfig, createRouting())
                .start()
                .thenAccept(server -> System.out.println("Started on port: " + server.port()));
    }

    private static void measure(ServerResponse resp, StringGenerator generator) {
        long start = System.nanoTime();
        resp.send(generator.generate());
        LOG.info("Measure Request: " + Duration.ofNanos(System.nanoTime()- start).toMillis());
    }
}
