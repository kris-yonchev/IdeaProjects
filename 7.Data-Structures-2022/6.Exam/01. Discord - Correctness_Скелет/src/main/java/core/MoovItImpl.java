package core;

import models.Route;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MoovItImpl implements MoovIt {

    private Map<String, Route> byId;
    private Map<String, Route> favorites;

    public MoovItImpl() {
        this.byId = new LinkedHashMap<>();
        this.favorites = new LinkedHashMap<>();
    }

    @Override
    public void addRoute(Route route) {
        String id = route.getId();
        if (contains(route)) {
            throw new IllegalArgumentException();
        }
        byId.putIfAbsent(id, route);
        if (route.getIsFavorite()) {
            favorites.putIfAbsent(id, route);
        }
    }

    @Override
    public void removeRoute(String routeId) {
        if (!byId.containsKey(routeId)) {
            throw new IllegalArgumentException();
        }
        byId.remove(routeId);
        favorites.remove(routeId);
    }

    @Override
    public boolean contains(Route route) {
        Route check = byId.values().stream().filter(r -> Double.compare(r.getDistance(), route.getDistance()) == 0
                && r.getLocationPoints().get(0).equals(route.getLocationPoints().get(0))
                && r.getLocationPoints().get(r.getLocationPoints().size() - 1).equals(route.getLocationPoints().get(route.getLocationPoints().size() - 1)))
                .findFirst()
                .orElse(null);
        if (check != null) {
            return true;
        }

        if (!byId.containsKey(route.getId())) {
            return false;
        }

        return byId.containsKey(route.getId());
    }

    @Override
    public int size() {
        return byId.size();
    }

    @Override
    public Route getRoute(String routeId) {
        if (!byId.containsKey(routeId)) {
            throw new IllegalArgumentException();
        }
        return byId.get(routeId);
    }

    @Override
    public void chooseRoute(String routeId) {
        if (!byId.containsKey(routeId)) {
            throw new IllegalArgumentException();
        }

        Route route = byId.get(routeId);
        route.setPopularity(route.getPopularity() + 1);
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        return byId.values().stream().filter(r -> r.getLocationPoints().contains(startPoint) && r.getLocationPoints().contains(endPoint) &&
                r.getLocationPoints().indexOf(endPoint) > r.getLocationPoints().indexOf(startPoint))
                .sorted((r1, r2) -> {
                    int result = Boolean.compare(r1.getIsFavorite(), r2.getIsFavorite());
                    if (result == 0) {
                        result = Integer.compare(r1.getLocationPoints().subList(r1.getLocationPoints().indexOf(startPoint), r1.getLocationPoints().indexOf(endPoint) + 1).size(),
                                r2.getLocationPoints().subList(r2.getLocationPoints().indexOf(startPoint), r2.getLocationPoints().indexOf(endPoint)).size() + 1);
                    }
                    if (result == 0) {
                        result = Integer.compare(r2.getPopularity(), r1.getPopularity());
                    }
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        return favorites.values().stream().filter(r -> r.getLocationPoints().contains(destinationPoint) && !r.getLocationPoints().get(0).equals(destinationPoint))
                .sorted((r1, r2) -> {
                    int result = Double.compare(r1.getDistance(), r2.getDistance());
                    if (result == 0) {
                        result = Integer.compare(r2.getPopularity(), r1.getPopularity());
                    }
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getTop5RoutesByPopularityThenByDistanceThenByCountOfLocationPoints() {
        return byId.values().stream()
                .sorted(Comparator.comparingInt(Route::getPopularity).reversed()
                        .thenComparingDouble(Route::getDistance)
                        .thenComparingInt(m -> m.getLocationPoints().size()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
