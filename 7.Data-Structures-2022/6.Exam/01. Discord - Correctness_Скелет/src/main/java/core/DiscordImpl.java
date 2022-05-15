package core;

import models.Message;

import java.util.*;
import java.util.stream.Collectors;

public class DiscordImpl implements Discord {

    private Map<String, Message> byId;
//    private Map<String, Map<String, Message>> byChannel;
    private Map<String, Set<Message>> test;

    public DiscordImpl() {
        this.byId = new LinkedHashMap<>();
//        this.byChannel = new LinkedHashMap<>();
        this.test = new LinkedHashMap<>();
    }

    @Override
    public void sendMessage(Message message) {
        String id = message.getId();
        this.byId.putIfAbsent(id, message);
        this.test.putIfAbsent(message.getChannel(), new LinkedHashSet<>());
        this.test.get(message.getChannel()).add(message);

//        this.byChannel.putIfAbsent(message.getChannel(), new LinkedHashMap<>());
//        this.byChannel.get(message.getChannel()).put(message.getId(), message);
    }

    @Override
    public boolean contains(Message message) {
        return byId.containsKey(message.getId());
    }

    @Override
    public int size() {
        return byId.size();
    }

    @Override
    public Message getMessage(String messageId) {
        if (!byId.containsKey(messageId)) {
            throw new IllegalArgumentException();
        }

        return byId.get(messageId);
    }

    @Override
    public void deleteMessage(String messageId) {
        if (!byId.containsKey(messageId)) {
            throw new IllegalArgumentException();
        }
        Message remove = byId.get(messageId);
        byId.remove(messageId);
        test.get(remove.getChannel()).remove(remove);
//        byChannel.get(remove.getChannel()).remove(messageId);
    }

    @Override
    public void reactToMessage(String messageId, String reaction) {
        if (!byId.containsKey(messageId)) {
            throw new IllegalArgumentException();
        }
        byId.get(messageId).getReactions().add(reaction);
    }

    @Override
    public Iterable<Message> getChannelMessages(String channel) {
        Set<Message> messages = test.get(channel);
        if (messages == null || messages.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return messages;
    }

    @Override
    public Iterable<Message> getMessagesByReactions(List<String> reactions) {
        return byId.values().stream().filter(m -> m.getReactions().containsAll(reactions))
                .sorted((m1, m2) -> {
                    int result = Integer.compare(m2.getReactions().size(), m1.getReactions().size());
                    if (result == 0) {
                        result = Integer.compare(m1.getTimestamp(), m2.getTimestamp());
                    }
                    return result;
                }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getMessageInTimeRange(Integer lowerBound, Integer upperBound) {
        return byId.values().stream().filter(m -> m.getTimestamp() <= upperBound && m.getTimestamp() >= lowerBound)
                .sorted((m1, m2) -> Integer.compare(test.get(m2.getChannel()).size(), test.get(m1.getChannel()).size()))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getTop3MostReactedMessages() {
        return byId.values().stream().sorted((m1, m2) -> Integer.compare(m2.getReactions().size(), m1.getReactions().size())).limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getAllMessagesOrderedByCountOfReactionsThenByTimestampThenByLengthOfContent() {
        return byId.values().stream().sorted((m1, m2) -> {
            int result = Integer.compare(m2.getReactions().size(), m1.getReactions().size());
            if (result == 0) {
                result = Integer.compare(m1.getTimestamp(), m2.getTimestamp());
            }
            if (result == 0) {
                result = Integer.compare(m1.getContent().length(), m2.getContent().length());
            }
            return result;
        }).collect(Collectors.toList());
    }
}
