package fr.partnaire.recrutement.exercice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe Stack de gestion d'une pile d'entiers
 * 
 * @author a810966
 *
 */
public class Stack {

	private static Logger LOGGER = LoggerFactory.getLogger(Stack.class);

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
		Deque<Integer> reversedDeque = new ArrayDeque<>(this.deque.size());
		this.deque.stream().forEach(reversedDeque::push);
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

	public boolean isPalindrome() {

		if (deque.isEmpty()) {
			return true;
		} else {
			Deque<Integer> reversedDeque = doReverse(new ArrayDeque<Integer>(this.deque));
			return deque.stream().allMatch((Integer i) -> i == reversedDeque.pop());
		}
	}

	public boolean canBePalindrome() {

		if (isPalindrome()) {
			return true;
		} else {
			boolean canBe = true;
			boolean casUniquePresent = false;
			Deque<Integer> copyDeque = new ArrayDeque<Integer>(this.deque);
			for (Integer i : deque) {

				if (copyDeque.isEmpty())
					return true;

				copyDeque.pop();

				if (!copyDeque.contains(i)) {
					if (!casUniquePresent) {
						casUniquePresent = true;
					} else {
						return false;
					}
				} else {
					copyDeque.remove(i);
				}
			}
			return canBe;
		}
	}
}
