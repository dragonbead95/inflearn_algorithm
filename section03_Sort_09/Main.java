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

	// 기본 타입 데이터의 정렬
	public static void sort1() {
		int[] data = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		// data[0]에서 data[9]까지 데이터가 꽉 차있는 경우네는 다음과 같이 정렬한다.
		Arrays.sort(data);

		// 배열이 전부 차지 않고 data[0]에서 data[size-1]까지 size개의 데이터만 있다면 다음과 같이 한다.
		// int 이외의 다른 primitive 타입 데이터(double, char 등)에 대해서도 제공
		int size = 5;
		Arrays.sort(data, 0, size);

	}

	// 객체의 정렬: 문자열
	public static void sort2() {
		// primitive 타입 데이터와 마찬가지로 Arrays.sort 메서드로 정렬된다.
		String[] fruits = new String[] { "Pineapple", "Apple", "Orange", "Banana" };
		Arrays.sort(fruits);
		for (String name : fruits)
			System.out.print(name + " ");
	}

	// ArrayList 정렬 : 문자열
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

	// 객체의 정렬: 사용자 정의 객체
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

		Arrays.sort(fruits); // => error 발생
	}

	// 객체의 정렬: Comparable Interface, sort4 개선
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

	// 객체의 정렬: Comparable Interface, 재고수량으로 정렬하고 싶다면
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
	 * Comparator 클래스를 extends하며 compare 메서드를 overrding 하는
	 * 새로운 이름 없는 클래스를 정의한 후 그 클래스의 객체를 하나 생성한다.
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
