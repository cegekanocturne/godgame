package com.cegeka.nocturne.godgame;

public class IntPair {
	private int i;
	private int j;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntPair other = (IntPair) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}

	public IntPair(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}
