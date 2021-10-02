package fr.partnaire.recrutement.exercice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

/**
 * Classe Stack de gestion d'une pile d'entiers
 * 
 * @author a810966
 *
 */
public class Stack {

	private static java.util.logging.Logger LOGGER = Logger.getLogger(Stack.class.getName());

	/** la pile */
	private Deque<Integer> deque = new ArrayDeque<>();

	/**
	 * Retourne le premier entier de la pile
	 * 
	 * @return entier sur la pile
	 * @NoSuchElementException si la pile est vide
	 */
	public Integer pop() {
		return this.deque.pop();
	}

	/**
	 * Ajoute un entier sur la pile
	 * 
	 * @param entier entier à ajouter
	 */
	public void push(Integer entier) {
		this.deque.push(entier);
	}

	/**
	 * Affiche le contenu de la pile dans les logs
	 */
	public void print() {
		LOGGER.info(String.format("Contenu de la pile : %s", this.deque));
	}

	/**
	 * inverse l'ordre des éléments de la pile
	 */
	public void reverse() {
		this.deque = doReverse(this.deque);
	}

	private Deque<Integer> doReverse(Deque<Integer> pile) {
		Deque<Integer> reversedDeque = new ArrayDeque<>(pile.size());
		pile.stream().forEach(reversedDeque::push);
		return reversedDeque;
	}

	/**
	 * Mélange les éléments de la pile
	 */
	public void shake() {
		List<Integer> list = new ArrayList<Integer>(this.deque);
		Collections.shuffle(list);
		this.deque = new ArrayDeque<Integer>(list);
	}

	/**
	 * 
	 * @return true si palindrome
	 */
	public boolean isPalindrome() {

		if (this.deque.isEmpty()) {
			return true;
		} else {
			Deque<Integer> reversedDeque = doReverse(new ArrayDeque<Integer>(this.deque));
			return this.deque.stream().allMatch((Integer i) -> i.equals(reversedDeque.pop()));
		}
	}

	/**
	 * 
	 * @return true si peut etre un palindrome
	 */
	public boolean canBePalindrome() {

		// S'il y a plus d'1 élément qui apparait en nombre impair alors ce n'est pas un palindrome potentiel
		Predicate<Long> nombreImpair = (Long count) -> count % 2 == 1;

		long nbElementsEnNombreImpair = new HashSet<>(this.deque).stream()
				.map(this::countElement)
				.filter(nombreImpair)
				.count();
		return nbElementsEnNombreImpair <= 1;

	}

	private long countElement(Integer i) {
		return this.deque.stream().filter(i::equals).count();
	}
}
