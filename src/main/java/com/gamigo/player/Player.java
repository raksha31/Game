/**
 *
 */
package com.gamigo.player;

/**
 * @author Raksha
 *
 */
public class Player {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Player other = (Player) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	public Player(int id) {
		super();
		this.id = id;
	}

}
