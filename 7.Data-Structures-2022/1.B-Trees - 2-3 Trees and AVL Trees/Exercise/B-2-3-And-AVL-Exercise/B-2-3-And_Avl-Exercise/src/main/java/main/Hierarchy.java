package main;

import java.util.*;
import java.util.stream.Collectors;

public class Hierarchy<T> implements IHierarchy<T> {

    private HierarchyNode<T> root;
    private Map<T, HierarchyNode<T>> data;

    public Hierarchy(T element) {
        this.data = new HashMap<>();
        this.root = new HierarchyNode<>(element);
        this.data.put(element, root);
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public void add(T element, T child) {
        HierarchyNode<T> parent = assertAndGet(element);
        if (this.data.containsKey(child)) {
            throw new IllegalArgumentException();
        }

        HierarchyNode<T> toBeAdded = new HierarchyNode<>(child);
        toBeAdded.setParent(parent);
        parent.getChildren().add(toBeAdded);
        this.data.put(child, toBeAdded);
    }


    @Override
    public void remove(T element) {
        HierarchyNode<T> toBeDeleted = assertAndGet(element);
        if (toBeDeleted.getParent() == null) {
            throw new IllegalStateException();
        }
        List<HierarchyNode<T>> children = toBeDeleted.getChildren();
        HierarchyNode<T> parent = toBeDeleted.getParent();
        children.forEach(c -> c.setParent(parent));
        parent.getChildren().addAll(children);
        parent.getChildren().remove(toBeDeleted);

        this.data.remove(toBeDeleted.getValue());
    }

    @Override
    public Iterable<T> getChildren(T element) {
        HierarchyNode<T> node = assertAndGet(element);

        return node
                .getChildren()
                .stream()
                .map(HierarchyNode::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public T getParent(T element) {
        HierarchyNode<T> node = assertAndGet(element);
        return node.getParent() == null ? null : node.getParent().getValue();
    }

    @Override
    public boolean contains(T element) {
        return this.data.containsKey(element);
    }

    @Override
    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        List<T> commonElements = new ArrayList<>();
        this.data.keySet().forEach(e -> {
            if (other.contains(e)) {
                commonElements.add(e);
            }
        });
        return commonElements;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Deque<HierarchyNode<T>> deque = new ArrayDeque<>(
                    Collections.singletonList(root)
            );

            @Override
            public boolean hasNext() {
                return deque.size() > 0;
            }

            @Override
            public T next() {
                HierarchyNode<T> next = deque.poll();
                deque.addAll(next.getChildren());
                return next.getValue();
            }
        };
    }

    private HierarchyNode<T> assertAndGet(T element) {
        HierarchyNode<T> parent = this.data.get(element);
        if (parent == null) {
            throw new IllegalArgumentException();
        }
        return parent;
    }
}
