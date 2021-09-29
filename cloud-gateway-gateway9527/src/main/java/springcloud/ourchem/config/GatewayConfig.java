package springcloud.ourchem.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_ourchem",r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_ourchem2",r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
