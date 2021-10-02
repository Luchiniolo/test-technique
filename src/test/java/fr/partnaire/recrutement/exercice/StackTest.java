package fr.partnaire.recrutement.exercice;

import java.util.NoSuchElementException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests de la classe Stack
 * 
 * @author a810966
 *
 */
public class StackTest {

	@Test
	public void pop_should_return_first_element() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);

		Integer valueReturned = stack.pop();
		Assertions.assertThat(valueReturned).isEqualTo(2);
	}

	@Test
	public void pop_on_empty_stack_should_fail() {
		Stack stack = new Stack();

		try {
			stack.pop();
			Assertions.fail("Une exception aurait du être levée");
		} catch (NoSuchElementException e) {
			Assertions.assertThat(e.getMessage()).isNull();
		}
	}

	@Test
	public void push_should_add_element() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);

		stack.push(3);
		Assertions.assertThat(stack.pop()).isEqualTo(3);
	}

	@Test
	public void reverse_should_reverse_stack() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		stack.reverse();

		Assertions.assertThat(stack.pop()).isEqualTo(1);
		Assertions.assertThat(stack.pop()).isEqualTo(2);
		Assertions.assertThat(stack.pop()).isEqualTo(3);
	}

	@Test
	public void shake_should_reverse_stack() {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		stack.shake();

		// difficile à tester
		Assertions.assertThat(stack.pop()).isIn(1, 2, 3);
		Assertions.assertThat(stack.pop()).isIn(1, 2, 3);
		Assertions.assertThat(stack.pop()).isIn(1, 2, 3);
	}

	@Test
	public void isPalindrome_should_be_ok() {

		Stack stack = new Stack();
		stack.push(4);
		stack.push(1);
		stack.push(1);
		stack.push(4);

		Assertions.assertThat(stack.isPalindrome()).isTrue();
	}

	@Test
	public void isPalindrome_all_same_should_be_ok() {

		Stack stack = new Stack();
		stack.push(78);
		stack.push(78);
		stack.push(78);

		Assertions.assertThat(stack.isPalindrome()).isTrue();
	}

	@Test
	public void isPalindrome_impair_should_be_ok() {

		Stack stack = new Stack();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(1);
		stack.push(0);

		Assertions.assertThat(stack.isPalindrome()).isTrue();
	}

	@Test
	public void isPalindrome_should_be_false() {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(1);

		Assertions.assertThat(stack.isPalindrome()).isFalse();
	}

	@Test
	public void canBePalindrome_should_be_ok() {

		Stack stack = new Stack();
		stack.push(4);
		stack.push(1);
		stack.push(4);
		stack.push(1);

		Assertions.assertThat(stack.canBePalindrome()).isTrue();
	}

	@Test
	public void canBePalindrome_impair_should_be_ok() {

		Stack stack = new Stack();
		stack.push(4);
		stack.push(4);
		stack.push(1);

		Assertions.assertThat(stack.canBePalindrome()).isTrue();
	}

	@Test
	public void canBePalindrome_should_be_ko() {

		Stack stack = new Stack();
		stack.push(4);
		stack.push(2);
		stack.push(4);
		stack.push(1);

		Assertions.assertThat(stack.canBePalindrome()).isFalse();
	}

	@Test
	public void canBePalindrome_one_element_should_be_ok() {

		Stack stack = new Stack();
		stack.push(4);

		Assertions.assertThat(stack.canBePalindrome()).isTrue();
	}

	@Test
	public void canBePalindrome_empty_element_should_be_ok() {

		Stack stack = new Stack();

		Assertions.assertThat(stack.canBePalindrome()).isTrue();
	}

	@Test
	public void canBePalindrome_all_same_element_should_be_ok() {

		Stack stack = new Stack();
		stack.push(4);
		stack.push(4);
		stack.push(4);
		stack.push(4);

		Assertions.assertThat(stack.canBePalindrome()).isTrue();
	}

	@Test
	public void canBePalindrome_all_different_should_be_ko() {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		Assertions.assertThat(stack.canBePalindrome()).isFalse();
	}

	/**
	 * TU qui manquait pour trouver le bug du canBePalindrome
	 */
	@Test
	public void canBePalindrome_successive_element_should_be_ok() {

		Stack stack = new Stack();
		stack.push(0);
		stack.push(0);
		stack.push(0);
		stack.push(0);
		stack.push(1);
		stack.push(1);
		stack.push(1);

		Assertions.assertThat(stack.canBePalindrome()).isTrue();
	}

}
