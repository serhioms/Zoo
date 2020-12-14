package java8.composing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class ComposingZaplles {

	@Test
	public void testFunction() {
		Function<Integer, Integer> times2 = e -> e * 2;
		Function<Integer, Integer> square = e -> e * e;

		org.junit.Assert.assertEquals(32, times2.compose(square).apply(4).intValue());
		org.junit.Assert.assertEquals(64, times2.andThen(square).apply(4).intValue());
	}

	@Test
	public void testBiFunction() {
		BiFunction<String, List<Article>, List<Article>> byAuthor = (name, articles) -> articles.stream()
				.filter(a -> a.getAuthor().equals(name)).collect(Collectors.toList());

		BiFunction<String, List<Article>, List<Article>> byTag = (tag, articles) -> articles.stream()
				.filter(a -> a.getTags().contains(tag)).collect(Collectors.toList());

		System.out.println(byAuthor.apply("Tolstoy", populate()).stream().collect(Collectors.toList()));
		System.out.println(byTag.apply("and", populate()).stream().collect(Collectors.toList()));

		Function<List<Article>, List<Article>> sortByDate = articles -> articles.stream()
				.sorted((x, y) -> y.published().compareTo(x.published())).collect(Collectors.toList());

		Function<List<Article>, Optional<Article>> first = a -> a.stream().findFirst();

		Function<List<Article>, Optional<Article>> newest = first.compose(sortByDate);
		
		System.out.println(newest);
	}

	private List<Article> populate() {
		List<Article> articles = new ArrayList<>();

		articles.add(new Article("Tolstoy", "Peace and war", 1867));
		articles.add(new Article("Tolstoy", "Anna Karenina", 1878));
		articles.add(new Article("Bulgakov", "Master and Margarita", 1966));
		articles.add(new Article("Bulgakov", "Belaya gvardia", 1925));
		articles.add(new Article("Dostoevskiy", "Prestuplenie i nakazanie", 1866));
		articles.add(new Article("Dostoevskiy", "Brat'ya Karamazovi", 1880));

		return articles;
	}

	static public class Article {

		final String author;
		final String tags;
		final Integer published;

		public Article(String author, String tags, Integer published) {
			this.author = author;
			this.tags = tags;
			this.published = published;
		}

		public String getAuthor() {
			return author;
		}

		public String getTags() {
			return tags;
		}

		public Integer published() {
			return published;
		}

		@Override
		public String toString() {
			return String.format("%s: %s", author, tags);
		}

	}
}
