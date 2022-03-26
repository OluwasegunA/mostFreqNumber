package interview;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class Verticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.post("/").handler(this::getMostOccurringWords);
        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        config().getInteger("http.port", 8080),
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );
    }

    private void getMostOccurringWords(RoutingContext routingContext) {
        try {
            String sentence = routingContext.getBodyAsJson().getString("sentence");
            JsonObject mostOccurringWords = MostOccurringWords.mostOccurringWords(sentence);
            routingContext.response()
                    .putHeader("content-type", "application/json")
                    .setStatusCode(200)
                    .end(mostOccurringWords.encode());
        } catch (Exception e) {
            routingContext.response()
                    .putHeader("content-type", "application/json")
                    .setStatusCode(500)
                    .end(new JsonObject().put("error", e.getMessage()).encode());
        }
    }
}
