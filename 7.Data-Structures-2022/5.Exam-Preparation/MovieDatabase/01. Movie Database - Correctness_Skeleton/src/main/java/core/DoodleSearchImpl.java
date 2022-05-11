package core;

import models.Doodle;

import java.util.*;
import java.util.stream.Collectors;

public class DoodleSearchImpl implements DoodleSearch {

    private Map<String, Doodle> byId;
    private Map<String, Doodle> byTitle;


    public DoodleSearchImpl() {
        this.byId = new LinkedHashMap<>();
        this.byTitle = new HashMap<>();

    }

    @Override
    public void addDoodle(Doodle doodle) {
        this.byId.put(doodle.getId(), doodle);
        this.byTitle.put(doodle.getTitle(), doodle);
//        String id = doodle.getId();
//        byId.put(id, doodle);
//        byTitle.put(doodle.getTitle(), doodle);

    }

    @Override
    public void removeDoodle(String doodleId) {
        Doodle toRemove = byId.remove(doodleId);
        if (toRemove == null) {
            throw new IllegalArgumentException();
        }
        byTitle.remove(toRemove.getTitle());
    }

    @Override
    public int size() {
        return byId.size();
    }

    @Override
    public boolean contains(Doodle doodle) {
        return byId.containsKey(doodle.getId());
    }

    @Override
    public Doodle getDoodle(String id) {
        Doodle doodle = byId.get(id);
        if (doodle == null) {
            throw new IllegalArgumentException();
        }
        return doodle;
    }

    @Override
    public double getTotalRevenueFromDoodleAds() {
        return this.byId
                .values()
                .stream()
                .filter(Doodle::getIsAd)
                .mapToDouble(d -> d.getRevenue() * d.getVisits())
                .sum();
//        return addDoodles.stream().mapToDouble(v -> v.getRevenue() * v.getVisits()).sum();
    }

    @Override
    public void visitDoodle(String title) {
//        if (!byTitle.containsKey(title)) {
//            throw new IllegalArgumentException();
//        }
//        Doodle doodle = byTitle.get(title);
//        doodle.incrementVisits();
        Doodle doodle = this.byTitle.get(title);
        if (doodle == null) throw new IllegalArgumentException();
        doodle.incrementVisits();
    }

    @Override
    public Iterable<Doodle> searchDoodles(String searchQuery) {
//        return byId.values().stream().filter(d -> d.getTitle().contains(searchQuery))
//                .sorted((d1, d2) -> {
//                    int result = Boolean.compare(d2.getIsAd(), d1.getIsAd());
//                    if (result == 0) {
//                        result = Integer.compare(d1.getTitle().indexOf(searchQuery), d2.getTitle().indexOf(searchQuery));
//                    }
//                    if (result == 0) {
//                        result = Integer.compare(d2.getVisits(), d1.getVisits());
//                    }
//                    return result;
//                }).collect(Collectors.toList());
//    }
        return this.byId.values()
                .stream()
                .filter(d -> search(d, searchQuery) > -1)
                .sorted((d1, d2) -> {
                    int adsCompare = Boolean.compare(d2.getIsAd(), d1.getIsAd());
                    if (adsCompare == 0) {
                        int relevanceCompare = Integer.compare(search(d1, searchQuery), search(d2, searchQuery));
                        if (relevanceCompare == 0) {
                            return Integer.compare(d2.getVisits(), d1.getVisits());
                        }
                        return relevanceCompare;
                    }
                    return adsCompare;
                })
                .collect(Collectors.toList());
    }

    private int search(Doodle d, String searchQuery) {
        return d.getTitle().indexOf(searchQuery);
    }


    @Override
    public Iterable<Doodle> getDoodleAds() {
//        return addDoodles.stream().sorted(Comparator.comparingDouble(Doodle::getRevenue).reversed()
//                .thenComparingInt(Doodle::getVisits).reversed()).collect(Collectors.toList());
        return this.byId.values()
                .stream()
                .filter(Doodle::getIsAd)
                .sorted((d1, d2) -> {
                    int revenueCompare = Double.compare(d2.getRevenue(), d1.getRevenue());
                    if (revenueCompare == 0) {
                        return Integer.compare(d2.getVisits(), d1.getVisits());
                    }
                    return revenueCompare;
                }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Doodle> getTop3DoodlesByRevenueThenByVisits() {
        return byId.values().stream().sorted(Comparator.comparingDouble(Doodle::getRevenue)
                .thenComparingInt(Doodle::getVisits).reversed()).limit(3).collect(Collectors.toList());
//        
    }

}
