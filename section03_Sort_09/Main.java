package section03_Sort_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public class Fruit implements Comparable<Fruit> {
		String name;
		int quantity;

		public Fruit(String name, int quantity) {
			this.name = name;
			this.quantity = quantity;
		}
		
		@Override
		public int compareTo(Fruit other) {
			// TODO Auto-generated method stub
			return quantity-other.quantity;
		}

		@Override
		public String toString() {
			return "Fruit [name=" + name + ", quantity=" + quantity + "]";
		}
	}

	// �⺻ Ÿ�� �������� ����
	public static void sort1() {
		int[] data = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		// data[0]���� data[9]���� �����Ͱ� �� ���ִ� ���״� ������ ���� �����Ѵ�.
		Arrays.sort(data);

		// �迭�� ���� ���� �ʰ� data[0]���� data[size-1]���� size���� �����͸� �ִٸ� ������ ���� �Ѵ�.
		// int �̿��� �ٸ� primitive Ÿ�� ������(double, char ��)�� ���ؼ��� ����
		int size = 5;
		Arrays.sort(data, 0, size);

	}

	// ��ü�� ����: ���ڿ�
	public static void sort2() {
		// primitive Ÿ�� �����Ϳ� ���������� Arrays.sort �޼���� ���ĵȴ�.
		String[] fruits = new String[] { "Pineapple", "Apple", "Orange", "Banana" };
		Arrays.sort(fruits);
		for (String name : fruits)
			System.out.print(name + " ");
	}

	// ArrayList ���� : ���ڿ�
	public static void sort3() {
		List<String> fruits = new ArrayList<String>();
		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");

		Collections.sort(fruits);

		for (String name : fruits)
			System.out.println(name);
	}

	// ��ü�� ����: ����� ���� ��ü
	public static void sort4() {
		class Fruit {
			String name;
			int quantity;

			public Fruit(String name, int quantity) {
				this.name = name;
				this.quantity = quantity;
			}
		}
		Fruit[] fruits = new Fruit[4];
		fruits[0] = new Fruit("Pineapple", 70);
		fruits[1] = new Fruit("Apple", 100);
		fruits[2] = new Fruit("Orange", 80);
		fruits[3] = new Fruit("Banana", 90);

		Arrays.sort(fruits); // => error �߻�
	}

	// ��ü�� ����: Comparable Interface, sort4 ����
	public static void sort5() {
		class Fruit implements Comparable<Fruit> {
			String name;
			int quantity;

			public Fruit(String name, int quantity) {
				this.name = name;
				this.quantity = quantity;
			}

			@Override
			public int compareTo(Fruit other) {
				// TODO Auto-generated method stub
				return name.compareTo(other.name);
			}

			@Override
			public String toString() {
				return "Fruit [name=" + name + ", quantity=" + quantity + "]";
			}

		}
		Fruit[] fruits = new Fruit[4];
		fruits[0] = new Fruit("Pineapple", 70);
		fruits[1] = new Fruit("Apple", 100);
		fruits[2] = new Fruit("Orange", 80);
		fruits[3] = new Fruit("Banana", 90);

		Arrays.sort(fruits);

		for (Fruit f : fruits)
			System.out.println(f);
	}

	// ��ü�� ����: Comparable Interface, ���������� �����ϰ� �ʹٸ�
	public static void sort6() {
		class Fruit implements Comparable<Fruit> {
			String name;
			int quantity;

			public Fruit(String name, int quantity) {
				this.name = name;
				this.quantity = quantity;
			}

			@Override
			public int compareTo(Fruit other) {
				// TODO Auto-generated method stub
				return quantity - other.quantity;
			}

			@Override
			public String toString() {
				return "Fruit [name=" + name + ", quantity=" + quantity + "]";
			}

		}
		Fruit[] fruits = new Fruit[4];
		fruits[0] = new Fruit("Pineapple", 70);
		fruits[1] = new Fruit("Apple", 100);
		fruits[2] = new Fruit("Orange", 80);
		fruits[3] = new Fruit("Banana", 90);

		Arrays.sort(fruits);

		for (Fruit f : fruits)
			System.out.println(f);
	}

	// /
	/**
	 * Comparator
	 * Comparator Ŭ������ extends�ϸ� compare �޼��带 overrding �ϴ�
	 * ���ο� �̸� ���� Ŭ������ ������ �� �� Ŭ������ ��ü�� �ϳ� �����Ѵ�.
	 */
	public static void sort7()
	{
		Fruit[] fruits = new Fruit[4];
//		fruits[0] = new Fruit("pineapple", 70);
//		fruits[1] = new Fruit("Apple", 100);
//		fruits[2] = new Fruit("Orange", 80);
//		fruits[3] = new Fruit("Banana", 90);
		
		Comparator<Fruit> nameComparator = new Comparator<Fruit>() {
			
			@Override
			public int compare(Fruit fruit1, Fruit fruit2) {
				// TODO Auto-generated method stub
				return fruit1.name.compareTo(fruit2.name);
			}
		};
		
		Comparator<Fruit> quantComparator = new Comparator<Fruit>() {
			
			@Override
			public int compare(Fruit fruit1, Fruit fruit2) {
				// TODO Auto-generated method stub
				return fruit1.quantity - fruit2.quantity;
			}
		};
		
		Arrays.sort(fruits,nameComparator);
		// or
		Arrays.sort(fruits,quantComparator);
	}

	public static void main(String args[]) {
		sort7();

	}
}
