package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import bo.Human;

public class StreamAndSortedTests {

	/**
	 * Basic stream and sorting of Integers
	 */
	@Test
	public void testSortedArrayofNumbers() {
		List<Integer> integerNumbers = new ArrayList<>();
		integerNumbers.add(2);
		integerNumbers.add(3);
		integerNumbers.add(1);
		integerNumbers.add(0);

		List<Integer> sortedintegerNumbers = integerNumbers.stream().sorted().collect(Collectors.toList());

		assertEquals((Integer) 0, sortedintegerNumbers.get(0));
		assertEquals((Integer) 1, sortedintegerNumbers.get(1));
		assertEquals((Integer) 2, sortedintegerNumbers.get(2));
		assertEquals((Integer) 3, sortedintegerNumbers.get(3));
	}

	/**
	 * stream and sorting of Integers with collect as a Collectors.toSet()
	 */
	@Test
	public void testSortedSetofNumbers() {
		List<Integer> integerNumbers = new ArrayList<>();
		integerNumbers.add(2);
		integerNumbers.add(0);
		integerNumbers.add(1);
		integerNumbers.add(0);

		Set<Integer> sortedSetintegerNumbers = integerNumbers.stream().sorted().collect(Collectors.toSet());

		assertNotNull(sortedSetintegerNumbers);
		assertEquals((Integer) 3, (Integer) sortedSetintegerNumbers.size());
	}

	/**
	 * Usage of Comparator and Comparator nulls First
	 */
	@Test
	public void testSortedSetofNumbersWithNullsFirstComparator() {
		List<Integer> integerNumbers = new ArrayList<>();
		integerNumbers.add(2);
		integerNumbers.add(0);
		integerNumbers.add(1);
		integerNumbers.add(null);

		Comparator<Integer> intComparator = Comparator.nullsFirst((n1, n2) -> (n1 - n2));

		List<Integer> sortedintegerNumbers = integerNumbers.stream().sorted(intComparator).collect(Collectors.toList());

		assertNotNull(sortedintegerNumbers);
		assertEquals((Integer) 4, (Integer) sortedintegerNumbers.size());
		assertNull(sortedintegerNumbers.get(0));
		assertEquals((Integer) 0, sortedintegerNumbers.get(1));
		assertEquals((Integer) 1, sortedintegerNumbers.get(2));
		assertEquals((Integer) 2, sortedintegerNumbers.get(3));
	}

	/**
	 * Sorting List of Objects based on member variable comparison and creating a different sorted list
	 */
	@Test
	public void testSortedArrayofHumansBasedOnName() {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("arka", 27));
		humans.add(new Human("anvita", 27));
		humans.add(new Human("aritra", 26));

		Comparator<Human> humanComparisonBasedOnName = (h1, h2) -> h1.getName().compareTo(h2.getName());

		List<Human> sortedHumans = humans.stream().sorted(humanComparisonBasedOnName).collect(Collectors.toList());
		
		assertEquals("anvita", sortedHumans.get(0).getName());
		assertEquals("aritra", sortedHumans.get(1).getName());
		assertEquals("arka", sortedHumans.get(2).getName());
	}
	
	/**
	 * Sorting Original List of Objects based on member variable comparison & then reverse sorting the same list
	 */
	@Test
	public void testSortingOriginalListAndReverseSorting() {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("arka", 27));
		humans.add(new Human("anvita", 27));
		humans.add(new Human("aritra", 26));

		Comparator<Human> humanComparisonBasedOnName = (h1, h2) -> h1.getName().compareTo(h2.getName());
		
		//Sorting
		humans.sort(humanComparisonBasedOnName);
		
		assertEquals("anvita", humans.get(0).getName());
		assertEquals("aritra", humans.get(1).getName());
		assertEquals("arka", humans.get(2).getName());
		
		//Reverse sorting
		humans.sort(humanComparisonBasedOnName.reversed());
		assertEquals("anvita", humans.get(2).getName());
		assertEquals("aritra", humans.get(1).getName());
		assertEquals("arka", humans.get(0).getName());
	}

	/**
	 * Sorting List of Objects based on member variable including Nulls
	 */
//	@Test
	public void testSortedArrayofHumansBasedOnAgeWithNullsLast() {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("arka", 27));
		humans.add(new Human("anvita", 27));
		humans.add(new Human("Samik", null));
		humans.add(new Human("aritra", 26));
		humans.add(new Human("ronny", null));

		Comparator<Human> humanComparisonBasedOnAgeNullsFirst = Comparator
				.nullsFirst((h1, h2) -> h1.getAge() - h2.getAge());

		List<Human> sortedHumans = humans.stream().sorted(humanComparisonBasedOnAgeNullsFirst)
				.collect(Collectors.toList());
		assertEquals("Samik", sortedHumans.get(0).getName());
		assertEquals("ronny", sortedHumans.get(1).getName());
		assertEquals("anvita", sortedHumans.get(2).getName());
		assertEquals("aritra", sortedHumans.get(3).getName());
		assertEquals("arka", sortedHumans.get(4).getName());
	}

}