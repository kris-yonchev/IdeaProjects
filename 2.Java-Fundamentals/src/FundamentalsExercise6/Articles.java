package FundamentalsExercise6;

import java.util.*;
import java.util.stream.Collectors;

public class Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articleInfo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Article article = new Article(title, content, author);
            articleInfo.add(article);
        }
        String finalInput = scanner.nextLine();
        switch (finalInput) {
            case "title":
                articleInfo.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articleInfo.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articleInfo.sort(Comparator.comparing(Article::getAuthor));
                break;
        }
        for (Article article : articleInfo) {
            System.out.printf("%s - %s: %s\n", article.getTitle(), article.getContent(), article.getAuthor());

        }

    }

    public static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}

